package id.ac.its.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.ac.its.model.DealsHistory;
import id.ac.its.service.DealsHistoryService;

@Controller
@RequestMapping("/history")
public class DealsHistoryController {

	//CEK HISTORI PENGGUNAAN DEALS
	
	@Autowired
	DealsHistoryService dealsHistoryService;

	@ResponseBody
	@GetMapping("/user/{u_id}")
	public List<DealsHistory> getUserHistory(@PathVariable("u_id") Integer u_id) {
		return dealsHistoryService.getUserHistory(u_id);
	}
	
	@ResponseBody
	@GetMapping("/restaurant/{r_id}")
	public List<DealsHistory> getRestaurantHistory(@PathVariable("r_id") Integer r_id) {
		return dealsHistoryService.getRestaurantHistory(r_id);
	}

	@ResponseBody
	@PostMapping("/check/{u_id}")
	public Map<String, Object> checkDeals(@PathVariable("u_id") Integer u_id, @RequestParam(value = "code") String code,
			@RequestParam(value = "r_id") Integer r_id, @RequestParam(value = "total_amount") Double total_amount) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("disc_amount", dealsHistoryService.checkDeals(u_id, r_id, code, total_amount));
		return map;
	}

	@ResponseBody
	@PostMapping("/user/{u_id}")
	public Map<String, Object> useDeals(@PathVariable("u_id") Integer u_id, @RequestBody DealsHistory dh) {

		Map<String, Object> map = new LinkedHashMap<>();
		dealsHistoryService.useDeals(dh, u_id);
		map.put("status", "200 (OK)");
		map.put("u_id", dh.getU_id());
		map.put("r_id", dh.getR_id());
		map.put("id", dh.getId());
		map.put("create_at", dh.getCreate_at());
		return map;
	}
}
