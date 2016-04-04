/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.AhmdsbscDtlsetting;
import com.ahm.jx.app000.vo.VoAhmdsbscDtlsetting;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author achmad.ha
 */
public interface AhmdsbscDtlsettingDao extends GenericDao<AhmdsbscDtlsetting,String>{
    
    public List<VoAhmdsbscDtlsetting> getAhmdsbscDtlsettingByVidSettingVitemcodeVitemameVdlrcode(String vidsetting,String vitemcode,String vitemname,String vdlrcode);
    
    
}
