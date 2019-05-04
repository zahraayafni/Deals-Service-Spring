package id.ac.its.model;

import java.util.Date;

public class Deals {

	Integer d_id;
	String d_code;
	String d_name;
	String d_desc;
	Integer d_type; // percent is 0 and money is 1
	Double d_amount;
	Integer d_max_val; // given the maximum value for redeemed voucher
	Integer d_min_val; // given the minimum value for transaction/using voucher
	Integer d_limit_use;
	Boolean d_limit_one_cust;
	Boolean d_new_cust_only;
	Date d_start;
	Date d_end;

	public Deals(Integer d_id, String d_name) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
	}

	public Deals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end) {
		super();
		this.d_id = d_id;
		this.d_code = d_code;
		this.d_name = d_name;
		this.d_desc = d_desc;
		this.d_type = d_type;
		this.d_amount = d_amount;
		this.d_max_val = d_max_val;
		this.d_min_val = d_min_val;
		this.d_limit_use = d_limit_use;
		this.d_limit_one_cust = d_limit_one_cust;
		this.d_new_cust_only = d_new_cust_only;
		this.d_start = d_start;
		this.d_end = d_end;
	}

	public void update(String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end) {
		this.d_code = d_code;
		this.d_name = d_name;
		this.d_desc = d_desc;
		this.d_type = d_type;
		this.d_amount = d_amount;
		this.d_max_val = d_max_val;
		this.d_min_val = d_min_val;
		this.d_limit_use = d_limit_use;
		this.d_limit_one_cust = d_limit_one_cust;
		this.d_new_cust_only = d_new_cust_only;
		this.d_start = d_start;
		this.d_end = d_end;
	}

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public String getD_code() {
		return d_code;
	}

	public void setD_code(String d_code) {
		this.d_code = d_code;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_desc() {
		return d_desc;
	}

	public void setD_desc(String d_desc) {
		this.d_desc = d_desc;
	}

	public Integer getD_type() {
		return d_type;
	}

	public void setD_type(Integer d_type) {
		this.d_type = d_type;
	}

	public Double getD_amount() {
		return d_amount;
	}

	public void setD_amount(Double d_amount) {
		this.d_amount = d_amount;
	}

	public Integer getD_max_val() {
		return d_max_val;
	}

	public void setD_max_val(Integer d_max_val) {
		this.d_max_val = d_max_val;
	}

	public Integer getD_min_val() {
		return d_min_val;
	}

	public void setD_min_val(Integer d_min_val) {
		this.d_min_val = d_min_val;
	}

	public Integer getD_limit_use() {
		return d_limit_use;
	}

	public void setD_limit_use(Integer d_limit_use) {
		this.d_limit_use = d_limit_use;
	}

	public Boolean getD_limit_one_cust() {
		return d_limit_one_cust;
	}

	public void setD_limit_one_cust(Boolean d_limit_one_cust) {
		this.d_limit_one_cust = d_limit_one_cust;
	}

	public Boolean getD_new_cust_only() {
		return d_new_cust_only;
	}

	public void setD_new_cust_only(Boolean d_new_cust_only) {
		this.d_new_cust_only = d_new_cust_only;
	}

	public Date getD_start() {
		return d_start;
	}

	public void setD_start(Date d_start) {
		this.d_start = d_start;
	}

	public Date getD_end() {
		return d_end;
	}

	public void setD_end(Date d_end) {
		this.d_end = d_end;
	}

	@Override
	public String toString() {
		return "Deals [d_id=" + d_id + ", d_code=" + d_code + ", d_name=" + d_name + ", d_desc=" + d_desc + ", d_type="
				+ d_type + ", d_amount=" + d_amount + ", d_max_val=" + d_max_val + ", d_min_val=" + d_min_val
				+ ", d_limit_use=" + d_limit_use + ", d_limit_one_cust=" + d_limit_one_cust + ", d_new_cust_only="
				+ d_new_cust_only + ", d_start=" + d_start + ", d_end=" + d_end + "]";
	}
}
