/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao.impl;

import com.ahm.jx.app000.dao.AhmdsuamTxnbookmarkDao;
import com.ahm.jx.app000.model.AhmdsuamTxnbookmark;
import com.ahm.jx.common.dao.GenericHibernateDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author achmad.ha
 */
@Repository("ahmdsuamTxnbookmarkDao")
public class AhmdsuamTxnbookmarkDaoImpl extends GenericHibernateDao<AhmdsuamTxnbookmark, String> 
    implements AhmdsuamTxnbookmarkDao{
    
}
