/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app008.util;

/**
 *
 * @author sigit
 */
public class Uam008Util {

    public static final String T = "AKTIF";
    public static final String F = "TIDAK AKTIF";
    public static final String INIT_PASSWORD = "dims";

    public static String convertStatus(String value) {
        if (value.equalsIgnoreCase("T")) {
            return "AKTIF";
        } else if (value.equalsIgnoreCase("F")) {
            return "TIDAK AKTIF";
        } else if (value.equalsIgnoreCase("AKTIF")) {
            return "T";
        } else if (value.equalsIgnoreCase("TIDAK AKTIF")) {
            return "F";
        } else {
            return null;
        }
    }

}
