package id.ac.its.model;

import java.util.Date;

public class Deals {

	Integer id;
	String code;
	String name;
	String desc;
	Integer type; // percent is 0 and money is 1
	Double amount;
	Integer max_val; // given the maximum value for redeemed voucher
	Integer min_val; // given the minimum value for transaction/using voucher
	Integer total_limit_use;
	Integer limit_use_per_user; // how many time the voucher can be redeemed by user
	Boolean limit_one_cust_only; // each user only have one chance to redeem the voucher
	Boolean new_cust_only;
	Date start;
	Date end;
	Date create_at;
	Date update_at;

	public Deals(Integer d_id, String d_name) {
		super();
		this.id = d_id;
		this.name = d_name;
	}

	public Deals(Integer d_id, String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end, Date create_at, Date update_at) {
		super();
		this.id = d_id;
		this.code = d_code;
		this.name = d_name;
		this.desc = d_desc;
		this.type = d_type;
		this.amount = d_amount;
		this.max_val = d_max_val;
		this.min_val = d_min_val;
		this.total_limit_use = d_limit_use;
		this.limit_one_cust_only = d_limit_one_cust;
		this.new_cust_only = d_new_cust_only;
		this.start = d_start;
		this.end = d_end;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public void update(String d_code, String d_name, String d_desc, Integer d_type, Double d_amount, Integer d_max_val,
			Integer d_min_val, Integer d_limit_use, Boolean d_limit_one_cust, Boolean d_new_cust_only, Date d_start,
			Date d_end, Date update_at) {
		this.code = d_code;
		this.name = d_name;
		this.desc = d_desc;
		this.type = d_type;
		this.amount = d_amount;
		this.max_val = d_max_val;
		this.min_val = d_min_val;
		this.total_limit_use = d_limit_use;
		this.limit_one_cust_only = d_limit_one_cust;
		this.new_cust_only = d_new_cust_only;
		this.start = d_start;
		this.end = d_end;
		this.update_at = update_at;
	}

	public Integer getD_id() {
		return id;
	}

	public void setD_id(Integer d_id) {
		this.id = d_id;
	}

	public String getD_code() {
		return code;
	}

	public void setD_code(String d_code) {
		this.code = d_code;
	}

	public String getD_name() {
		return name;
	}

	public void setD_name(String d_name) {
		this.name = d_name;
	}

	public String getD_desc() {
		return desc;
	}

	public void setD_desc(String d_desc) {
		this.desc = d_desc;
	}

	public Integer getD_type() {
		return type;
	}

	public void setD_type(Integer d_type) {
		this.type = d_type;
	}

	public Double getD_amount() {
		return amount;
	}

	public void setD_amount(Double d_amount) {
		this.amount = d_amount;
	}

	public Integer getD_max_val() {
		return max_val;
	}

	public void setD_max_val(Integer d_max_val) {
		this.max_val = d_max_val;
	}

	public Integer getD_min_val() {
		return min_val;
	}

	public void setD_min_val(Integer d_min_val) {
		this.min_val = d_min_val;
	}

	public Integer getD_limit_use() {
		return total_limit_use;
	}

	public void setD_limit_use(Integer d_limit_use) {
		this.total_limit_use = d_limit_use;
	}

	public Boolean getD_limit_one_cust() {
		return limit_one_cust_only;
	}

	public void setD_limit_one_cust(Boolean d_limit_one_cust) {
		this.limit_one_cust_only = d_limit_one_cust;
	}

	public Boolean getD_new_cust_only() {
		return new_cust_only;
	}

	public void setD_new_cust_only(Boolean d_new_cust_only) {
		this.new_cust_only = d_new_cust_only;
	}

	public Date getD_start() {
		return start;
	}

	public void setD_start(Date d_start) {
		this.start = d_start;
	}

	public Date getD_end() {
		return end;
	}

	public void setD_end(Date d_end) {
		this.end = d_end;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	@Override
	public String toString() {
		return "Deals [d_id=" + id + ", d_code=" + code + ", d_name=" + name + ", d_desc=" + desc + ", d_type="
				+ type + ", d_amount=" + amount + ", d_max_val=" + max_val + ", d_min_val=" + min_val
				+ ", d_limit_use=" + total_limit_use + ", d_limit_one_cust=" + limit_one_cust_only + ", d_new_cust_only="
				+ new_cust_only + ", d_start=" + start + ", d_end=" + end + ", create_at=" + create_at
				+ ", update_at=" + update_at + "]";
	}
	
}
