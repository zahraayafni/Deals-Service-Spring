package id.ac.its.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import id.ac.its.model.Deals;
import id.ac.its.model.DealsHistory;
import id.ac.its.service.DealsHistoryService;

@Service
public class DealsHistoryServiceImpl implements DealsHistoryService {
	public static List<DealsHistory> dealsHistory = new ArrayList<DealsHistory>();

	@Override
	public List<DealsHistory> getUserHistory(Integer u_id) {
		return dealsHistory.stream().filter(x -> x.getU_id() == u_id).collect(Collectors.toList());
	}

	@Override
	public Double checkDeals(Integer u_id, Integer r_id, Integer id, Double total_amount) {
		DealsHistory dealsRecord = dealsHistory.stream().filter(x -> x.getU_id() == u_id)
				.filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny().orElse(null);
		Deals deals = DealsServiceImpl.deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id)
				.findAny().orElse(null);

		Double disc_amount = 0.0;
		if (dealsRecord != null && deals != null) {
			/*
			 * Cek apakah voucher masih tersedia dan aktif? Apa tipe diskon? persen atau
			 * cashback? Apakah total_mount memenuhi min_val? Jika ya, hitung besar diskon.
			 * Apakah besar diskon melebihi max_val? Jika tidak, return besar diskon. Jika
			 * ya, besar diskon = max_val, return besar diskon
			 */
			if (dealsRecord.getCount() < deals.getLimit_use_per_user() && deals.getActive_status().equals(true)) {
				if (deals.getType() == 0) {
					// Discount by percent
					if (total_amount.compareTo(deals.getMin_val()) > 0
							|| total_amount.compareTo(deals.getMin_val()) == 0) {
						disc_amount = ((1 - (deals.getAmount() / 100)) * total_amount);
						if (disc_amount.compareTo(deals.getMax_val()) > 0) {
							disc_amount = deals.getMax_val();
						}
					}
				} else {
					// Discount by amount
					if (total_amount.compareTo(deals.getMin_val()) > 0
							|| total_amount.compareTo(deals.getMin_val()) == 0) {
						disc_amount = total_amount - deals.getAmount();
						if (disc_amount.compareTo(deals.getMax_val()) > 0) {
							disc_amount = deals.getMax_val();
						}
					}
				}
			}
		} else if (dealsRecord == null && deals != null) {
			if (deals.getActive_status().equals(true)) {
				if (deals.getType() == 0) {
					// Discount by percent
					if (total_amount.compareTo(deals.getMin_val()) > 0
							|| total_amount.compareTo(deals.getMin_val()) == 0) {
						disc_amount = ((1 - (deals.getAmount() / 100)) * total_amount);
						if (disc_amount.compareTo(deals.getMax_val()) > 0) {
							disc_amount = deals.getMax_val();
						}
					}
				} else {
					// Discount by amount
					if (total_amount.compareTo(deals.getMin_val()) > 0
							|| total_amount.compareTo(deals.getMin_val()) == 0) {
						disc_amount = total_amount - deals.getAmount();
						if (disc_amount.compareTo(deals.getMax_val()) > 0) {
							disc_amount = deals.getMax_val();
						}
					}
				}
			}
		}
		return disc_amount;
	}

	@Override
	public void useDeals(Integer u_id, Integer r_id, Integer id) {
		DealsHistory dealsRecord = dealsHistory.stream().filter(x -> x.getU_id() == u_id)
				.filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny().orElse(null);

		Deals d = DealsServiceImpl.deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id)
				.findAny().orElse(null);

		DealsServiceImpl.deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny()
				.orElse(null).setTotal_limit_use(d.getTotal_limit_use() - 1);

		if (dealsRecord != null) {
			Integer currentCount = dealsRecord.getCount();
			dealsHistory.stream().filter(x -> x.getU_id() == u_id).filter(x -> x.getR_id() == r_id)
					.filter(x -> x.getId() == id).findAny().orElse(null).setCount(currentCount + 1);
		} else {
			DealsHistory dealsH = new DealsHistory(u_id, id, r_id);
			dealsHistory.add(dealsH);
		}
	}

}
