/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsuamMstrolesDao;
import com.ahm.jx.app000.model.AhmdsuamMstroles;
import com.ahm.jx.common.dao.GenericHibernateDao;
import com.ahm.jx.common.model.AbstractBaseEntity;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad
 */
@Repository("ahmdsuamMstrolesDao")
public class AhmdsuamMstrolesDaoImpl extends GenericHibernateDao<AhmdsuamMstroles, String> 
    implements AhmdsuamMstrolesDao{

    @Override
    public List<AhmdsuamMstroles> getAllMstRoles() {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class);
        return criteria.list();
    }

    @Override
    public AhmdsuamMstroles getMstRolesByRolesId(String rolesId) {
        Criteria criteria = getCurrentSession().createCriteria(AhmdsuamMstroles.class);
        criteria.add(Restrictions.eq("rolesId", rolesId));
        return (AhmdsuamMstroles) criteria.uniqueResult();
    }
    
}
