package com.csp.service;
import com.csp.bean.Invitation;
import com.csp.dao.InvitationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationService {

    @Autowired
    private InvitationDao invitationDao;

    public boolean saveOrUpdateInvitation(Invitation invitation) {
        invitationDao.save(invitation);
        return true;
    }

    public boolean deleteInvitationById(Long invitationId) {
        invitationDao.deleteById(invitationId);
        return true;
    }

    public List<Invitation> getAllInvitations() {
        return invitationDao.findAll();
    }
}