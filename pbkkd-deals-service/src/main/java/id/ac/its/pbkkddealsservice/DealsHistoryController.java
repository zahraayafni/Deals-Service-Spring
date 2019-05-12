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

import id.ac.its.model.DealsHistory;
import id.ac.its.service.DealsHistoryService;

@RestController
@RequestMapping("/history")
public class DealsHistoryController {

	@Autowired
	DealsHistoryService dealsHistoryService;

	@ResponseBody
	@RequestMapping("/use/{u_id}")
	public List<DealsHistory> getUserHistory(@PathVariable("u_id") Integer u_id) {
		return dealsHistoryService.getUserHistory(u_id);
	}

	@RequestMapping(value = "/check/{u_id}", method = RequestMethod.POST)
	public Double checkDeals(@PathVariable("u_id") Integer u_id, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "r_id") Integer r_id, @RequestParam(value = "total_amount") Double total_amount) {
		return dealsHistoryService.checkDeals(u_id, r_id, r_id, total_amount);
	}

	@RequestMapping(value = "/use/{u_id}", method = RequestMethod.POST)
	public Map<String, Object> useDeals(@PathVariable("u_id") Integer u_id, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "r_id") Integer r_id) {

		Map<String, Object> map = new LinkedHashMap<>();
		dealsHistoryService.useDeals(u_id, r_id, id);
		map.put("result", "added");
		return map;
	}
}
