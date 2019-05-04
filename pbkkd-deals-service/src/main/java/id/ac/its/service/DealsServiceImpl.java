package id.ac.its.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import id.ac.its.model.Deals;

@Service
public class DealsServiceImpl implements DealsService {

	public static List<Deals> deals;
	DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();

	@Override
	public List<Deals> getAllDeals() {
		return deals;
	}

	@Override
	public List<Deals> getActiveDeals() {
//		String datetime = sdf.format(date);
//		Date now;
//		try {
//			now = sdf.parse(datetime);
//			return (List<Deals>) deals.stream()
//					.filter(x -> x.getD_end().compareTo(now) > 0)
//					.findAny()
//					.orElse(new Deals(0, "Not available"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public List<Deals> getExpDeals() {
//		String datetime = sdf.format(date);
//		Date now;
//		try {
//			now = sdf.parse(datetime);
//			return (List<Deals>) deals.stream()
//					.filter(x -> x.getD_end().compareTo(now) < 0)
//					.findAny()
//					.orElse(new Deals(0, "Not available"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public Deals getDeals(Integer d_id) {
		return deals.stream().filter(x -> x.getD_id() == d_id).findAny().orElse(new Deals(0, "Not available"));
	}

	@Override
	public void createDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount,
			Integer d_max_val, Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust,
			Boolean d_new_cust_only, Date d_start, Date d_end) {

		Deals deal = new Deals(d_id, d_code, d_name, d_desc, d_type, d_amount, d_max_val, d_min_val, d_limit_use,
				d_limit_one_cust, d_new_cust_only, d_start, d_end);

		deals.add(deal);

	}

	@Override
	public void updateDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount,
			Integer d_max_val, Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust,
			Boolean d_new_cust_only, Date d_start, Date d_end) {
		
		deals.stream().filter(x -> x.getD_id() == d_id).findAny()
				.orElseThrow(() -> new RuntimeException("Item not found")).update(d_code, d_name, d_desc, d_type,
						d_amount, d_max_val, d_min_val, d_limit_use, d_limit_one_cust, d_new_cust_only, d_start, d_end);

	}

	@Override
	public void deleteDeals(Integer d_id) {
		deals.removeIf((Deals u) -> u.getD_id() == d_id);
	}

}
