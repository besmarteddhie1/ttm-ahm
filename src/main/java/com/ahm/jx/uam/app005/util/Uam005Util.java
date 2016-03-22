/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app005.util;

import com.ahm.jx.uam.app005.util.*;

/**
 *
 * @author Fransisca
 */
public class Uam005Util {
    
    public static final String T = "AKTIF";
    public static final String F = "TIDAK AKTIF";
    
    public static String convertStatus(String value){
        if(value.equalsIgnoreCase("T")){
            return "AKTIF";
        }else if(value.equalsIgnoreCase("F")){
            return "TIDAK AKTIF";
        }else if(value.equalsIgnoreCase("AKTIF")){
            return "T";
        }else if(value.equalsIgnoreCase("TIDAK AKTIF")){
            return "F";        
        }else{
            return null;
        }           
    }
    
}
