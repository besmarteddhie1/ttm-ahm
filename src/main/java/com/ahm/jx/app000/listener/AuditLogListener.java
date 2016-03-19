/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.listener;

import com.ahm.jx.app000.model.AuditLog;
import com.ahm.jx.common.model.BaseAuditVersioning;
import org.hibernate.envers.RevisionListener;

/**
 *
 * @author achmad
 */
public class AuditLogListener implements RevisionListener {

    @Override
    public void newRevision(Object o) {
        AuditLog obj = (AuditLog) o;
        // sementara hardcoded dulu, nantinya ambil dari user yang sedang login
        obj.setUsername("System");        
    }

}
