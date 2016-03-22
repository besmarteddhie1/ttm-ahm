/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.AhmdsbscHdrsetting;
import com.ahm.jx.app000.vo.VoAhmdsbscDtlsetting;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author achmad.ha
 */
public interface AhmdsbscHdrsettingDao extends GenericDao<AhmdsbscHdrsetting,String>{
    
    public List<VoAhmdsbscDtlsetting> getAhmdsbscDtlsettingByVidsettingVitemcodeVdlrcode(String vidsetting,String vitemcode,String vdlrcode);
    
}
