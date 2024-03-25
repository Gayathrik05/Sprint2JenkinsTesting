package com.csp.dao;
 
import com.csp.bean.Department;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
	@Query(value="select * from tbl_department where region_id=?",nativeQuery=true)
	public List<Department> findByRegionId(long regionId);

}