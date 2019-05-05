package id.ac.its.pbkkddealsservice;

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
	public List<Deals> getAllDeals(){
		return dealsService.getAllDeals();
	}
	
	@RequestMapping("/active")
	public List<Deals> getActiveDeals(){
		return dealsService.getActiveDeals();
	}
	
	@RequestMapping("/exp")
	public List<Deals> getExpDeals(){
		return dealsService.getExpDeals();
	}
	
	@RequestMapping(value = "/use/{d_code}", method = RequestMethod.POST)
	public Map<String, Object> useDeals(@PathVariable("d_code") String d_code){
		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.useDeals(d_code);
		map.put("result", "used");
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/{id}")
	public Deals getDeals(@PathVariable("id") Integer d_id){
		return dealsService.getDeals(d_id);
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, Object> createDeals(
			@RequestParam(value = "d_id") Integer d_id,
			@RequestParam(value = "d_code") String d_code,
			@RequestParam(value = "d_name") String d_name,
			@RequestParam(value = "d_desc") String d_desc,
			@RequestParam(value = "d_type") Integer d_type,
			@RequestParam(value = "d_amount") Double d_amount,
			@RequestParam(value = "d_max_val") Integer d_max_val,
			@RequestParam(value = "d_min_val") Integer d_min_val,
			@RequestParam(value = "d_limit_use") Integer d_limit_use,
			@RequestParam(value = "d_limit_one_cust") Boolean d_limit_one_cust,
			@RequestParam(value = "d_new_cust_only") Boolean d_new_cust_only,
			@RequestParam(value = "d_start") String d_start,
			@RequestParam(value = "d_end") String d_end,
			@RequestParam(value = "create_at") String create_at) {
		
		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.createDeals(d_id, d_code, d_name, d_desc, d_type, d_amount, d_max_val, d_min_val, d_limit_use,
				d_limit_one_cust, d_new_cust_only, d_start, d_end, create_at);
		map.put("result", "added");
		return map;
		
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Map<String, Object> updateDeals(
			@RequestParam(value = "d_id") Integer d_id,
			@RequestParam(value = "d_code") String d_code,
			@RequestParam(value = "d_name") String d_name,
			@RequestParam(value = "d_desc") String d_desc,
			@RequestParam(value = "d_type") Integer d_type,
			@RequestParam(value = "d_amount") Double d_amount,
			@RequestParam(value = "d_max_val") Integer d_max_val,
			@RequestParam(value = "d_min_val") Integer d_min_val,
			@RequestParam(value = "d_limit_use") Integer d_limit_use,
			@RequestParam(value = "d_limit_one_cust") Boolean d_limit_one_cust,
			@RequestParam(value = "d_new_cust_only") Boolean d_new_cust_only,
			@RequestParam(value = "d_start") String d_start,
			@RequestParam(value = "d_end") String d_end,
			@RequestParam(value = "update_at") String update_at) {
		Map<String, Object> map = new LinkedHashMap<>();
		dealsService.updateDeals(d_id, d_code, d_name, d_desc, d_type, d_amount, d_max_val, d_min_val, d_limit_use,
				d_limit_one_cust, d_new_cust_only, d_start, d_end, update_at);
		map.put("result", "updated");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteDeals(
			@PathVariable("id") Integer d_id) {
		Map<String, Object> map = new LinkedHashMap<>();   
	    dealsService.deleteDeals(d_id);    
	    map.put("result", "deleted");
	    return map;
	}
	
}
