package com.csp.service;
 
import com.csp.bean.Department;
import com.csp.bean.Project;
import com.csp.dao.DepartmentDao;
import com.csp.dao.ProjectDao;
import com.csp.dto.ProjectDTO;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
public class ProjectService {
 
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private DepartmentDao departmentDao;
 
	@Autowired
	private Project project;
	@Autowired
	private Department department;
 
	public boolean saveOrUpdateProject(ProjectDTO projectdto) {
		project.setProjectId(projectdto.getProjectId());
		project.setProjectName(projectdto.getProjectName());
		project.setStartDate(projectdto.getStartDate());
		project.setEndDate(projectdto.getEndDate());
		department = departmentDao.findById(projectdto.getDepartment()).get();
		project.setDepartment(department);
 
		projectDao.save(project);
		return true;
	}
 
	public boolean deleteProjectById(Long projectId) {
		projectDao.deleteById(projectId);
		return true;
	}
 
	public List<ProjectDTO> getAllProjects() {
 
		Iterator<Project> iterator = projectDao.findAll().iterator();
		List<ProjectDTO> proList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Project project = iterator.next();
 
			ProjectDTO projectdto = new ProjectDTO();
			projectdto.setProjectId(project.getProjectId());
			projectdto.setProjectName(project.getProjectName());
			projectdto.setStartDate(project.getStartDate());
			projectdto.setEndDate(project.getEndDate());
			projectdto.setDepartment(project.getDepartment().getDepartmentId());
			projectdto.setDepartmentName(project.getDepartment().getDepartmentName());
			proList.add(projectdto);
 
		}
		return proList;
	}
 
	public List<ProjectDTO> getProject(long projectId) {
		Project project = projectDao.findById(projectId).get();
		ArrayList<ProjectDTO> proList = new ArrayList<>();
		ProjectDTO projectdto = new ProjectDTO();
		projectdto.setProjectId(project.getProjectId());
		projectdto.setProjectName(project.getProjectName());
		projectdto.setStartDate(project.getStartDate());
		projectdto.setEndDate(project.getEndDate());
		projectdto.setDepartment(project.getDepartment().getDepartmentId());
		projectdto.setDepartmentName(project.getDepartment().getDepartmentName());
		proList.add(projectdto);
		return proList;
	}
	public List<ProjectDTO> getParticular(long departmentId) {
 
		Iterator<Project> iterator = projectDao.findByProjectId(departmentId).iterator();
		List<ProjectDTO> projectList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Project project = iterator.next();
			ProjectDTO projectdto = new ProjectDTO();
			projectdto.setProjectId(project.getProjectId());
			projectdto.setProjectName(project.getProjectName());
			projectdto.setStartDate(project.getStartDate());
			projectdto.setEndDate(project.getEndDate());
			projectdto.setDepartment(project.getDepartment().getDepartmentId());
			projectdto.setDepartmentName(project.getDepartment().getDepartmentName());

 
			projectList.add(projectdto);
		}
		return projectList;
	}

}