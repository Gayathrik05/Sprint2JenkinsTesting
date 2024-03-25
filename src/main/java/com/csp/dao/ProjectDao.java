package com.csp.dao;
 
import com.csp.bean.Project;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ProjectDao extends JpaRepository<Project, Long> {
	@Query(value="select * from tbl_project where department_id=?",nativeQuery=true)
	public List<Project> findByProjectId(long departmentId);

}