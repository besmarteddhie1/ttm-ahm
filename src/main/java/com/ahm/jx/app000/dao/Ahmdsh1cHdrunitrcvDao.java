/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.Ahmdsh1cHdrunitrcv;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author laurentinus
 */
public interface Ahmdsh1cHdrunitrcvDao extends GenericDao<Ahmdsh1cHdrunitrcv, String> {
    public Ahmdsh1cHdrunitrcv getHdrunitrcv(String vidshiplist, String vidAhmdsbscMstdlrcode);
}
