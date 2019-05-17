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
import id.ac.its.repository.DealsRepository;
import id.ac.its.service.DealsService;
import javassist.NotFoundException;

@Service
public class DealsServiceImpl implements DealsService {
	@Autowired
	DealsRepository dealsRepository;

	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	Date date = new Date();

	/* GET METHODS */

	@Override
	public List<Deals> getAllDeals() {
		return dealsRepository.findAll();
	}

	@Override
	public List<Deals> getActiveDeals() {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			return dealsRepository.findAllActiveDeals(now);
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
			return dealsRepository.findAllExpDeals(now);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Deals> getAllDealsByRestaurant(Integer r_id) {
		return dealsRepository.findAllDealsByRestaurant(r_id);
	}

	@Override
	public List<Deals> getActiveDealsByRestaurant(Integer r_id) {
		String datetime = sdf.format(date);
		Date now;
		try {
			now = sdf.parse(datetime);
			return dealsRepository.findAllActiveDealsByRestaurant(r_id, now);
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
			return dealsRepository.findAllExpDealsByRestaurant(r_id, now);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Deals getDeals(Integer r_id, Integer id) {
		return dealsRepository.findADealsByRestaurant(r_id, id);
	}

	@Override
	public Deals createDeals(Deals deals, Integer r_id) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		try {
			deals.setCreate_at(sdf.parse(sdf.format(timestamp)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deals.setR_id(r_id);
		return dealsRepository.save(deals);
	}

	@Override
	public Deals updateDeals(Deals dealsReq, Integer r_id, Integer id) {
		Deals deals = dealsRepository.findADealsByRestaurant(r_id, id);
		if (deals != null) {
			deals.update(dealsReq.getCode(), dealsReq.getName(), dealsReq.getDescription(), dealsReq.getType(),
					dealsReq.getAmount(), dealsReq.getMax_val(), dealsReq.getMin_val(), dealsReq.getTotal_limit_use(),
					dealsReq.getLimit_use_per_user(), dealsReq.getNew_cust_only(), dealsReq.getActive_status(),
					dealsReq.getStart(), dealsReq.getEnd_time());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			try {
				deals.setUpdate_at(sdf.parse(sdf.format(timestamp)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deals = dealsRepository.save(deals);
			return deals;
		}
		return deals;
	}

	@Override
	public Deals deleteDeals(Integer r_id, Integer id) {
		Deals deals = dealsRepository.findADealsByRestaurant(r_id, id);
		if(deals != null) {
			deals.setActive_status(false);
			deals = dealsRepository.save(deals);
			return deals;
		}
		return deals;
	}

	@Override
	public Deals getDealsByCode(Integer r_id, String code) {
		return dealsRepository.findADealsRestaurantByCode(r_id, code);
	}

}
