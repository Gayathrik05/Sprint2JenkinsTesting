package com.csp.dao;
 
import com.csp.bean.User;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserDao extends JpaRepository<User, Long> {
	@Query(value="select * from tbl_user where user_type='employee'",nativeQuery=true)
	List<User> viewAllEmployees();
}