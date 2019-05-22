package edu.nus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "leave_details")
public class LeaveDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "leave_category")
    @NotEmpty
	private String leaveCategory;
	
	@Column(name = "apply_reason")
	@NotNull
	private String applyReason;
	
	@Column(name = "reject_reason")
	private String rejReason;
	
	@NotNull
	private String status;
	
	private int overtimeHrs;
	
	private Date startDate;
	private Date endDate;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "emp_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	private Employee employee;
	 
	public LeaveDetail() {
		super();
	}
	public LeaveDetail(long id, @NotEmpty String leaveCategory, @NotNull String applyReason, String rejReason,
			@NotNull String status, int overtimeHrs, Employee employee) {
		super();
		this.id = id;
		this.leaveCategory = leaveCategory;
		this.applyReason = applyReason;
		this.rejReason = rejReason;
		this.status = status;
		this.overtimeHrs = overtimeHrs;
		this.employee = employee;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLeaveCategory() {
		return leaveCategory;
	}
	public void setLeaveCategory(String leaveCategory) {
		this.leaveCategory = leaveCategory;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getRejReason() {
		return rejReason;
	}
	public void setRejReason(String rejReason) {
		this.rejReason = rejReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOvertimeHrs() {
		return overtimeHrs;
	}
	public void setOvertimeHrs(int overtimeHrs) {
		this.overtimeHrs = overtimeHrs;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "LeaveDetail [id=" + id + ", leaveCategory=" + leaveCategory + ", applyReason=" + applyReason
				+ ", rejReason=" + rejReason + ", status=" + status + ", overtimeHrs=" + overtimeHrs + ", startDate="
				+ startDate + ", endDate=" + endDate + ", employee=" + employee + "]";
	}
	 
	 
}

