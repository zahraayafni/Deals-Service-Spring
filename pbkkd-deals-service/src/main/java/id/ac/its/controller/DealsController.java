package id.ac.its.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.ac.its.model.Deals;
import id.ac.its.pbkkddealsservice.JwtDecode;
import id.ac.its.service.DealsService;

@Controller
@RequestMapping("/deals")
public class DealsController {

	@Autowired
	DealsService dealsService;

	@ResponseBody
	@GetMapping("")
	public List<Deals> getAllDeals() {
		return dealsService.getAllDeals();
	}

	@ResponseBody
	@GetMapping("/active")
	public List<Deals> getActiveDeals() {
		return dealsService.getActiveDeals();
	}

	@ResponseBody
	@GetMapping("/exp")
	public List<Deals> getExpDeals() {
		return dealsService.getExpDeals();
	}

	@ResponseBody
	@GetMapping("/{r_id}")
	public List<Deals> getAllDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getAllDealsByRestaurant(r_id);
	}

	@ResponseBody
	@GetMapping("/{r_id}/active")
	public List<Deals> getActiveDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getActiveDealsByRestaurant(r_id);
	}

	@ResponseBody
	@GetMapping("/{r_id}/exp")
	public List<Deals> getExpDealsByRestaurant(@PathVariable("r_id") Integer r_id) {
		return dealsService.getExpDealsByRestaurant(r_id);
	}

	@ResponseBody
	@GetMapping("/{r_id}/{id}")
	public Deals getDeals(@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id) {
		return dealsService.getDeals(r_id, id);
	}

	@ResponseBody
	@GetMapping("/{r_id}/code")
	public Deals getDealsByCode(@PathVariable("r_id") Integer r_id, @RequestParam("code") String code) {
		return dealsService.getDealsByCode(r_id, code);
	}

	@ResponseBody
	@PostMapping("/{r_id}")
	public Map<String, Object> createDeals(@RequestHeader("Authorization") String token,
			@PathVariable("r_id") Integer r_id, @RequestBody Deals deals) {
		Map<String, Object> map = new LinkedHashMap<>();

		JwtDecode decode = new JwtDecode();

		if (decode.chekRole("Admin", token) != null || decode.chekRole("Restaurant", token) != null) {
			dealsService.createDeals(deals, r_id);

			map.put("status", "200 (OK)");
			map.put("id", deals.getId());
			map.put("r_id", r_id);
			map.put("code", deals.getCode());
			map.put("name", deals.getName());
			map.put("description", deals.getDescription());
			map.put("type", deals.getType());
			map.put("amount", deals.getAmount());
			map.put("max_val", deals.getMax_val());
			map.put("min_val", deals.getMin_val());
			map.put("total_limit_use", deals.getTotal_limit_use());
			map.put("limit_use_per_user", deals.getLimit_use_per_user());
			map.put("new_cust_only", deals.getNew_cust_only());
			map.put("active_status", deals.getActive_status());
			map.put("start", deals.getStart());
			map.put("end_time", deals.getEnd_time());
		}

		return map;
	}

	@ResponseBody
	@PutMapping("/{r_id}/{id}")
	public Map<String, Object> updateDeals(@RequestHeader("Authorization") String token,
			@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id, @RequestBody Deals deals) {
		Map<String, Object> map = new LinkedHashMap<>();
		JwtDecode decode = new JwtDecode();

		if (decode.chekRole("Admin", token) != null || decode.chekRole("Restaurant", token) != null) {
			dealsService.updateDeals(deals, r_id, id);
			map.put("status", "200 (OK)");
			map.put("id", id);
			map.put("r_id", r_id);
			map.put("code", deals.getCode());
			map.put("name", deals.getName());
			map.put("description", deals.getDescription());
			map.put("type", deals.getType());
			map.put("amount", deals.getAmount());
			map.put("max_val", deals.getMax_val());
			map.put("min_val", deals.getMin_val());
			map.put("total_limit_use", deals.getTotal_limit_use());
			map.put("limit_use_per_user", deals.getLimit_use_per_user());
			map.put("new_cust_only", deals.getNew_cust_only());
			map.put("active_status", deals.getActive_status());
			map.put("start", deals.getStart());
			map.put("end_time", deals.getEnd_time());
		}
		return map;
	}

	@ResponseBody
	@DeleteMapping("/{r_id}/{id}")
	public Map<String, Object> deleteDeals(@RequestHeader("Authorization") String token,
			@PathVariable("r_id") Integer r_id, @PathVariable("id") Integer id) {
		Map<String, Object> map = new LinkedHashMap<>();

		JwtDecode decode = new JwtDecode();

		if (decode.chekRole("Admin", token) != null || decode.chekRole("Restaurant", token) != null) {
			dealsService.deleteDeals(r_id, id);
			map.put("result", "deleted");
		}
		return map;
	}
	
	@ResponseBody
	@PostMapping("admin")
	public Map<String, Object> checkAdminRole(@RequestHeader("Authorization") String token) {
		Map<String, Object> map = new LinkedHashMap<>();
		JwtDecode decode = new JwtDecode();
		
		Integer adminId = decode.chekRole("Admin", token);
		
		map.put("userId", adminId);
		return map;
	}

	
	@ResponseBody
	@PostMapping("restaurant")
	public Map<String, Object> checkRestaurantRole(@RequestHeader("Authorization") String token) {
		JwtDecode decode = new JwtDecode();
		Map<String, Object> map = new LinkedHashMap<>();
		
		Integer resId = decode.chekRole("Restaurant", token);
		map.put("userId", resId);
		return map;
	}
	
	@ResponseBody
	@PostMapping("customer")
	public Map<String, Object> checkCustomerRole(@RequestHeader("Authorization") String token) {
		JwtDecode decode = new JwtDecode();
		Map<String, Object> map = new LinkedHashMap<>();
		
		Integer custId = decode.chekRole("Customer", token);
		map.put("userId", custId);
		return map;
	}


}
