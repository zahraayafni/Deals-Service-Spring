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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import id.ac.its.model.DealsHistory;
import id.ac.its.pbkkddealsservice.JwtDecode;
import id.ac.its.service.DealsHistoryService;

@Controller
@RequestMapping("/history")
public class DealsHistoryController {

	// CEK HISTORI PENGGUNAAN DEALS

	@Autowired
	DealsHistoryService dealsHistoryService;

	@ResponseBody
	@GetMapping("/user")
	public List<DealsHistory> getUserHistory(@RequestHeader("Authorization") String token) throws Exception {
		JwtDecode decode = new JwtDecode();

		DecodedJWT jwt = decode.verifyToken(token);
		System.out.println(jwt);
		Claim u_id = jwt.getClaim("userid");
		Integer custId = u_id.asInt();
		
		if (custId != null) {
			return dealsHistoryService.getUserHistory(custId);
		}
		return null;
	}

	@ResponseBody
	@GetMapping("/restaurant")
	public List<DealsHistory> getRestaurantHistory(@RequestHeader("Authorization") String token) throws Exception {
		JwtDecode decode = new JwtDecode();

		DecodedJWT jwt = decode.verifyToken(token);
		Claim u_id = jwt.getClaim("userid");
		Integer resId = u_id.asInt();
		
		if (resId != null) {
			return dealsHistoryService.getRestaurantHistory(resId);
		}
		return null;
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
	@PostMapping("/user")
	public Map<String, Object> useDeals(@RequestHeader("Authorization") String token, @RequestBody DealsHistory dh) throws Exception {

		Map<String, Object> map = new LinkedHashMap<>();
		JwtDecode decode = new JwtDecode();

		DecodedJWT jwt = decode.verifyToken(token);
		Claim u_id = jwt.getClaim("userid");
		Integer custId = u_id.asInt();
		
		if (custId != null) {
			dealsHistoryService.useDeals(dh, custId);
			map.put("status", "200 (OK)");
			map.put("u_id", dh.getU_id());
			map.put("r_id", dh.getR_id());
			map.put("id", dh.getId());
			map.put("create_at", dh.getCreate_at());
			return map;
		}
		return null;
	}
}
