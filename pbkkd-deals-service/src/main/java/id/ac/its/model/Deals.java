package id.ac.its.model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "deals")
@Table(name = "deals")
public class Deals {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	Integer id;
	@Column(name = "r_id", nullable = false)
	Integer r_id; // id for restaurant
	@Column(name = "code", nullable = false)
	String code;
	@Column(name = "name")
	String name;
	@Column(name = "description")
	String description;
	@Column(name = "type")
	Integer type; // percent is 0 and money is 1
	@Column(name = "amount")
	Double amount;
	@Column(name = "max_val")
	Double max_val; // given the maximum value for redeemed voucher
	@Column(name = "min_val")
	Double min_val; // given the minimum value for transaction/using voucher
	@Column(name = "total_limit_use")
	Integer total_limit_use;
	@Column(name = "limit_use_per_user")
	Integer limit_use_per_user; // how many time the voucher can be redeemed by user
	@Column(name = "new_cust_only")
	Boolean new_cust_only;
	@Column(name = "active_status")
	Boolean active_status;
	@Column(name = "start", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date start;
	@Column(name = "end_time", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date end_time;
	@Column(name = "create_at", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date create_at;
	@Column(name = "update_at", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	Date update_at;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Deals(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Deals(Integer r_id, String code, String name, String description, Integer type, Double amount,
			Double max_val, Double min_val, Integer total_limit_use, Integer limit_use_per_user, Boolean new_cust_only,
			Boolean active_status, Date start, Date end_time) {
		super();
		this.r_id = r_id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.max_val = max_val;
		this.min_val = min_val;
		this.total_limit_use = total_limit_use;
		this.limit_use_per_user = limit_use_per_user;
		this.new_cust_only = new_cust_only;
		this.active_status = active_status;
		this.start = start;
		this.end_time = end_time;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		try {
			this.create_at = sdf.parse(sdf.format(timestamp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Deals() {
		// TODO Auto-generated constructor stub
	}

	public void update(String code, String name, String description, Integer type, Double amount, Double max_val,
			Double min_val, Integer total_limit_use, Integer limit_use_per_user, Boolean new_cust_only,
			Boolean active_status, Date start, Date end_time) {

		this.code = code;
		this.name = name;
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.max_val = max_val;
		this.min_val = min_val;
		this.total_limit_use = total_limit_use;
		this.limit_use_per_user = limit_use_per_user;
		this.new_cust_only = new_cust_only;
		this.active_status = active_status;
		this.start = start;
		this.end_time = end_time;

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try {
			this.update_at = sdf.parse(sdf.format(timestamp));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getR_id() {
		return r_id;
	}

	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getMax_val() {
		return max_val;
	}

	public void setMax_val(Double max_val) {
		this.max_val = max_val;
	}

	public Double getMin_val() {
		return min_val;
	}

	public void setMin_val(Double min_val) {
		this.min_val = min_val;
	}

	public Integer getTotal_limit_use() {
		return total_limit_use;
	}

	public void setTotal_limit_use(Integer total_limit_use) {
		this.total_limit_use = total_limit_use;
	}

	public Integer getLimit_use_per_user() {
		return limit_use_per_user;
	}

	public void setLimit_use_per_user(Integer limit_use_per_user) {
		this.limit_use_per_user = limit_use_per_user;
	}

	public Boolean getNew_cust_only() {
		return new_cust_only;
	}

	public void setNew_cust_only(Boolean new_cust_only) {
		this.new_cust_only = new_cust_only;
	}

	public Boolean getActive_status() {
		return active_status;
	}

	public void setActive_status(Boolean active_status) {
		this.active_status = active_status;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
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
		return "Deals [id=" + id + ", r_id=" + r_id + ", code=" + code + ", name=" + name + ", description="
				+ description + ", type=" + type + ", amount=" + amount + ", max_val=" + max_val + ", min_val="
				+ min_val + ", total_limit_use=" + total_limit_use + ", limit_use_per_user=" + limit_use_per_user
				+ ", new_cust_only=" + new_cust_only + ", active_status=" + active_status + ", start=" + start
				+ ", end_time=" + end_time + ", create_at=" + create_at + ", update_at=" + update_at + "]";
	}

}
