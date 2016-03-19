/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app001.dao;

import com.ahm.jx.app000.model.AhmdsbscMstdlrcode;
import com.ahm.jx.common.dao.GenericDao;
import com.ahm.jx.uam.app001.vo.Uam001VoAhmdsbscMstdlrcode;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hendra.fs
 */
public interface Uam001AhmdsbscMstdlrcodeDao extends GenericDao<AhmdsbscMstdlrcode, String> {

    public AhmdsbscMstdlrcode findByDealerCode(String dealerCode);

    public int getPagingCountAhmdsbscMstdlrcode(Map<String, Object> filters);

    public List<Uam001VoAhmdsbscMstdlrcode> getPagingDataAhmdsbscMstdlrcode(int first, int pageSize,
            String sortField, String sortOrder, Map<String, Object> filters);
}
