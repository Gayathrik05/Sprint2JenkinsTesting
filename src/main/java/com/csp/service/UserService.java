package com.csp.service;
 
import com.csp.bean.Department;
 
import com.csp.bean.Project;
 
import com.csp.bean.Region;
 
import com.csp.bean.User;
 
import com.csp.dao.DepartmentDao;
 
import com.csp.dao.ProjectDao;
 
import com.csp.dao.RegionDao;
 
import com.csp.dao.UserDao;
import com.csp.dto.UserDTO;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
 
public class UserService {
 
	@Autowired
 
	private UserDao userDao;
 
	@Autowired
 
	private Department department;
 
	@Autowired
 
	private DepartmentDao departmentDAO;
 
	@Autowired
 
	private Region region;
 
	@Autowired
 
	private RegionDao regdao;
 
	@Autowired
 
	private ProjectDao projectdao;
 
	public boolean saveOrUpdateUser(UserDTO userdto) {
 
		User user = new User();
 
		user.setUserId(userdto.getUserId());
 
		user.setUserFirstName(userdto.getUserFirstName());
 
		user.setUserLastName(userdto.getUserLastName());
 
		user.setUserEmailId(userdto.getUserEmailId());
 
		user.setUserPassword(userdto.getUserPassword());
 
		user.setUserType(userdto.getUserType());
 
		user.setUserMobileNumber(userdto.getUserMobileNumber());
 
		department = departmentDAO.findById(userdto.getDepartment()).get();
 
		user.setDepartment(department);
 
		region = regdao.findById(userdto.getRegion()).get();
 
		user.setRegion(region);
 
		List<Long> projectId = userdto.getProject();
 
		if (projectId != null && !projectId.isEmpty()) {
 
			List<Project> projects = projectdao.findAllById(projectId);
 
			user.setProject(projects);
 
		}
 
		userDao.save(user);
 
		return true;
 
	}
 
	public boolean deleteUserById(Long userId) {
 
		userDao.deleteById(userId);
 
		return true;
 
	}
 
	public List<User> getAllUsers() {
 
		return userDao.findAll();
 
	}

 
	public List<UserDTO> getAllEmployees() {
		Iterator<User> iterator = userDao.viewAllEmployees().iterator();
		List<UserDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {

 
			User user = iterator.next();
			UserDTO userdto = new UserDTO();
			if(user.getDepartment()!=null || user.getRegion()!=null)
			{
			userdto.setUserId(user.getUserId());
			userdto.setUserFirstName(user.getUserFirstName());
 
			userdto.setUserLastName(user.getUserLastName());
 
			userdto.setUserEmailId(user.getUserEmailId());
 
			userdto.setUserPassword(user.getUserPassword());
 
			userdto.setUserType(user.getUserType());
			userdto.setUserMobileNumber(user.getUserMobileNumber());
		userdto.setDepartment(user.getDepartment().getDepartmentId());
		userdto.setDepartmentName(user.getDepartment().getDepartmentName());
		userdto.setRegion(user.getRegion().getRegionId());
		userdto.setRegionName(user.getRegion().getRegionName());



 
			userList.add(userdto);
			}
		}
		return userList;


	}

public List<UserDTO> getEmployeesToMap() {
		Iterator<User> iterator = userDao.viewAllEmployees().iterator();
		List<UserDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			User user = iterator.next();
			UserDTO userdto = new UserDTO();

			if(user.getDepartment()==null || user.getRegion()==null)
			{
				userdto.setUserId(user.getUserId());
				userdto.setUserFirstName(user.getUserFirstName());
 
				userdto.setUserLastName(user.getUserLastName());
 
				userdto.setUserEmailId(user.getUserEmailId());
 
				userdto.setUserPassword(user.getUserPassword());
 
				userdto.setUserType(user.getUserType());
				userdto.setUserMobileNumber(user.getUserMobileNumber());
				userList.add(userdto);

			}
		}
		return userList;


	}
 
 
}