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

@Entity(name = "deals_history")
@Table(name = "deals_history")
public class DealsHistory {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dh_id", nullable = false)
	Integer dh_id;
	@Column(name = "u_id", nullable = false)
	Integer u_id;
	@Column(name = "id", nullable = false)
	Integer id;
	@Column(name = "r_id", nullable = false)
	Integer r_id;
	@Column(name = "count")
	Integer count;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_at", columnDefinition="DATETIME")
	Date create_at;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
	public DealsHistory() {
		super();
	}

	public DealsHistory(Integer r_id, Integer id) {
		super();
		this.id = id;
		this.r_id = r_id;
	}

	public Integer getU_id() {
		return u_id;
	}
	
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
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
		
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public Date getCreate_at() {
		return create_at;
	}
	
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	@Override
	public String toString() {
		return "DealsHistory [u_id=" + u_id + ", id=" + id + ", r_id=" + r_id + ", count=" + count + ", create_at="
				+ create_at + "]";
	}	

}
