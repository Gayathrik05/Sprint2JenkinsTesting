package com.csp.dao;
import com.csp.bean.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationDao extends JpaRepository<Invitation, Long> {
}