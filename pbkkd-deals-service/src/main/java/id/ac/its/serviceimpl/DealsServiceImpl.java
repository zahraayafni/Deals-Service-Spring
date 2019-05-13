package id.ac.its.serviceimpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import id.ac.its.model.Deals;
import id.ac.its.service.DealsService;

@Service
public class DealsServiceImpl implements DealsService {

	public static List<Deals> deals = new ArrayList<Deals>();
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	Date date = new Date();

	/* GET METHODS */

	@Override
	public List<Deals> getAllDeals() {
		return deals;
	}

	@Override
	public List<Deals> getActiveDeals() {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			List<Deals> result = deals.stream().filter(deal -> deal.getEnd().compareTo(now) > 0)
					.filter(x -> x.getActive_status().equals(true)).collect(Collectors.toList());
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Deals> getExpDeals() {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			for (Deals d : deals.stream().filter(deal -> deal.getEnd().compareTo(now) < 0)
					.collect(Collectors.toList())) {
				d.setActive_status(false);
			}
			List<Deals> result = deals.stream().filter(x -> x.getActive_status().equals(false))
					.collect(Collectors.toList());
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Deals> getAllDealsByRestaurant(Integer r_id) {
		List<Deals> result = deals.stream().filter(x -> x.getR_id() == r_id).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<Deals> getActiveDealsByRestaurant(Integer r_id) {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			List<Deals> result = deals.stream().filter(x -> x.getR_id() == r_id)
					.filter(deal -> deal.getEnd().compareTo(now) > 0).filter(x -> x.getActive_status().equals(true))
					.collect(Collectors.toList());
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Deals> getExpDealsByRestaurant(Integer r_id) {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			for (Deals d : deals.stream().filter(x -> x.getR_id() == r_id)
					.filter(deal -> deal.getEnd().compareTo(now) < 0).collect(Collectors.toList())) {
				d.setActive_status(false);
			}
			List<Deals> result = deals.stream().filter(x -> x.getR_id() == r_id)
					.filter(x -> x.getActive_status().equals(false)).collect(Collectors.toList());
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deals getDeals(Integer r_id, Integer id) {
		return deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny().orElse(null);
	}

	@Override
	public void createDeals(Integer id, Integer r_id, String code, String name, String desc, Integer type,
			Double amount, Double max_val, Double min_val, Integer total_limit_use, Integer limit_use_per_user,
			Boolean new_cust_only, Boolean active_status, String start, String end) {
		Date starts;
		Date ends;

		try {
			starts = sdf.parse(start);
			ends = sdf.parse(end);

			Deals deal = new Deals(id, r_id, code, name, desc, type, amount, max_val, min_val, total_limit_use,
					limit_use_per_user, new_cust_only, active_status, starts, ends);

			deals.add(deal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateDeals(Integer id, Integer r_id, String code, String name, String desc, Integer type,
			Double amount, Double max_val, Double min_val, Integer total_limit_use, Integer limit_use_per_user,
			Boolean new_cust_only, Boolean active_status, String start, String end) {
		Date starts;
		Date ends;

		try {
			starts = sdf.parse(start);
			ends = sdf.parse(end);

			deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny()
					.orElseThrow(() -> new RuntimeException("Item not found")).update(code, name, desc, type, amount,
							max_val, min_val, total_limit_use, limit_use_per_user, new_cust_only,
							active_status, starts, ends);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteDeals(Integer r_id, Integer id) {
		deals.stream().filter(x -> x.getR_id() == r_id).filter(x -> x.getId() == id).findAny()
				.orElseThrow(() -> new RuntimeException("Item not found")).setActive_status(false);
	}

}
