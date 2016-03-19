/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmjxuamMstrolesDao;
import com.ahm.jx.app000.model.AhmjxuamMstroles;
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
@Repository("ahmjxuamMstrolesDao")
public class AhmjxuamMstrolesDaoImpl extends GenericHibernateDao<AhmjxuamMstroles, String>
        implements AhmjxuamMstrolesDao {

    @Override
    public List<AhmjxuamMstroles> getAllMstRoles() {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class);
        return criteria.list();
    }

    @Override
    public AhmjxuamMstroles getMstRolesByRolesId(String rolesId) {
        Criteria criteria = getCurrentSession().createCriteria(AhmjxuamMstroles.class);
        criteria.add(Restrictions.eq("rolesId", rolesId));
        return (AhmjxuamMstroles) criteria.uniqueResult();
    }

}
