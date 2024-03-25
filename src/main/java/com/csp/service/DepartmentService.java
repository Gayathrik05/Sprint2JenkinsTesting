package com.csp.service;
 

import com.csp.bean.Department;
import com.csp.bean.Region;
import com.csp.dao.DepartmentDao;
import com.csp.dao.RegionDao;
import com.csp.dto.DepartmentDTO;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
@Service
public class DepartmentService {
 
	@Autowired
	private DepartmentDao departmentDao;
 
	@Autowired
	private  Department deptObj;
 
	@Autowired
	private Region region;
 
	@Autowired
	private RegionDao regdao;
 
	public boolean saveOrUpdateDepartment(DepartmentDTO departmentdto) {
 
		deptObj.setDepartmentId(departmentdto.getDepartmentId());
		deptObj.setDepartmentName(departmentdto.getDepartmentName());
		region = regdao.findById(departmentdto.getRegion()).get();
		deptObj.setRegion(region);
 
		departmentDao.save(deptObj);
		return true;
	}
 
	public boolean deleteDepartmentById(Long departmentId) {
		departmentDao.deleteById(departmentId);
		return true;
	}
	
	public List<DepartmentDTO> getAllDepartments() {
 
		Iterator<Department> iterator = departmentDao.findAll().iterator();
		List<DepartmentDTO> userList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Department dept2 = iterator.next();
			DepartmentDTO departmentdto = new DepartmentDTO();
			departmentdto.setDepartmentId(dept2.getDepartmentId());
			departmentdto.setDepartmentName(dept2.getDepartmentName());
			departmentdto.setRegion(dept2.getRegion().getRegionId());
			departmentdto.setRegionName(dept2.getRegion().getRegionName());
 
			userList.add(departmentdto);
		}
		return userList;
	}
 
	public List<DepartmentDTO> getDepartment(Long departmentId) {
		Department department = departmentDao.findById(departmentId).get();
 
		ArrayList<DepartmentDTO> depList = new ArrayList<>();
		DepartmentDTO departmentdto=new DepartmentDTO();
		departmentdto.setDepartmentId(department.getDepartmentId());
		departmentdto.setDepartmentName(department.getDepartmentName());
		departmentdto.setRegion(department.getRegion().getRegionId());
		departmentdto.setRegionName(department.getRegion().getRegionName());
		depList.add(departmentdto);
 
		return depList;
	}

	public List<DepartmentDTO> getParticular(long regionId) {
 
		Iterator<Department> iterator = departmentDao.findByRegionId(regionId).iterator();
		List<DepartmentDTO> depList = new ArrayList<>();
		while (iterator.hasNext()) {
 
			Department dept = iterator.next();
			DepartmentDTO departmentdto = new DepartmentDTO();
			departmentdto.setDepartmentId(dept.getDepartmentId());
			departmentdto.setDepartmentName(dept.getDepartmentName());
			departmentdto.setRegion(dept.getRegion().getRegionId());
			departmentdto.setRegionName(dept.getRegion().getRegionName());
 
			depList.add(departmentdto);
		}
		return depList;
	}

 
}