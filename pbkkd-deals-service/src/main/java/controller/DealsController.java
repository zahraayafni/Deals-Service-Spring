package controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.ac.its.model.Deals;
import id.ac.its.service.DealsService;

@RestController
@RequestMapping("/deals")
public class DealsController {

	@Autowired
	DealsService dealsService;

	@ResponseBody
	@RequestMapping("")
	public List<Deals> getAllDeals() {
		return dealsService.getAllDeals();
	}

	@RequestMapping("/active")
	public List<Deals> getActiveDeals() {
		return dealsService.getActiveDeals();
	}

	@RequestMapping("/exp")
	public List<Deals> getExpDeals() {
		return dealsService.getExpDeals();
	}

	@RequestMapping("/{r_id}")
	public List<Deals> getAllDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getAllDealsByRestaurant(r_id);
	}

	@RequestMapping("/{r_id}/active")
	public List<Deals> getActiveDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getActiveDealsByRestaurant(r_id);
	}
	
	@RequestMapping("/{r_id}/exp")
	public List<Deals> getExpDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getExpDealsByRestaurant(r_id);
	}

	@ResponseBody
	@RequestMapping("/{r_id}/{id}")
	public Deals getDeals(@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id) {
		return dealsService.getDeals(r_id, id);
	}

	@ResponseBody
	@RequestMapping(value = "/{r_id}", method = RequestMethod.POST)
	public Map<String, Object> createDeals(@PathVariable("r_id") Integer r_id,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "code") String code, @RequestParam(value = "name") String name,
			@RequestParam(value = "desc") String desc, @RequestParam(value = "type") Integer type,
			@RequestParam(value = "amount") Double amount, @RequestParam(value = "max_val") Double max_val,
			@RequestParam(value = "min_val") Double min_val,
			@RequestParam(value = "total_limit_use") Integer total_limit_use,
			@RequestParam(value = "limit_use_per_user") Integer limit_use_per_user,
			@RequestParam(value = "new_cust_only") Boolean new_cust_only,
			@RequestParam(value = "active_status") Boolean active_status,
			@RequestParam(value = "start") String start, @RequestParam(value = "end") String end
			) {

		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.createDeals(id, r_id, code, name, desc, type, amount, max_val, min_val, total_limit_use,
				limit_use_per_user, new_cust_only, active_status, start, end);
//		map.put("result", "added");
		map.put("status", "200 (OK)");
		map.put("id", id);
		map.put("r_id", r_id);
		map.put("code", code);
		map.put("name", name);
		map.put("desc", desc);
		map.put("type", type);
		map.put("amount", amount);
		map.put("max_val", max_val);
		map.put("min_val", min_val);
		map.put("total_limit_use", total_limit_use);
		map.put("limit_use_per_user", limit_use_per_user);
		map.put("new_cust_only", new_cust_only);
		map.put("active_status", active_status);
		map.put("start", start);
		map.put("end", end);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{r_id}/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updateDeals(@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id,
			@RequestParam(value = "code") String code, @RequestParam(value = "name") String name,
			@RequestParam(value = "desc") String desc, @RequestParam(value = "type") Integer type,
			@RequestParam(value = "amount") Double amount, @RequestParam(value = "max_val") Double max_val,
			@RequestParam(value = "min_val") Double min_val,
			@RequestParam(value = "total_limit_use") Integer total_limit_use,
			@RequestParam(value = "limit_use_per_user") Integer limit_use_per_user,
			@RequestParam(value = "new_cust_only") Boolean new_cust_only,
			@RequestParam(value = "active_status") Boolean active_status,
			@RequestParam(value = "start") String start, @RequestParam(value = "end") String end) {
		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.updateDeals(id, r_id, code, name, desc, type, amount,
				max_val, min_val, total_limit_use, limit_use_per_user, new_cust_only,
				active_status, start, end);
//		map.put("result", "updated");
		map.put("status", "200 (OK)");
		map.put("id", id);
		map.put("r_id", r_id);
		map.put("code", code);
		map.put("name", name);
		map.put("desc", desc);
		map.put("type", type);
		map.put("amount", amount);
		map.put("max_val", max_val);
		map.put("min_val", min_val);
		map.put("total_limit_use", total_limit_use);
		map.put("limit_use_per_user", limit_use_per_user);
		map.put("new_cust_only", new_cust_only);
		map.put("active_status", active_status);
		map.put("start", start);
		map.put("end", end);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{r_id}/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteDeals(@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id) {
		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.deleteDeals(r_id, id);
		map.put("result", "deleted");
		return map;
	}

}
