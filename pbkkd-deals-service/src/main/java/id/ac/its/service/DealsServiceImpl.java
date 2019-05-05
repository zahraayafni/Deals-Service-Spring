package id.ac.its.service;

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

@Service
public class DealsServiceImpl implements DealsService {

	public static List<Deals> deals = new ArrayList<Deals>();
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	Date date = new Date();

	@Override
	public List<Deals> getAllDeals() {
//		for(Deals deal : deals) {
//			System.out.println("uuu");
//			System.out.println(deal.getD_end());
//			System.out.println(deal.getD_start());
//		}
		return deals;
	}

	@Override
	public List<Deals> getActiveDeals() {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			List<Deals> result = deals.stream()                
	                .filter(deal -> deal.getD_end().compareTo(now) > 0)
	                .collect(Collectors.toList()); 
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
			List<Deals> result = deals.stream()                
	                .filter(deal -> deal.getD_end().compareTo(now) < 0)
	                .collect(Collectors.toList()); 
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deals getDeals(Integer d_id) {
		return deals.stream().filter(x -> x.getD_id() == d_id).findAny().orElse(new Deals(0, "Not available"));
	}

	@Override
	public void createDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val, Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust,
			Boolean d_new_cust_only, String d_start, String d_end, String create_at) {

		Date start;
		Date end;
		Date create;
		
		try {
			start 	= sdf.parse(d_start);
			end		= sdf.parse(d_end);
			create 	= sdf.parse(create_at);
			
			Deals deal = new Deals(d_id, d_code, d_name, d_desc, d_type, d_amount, d_max_val, d_min_val, d_limit_use, d_limit_one_cust, d_new_cust_only, start, end, create, null);

			deals.add(deal);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateDeals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val, Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust,
			Boolean d_new_cust_only, String d_start, String d_end, String update_at) {
		
		Date start;
		Date end;
		Date update;
		
		try {
			start 	= sdf.parse(d_start);
			end		= sdf.parse(d_end);
			update	= sdf.parse(update_at);
			
			deals.stream().filter(x -> x.getD_id() == d_id).findAny()
			.orElseThrow(() -> new RuntimeException("Item not found")).update(d_code, d_name, d_desc, d_type,
					d_amount, d_max_val, d_min_val, d_limit_use, d_limit_one_cust, d_new_cust_only, start, end, update);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDeals(Integer d_id) {
		deals.removeIf((Deals u) -> u.getD_id() == d_id);
	}

	@Override
	public void useDeals(String d_code) {
		Deals res = deals.stream().filter(x -> x.getD_code() == d_code).findAny().orElse(null);
		res.setD_limit_use(res.getD_limit_use()-1);
	}

}
