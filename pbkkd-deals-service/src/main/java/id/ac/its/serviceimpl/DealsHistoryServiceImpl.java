package id.ac.its.serviceimpl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.its.model.Deals;
import id.ac.its.model.DealsHistory;
import id.ac.its.repository.DealsHistoryRepository;
import id.ac.its.repository.DealsRepository;
import id.ac.its.service.DealsHistoryService;

@Service
public class DealsHistoryServiceImpl implements DealsHistoryService {
	@Autowired
	DealsHistoryRepository dealsHistoryRepository;
	
	@Autowired
	DealsRepository dealsRepository;
	
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

	@Override
	public List<DealsHistory> getUserHistory(Integer u_id) {
		return dealsHistoryRepository.findAllUserHistory(u_id);
	}

	@Override
	public Double checkDeals(Integer u_id, Integer r_id, Integer id, Double total_amount) {
		DealsHistory dealsRecord = dealsHistoryRepository.findSpecificUserHistory(u_id, r_id, id);
		Deals deals = dealsRepository.findADealsByRestaurant(r_id, id);
		
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
	public DealsHistory useDeals(DealsHistory dealsHistory, Integer u_id) {
		DealsHistory dealsRecord = dealsHistoryRepository.findSpecificUserHistory(u_id, dealsHistory.getR_id(), dealsHistory.getId());

		Deals d = dealsRepository.findADealsByRestaurant(dealsHistory.getR_id(), dealsHistory.getId());
		d.setTotal_limit_use(d.getTotal_limit_use() - 1);
		d = dealsRepository.save(d);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date current = null;

		try {
			current = sdf.parse(sdf.format(timestamp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (dealsRecord != null) {
			Integer currentCount = dealsHistory.getCount();
			dealsHistory.setCount(currentCount + 1);
			dealsHistory.setCreate_at(current);
		} else {
			dealsHistory.setU_id(u_id);
			dealsHistory.setCount(1);
			dealsHistory.setCreate_at(current);
		}
		return dealsHistory = dealsHistoryRepository.save(dealsHistory);
		
	}

}
