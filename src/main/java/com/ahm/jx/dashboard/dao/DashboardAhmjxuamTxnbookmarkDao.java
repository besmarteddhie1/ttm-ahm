/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.dashboard.dao;

import com.ahm.jx.app000.model.AhmjxuamTxnbookmark;
import com.ahm.jx.app000.vo.VoAhmjxuamMstmenus;
import com.ahm.jx.common.dao.GenericDao;
import java.util.List;

/**
 *
 * @author sigit
 */
public interface DashboardAhmjxuamTxnbookmarkDao extends GenericDao<AhmjxuamTxnbookmark, String> {

    public List<VoAhmjxuamMstmenus> getMenusBookmark(String username);

    public List<VoAhmjxuamMstmenus> getMenusBookmarkDefault(String username);

    public String getBookMarkVid(String username, String applicationId);

}
