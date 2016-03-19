/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.dao;

import com.ahm.jx.app000.model.Ahmdsh1cMstmotor;
import com.ahm.jx.common.dao.GenericDao;

/**
 *
 * @author laurentinus
 */
public interface Ahmdsh1cMstmotorDao extends GenericDao<Ahmdsh1cMstmotor, String> {
    public Ahmdsh1cMstmotor getMstmotor(String vframenum, String venginenum, String vidAhmdsbscMstdlrcode);
    public Ahmdsh1cMstmotor getMstmotor(String vid, int iver);
}
