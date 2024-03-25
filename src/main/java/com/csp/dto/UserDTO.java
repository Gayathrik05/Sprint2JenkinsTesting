package com.csp.dto;
 
import java.util.ArrayList;
 
import java.util.List;
  
public class UserDTO {
 
	private Long userId;
 
	private String userFirstName;
 
	private String userLastName;
 
	private String userEmailId;
 
	private String userPassword;
 
	private String userType;
 
	private Long userMobileNumber;
 
	private long department;
	private String departmentName;

 
	private long region;
	private String regionName;
 
 
	private List<Long> project = new ArrayList<>();
 
	public UserDTO() {
		super();
	
	}
 
	public UserDTO(Long userId, String userFirstName, String userLastName, String userEmailId, String userPassword,
			String userType, Long userMobileNumber, long department, String departmentName, long region,
			String regionName, List<Long> project) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailId = userEmailId;
		this.userPassword = userPassword;
		this.userType = userType;
		this.userMobileNumber = userMobileNumber;
		this.department = department;
		this.departmentName = departmentName;
		this.region = region;
		this.regionName = regionName;
		this.project = project;
	}
 
	public Long getUserId() {
		return userId;
	}
 
	public void setUserId(Long userId) {
		this.userId = userId;
	}
 
	public String getUserFirstName() {
		return userFirstName;
	}
 
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
 
	public String getUserLastName() {
		return userLastName;
	}
 
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
 
	public String getUserEmailId() {
		return userEmailId;
	}
 
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
 
	public String getUserPassword() {
		return userPassword;
	}
 
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
 
	public String getUserType() {
		return userType;
	}
 
	public void setUserType(String userType) {
		this.userType = userType;
	}
 
	public Long getUserMobileNumber() {
		return userMobileNumber;
	}
 
	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
 
	public long getDepartment() {
		return department;
	}
 
	public void setDepartment(long department) {
		this.department = department;
	}
 
	public String getDepartmentName() {
		return departmentName;
	}
 
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
 
	public long getRegion() {
		return region;
	}
 
	public void setRegion(long region) {
		this.region = region;
	}
 
	public String getRegionName() {
		return regionName;
	}
 
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
 
	public List<Long> getProject() {
		return project;
	}
 
	public void setProject(List<Long> project) {
		this.project = project;
	}
 
	
 
}