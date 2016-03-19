/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.app000.model;

import com.ahm.jx.common.model.BaseAuditVersioning;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author laurentinus
 */
@Entity
@Table(name = "AHMDSH1C_DTLUNITSPKSO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"VID_AHMDSH1C_HDRUNITSPK", "VNOSO", "VID_AHMDSBSC_MSTDLRCODE"}))
public class Ahmdsh1cDtlunitspkso extends BaseAuditVersioning implements Serializable{
    @ManyToOne(targetEntity=Ahmdsh1cHdrunitspk.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_HDRUNITSPK",referencedColumnName="VID")
    private Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk;
    /*
    @Column(name="VID_AHMDSH1C_HDRUNITSPK",length=64,nullable=false)
    private String vidAhmdsh1cHdrunitspk;
    */
    @Column(name="VID_AHMDSH1C_MSTTYPECLR",length=64, nullable=false)
    private String vidAhmdsh1cMsttypeclr;
    
    @ManyToOne(targetEntity=Ahmdsh1cMsttypeclr.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTTYPECLR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr;
    
    @Column(name="VNOSO",length=50, nullable=false)
    private String vnoso;
    
    @Column(name="VID_AHMDSH1C_MSTMOTOR",length=64)
    private String vidAhmdsh1cMstmotor;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstmotor.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSH1C_MSTMOTOR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstmotor ahmdsh1cMstmotor;
    
    @Column(name="VIDSLSIDPRG1",length=64)
    private String vidslsidprg1;
    
    @ManyToOne(targetEntity=AhmdspimHdrslsprg.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VIDSLSIDPRG1",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdspimHdrslsprg ahmdspimHdrslsprg1;
    
    @Column(name="VIDSLSIDPRG2",length=64)
    private String vidslsidprg2;
    
    @ManyToOne(targetEntity=AhmdspimHdrslsprg.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VIDSLSIDPRG2",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdspimHdrslsprg ahmdspimHdrslsprg2;
    
    @Column(name="VFLALOKASI",length=1)
    private String vflalokasi;
    
    @Column(name="VFLINDENT",length=1)
    private String vflindent;
    
    @Column(name="DSO", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dso;
    
    @Column(name="VIDPEMBELI",length=64)
    private String vidpembeli;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstprospek.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VIDPEMBELI",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstprospek ahmdsmunMstprospekPembeli;
    
    @Column(name="MTANDAJADI",precision=20,scale=4)
    private BigDecimal mtandajadi;
        
    @Column(name="VJENISJUAL",length=1)
    private String vjenisjual;
    
    @Column(name="VJENISBAYAR",length=64)
    private String vjenisbayar;
    
    @ManyToOne(targetEntity=AhmdsbscDtlsetting.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VJENISBAYAR",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscDtlsetting ahmdsbscDtlsetting;
    
    @Column(name="VID_AHMDSPIM_MSTFINCOY",length=64)
    private String vidAhmdspimMstfincoy;
    
    @ManyToOne(targetEntity=AhmdspimMstfincoy.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSPIM_MSTFINCOY",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdspimMstfincoy ahmdspimMstfincoy;
    
    @Column(name="VPONOFC",length=50)
    private String vponofc;
    
    @Column(name="DPOFINCOY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dpofincoy;
    
    @Column(name="IJMLCICILAN")
    private Integer ijmlcicilan;
    
    @Column(name="MCICILAN",precision=20,scale=4)
    private BigDecimal mcicilan;
    
    @Column(name="MUANGMUKA",precision=20,scale=4)
    private BigDecimal muangmuka;
    
    @Column(name="MDISCINT",precision=20,scale=4)
    private BigDecimal mdiscint;
    
    @Column(name="MDISCEXT",precision=20,scale=4)
    private BigDecimal mdiscext;
    
    @Column(name="MDISCKONSUMEN",precision=20,scale=4)
    private BigDecimal mdisckonsumen;
    
    @Column(name="MSUBLEASING1",precision=20,scale=4)
    private BigDecimal msubleasing1;
    
    @Column(name="MSUBLEASING2",precision=20,scale=4)
    private BigDecimal msubleasing2;
    
    @Column(name="MMEDIATOR",precision=20,scale=4)
    private BigDecimal mmediator;
    
    @Column(name="VIDMEDIATOR",length=64)
    private String vidmediator;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstemployee.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VIDMEDIATOR",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstemployee ahmdsh1cMstemployee;  
    
    @Column(name="VNOKONTRAK",length=50)
    private String vnokontrak;
    
    @Column(name="VIDPEMILIK",length=64)
    private String vidpemilik;
    
    @ManyToOne(targetEntity=Ahmdsh1cMstprospek.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VIDPEMILIK",referencedColumnName="VID",insertable=false,updatable=false)
    private Ahmdsh1cMstprospek ahmdsmunMstprospekPemilik;
    
    @Column(name="MBAYAR",precision=20,scale=4)
    private BigDecimal mbayar;
    
    @Column(name="MUNITPRICE",precision=20,scale=4)
    private BigDecimal munitprice;
    
    @Column(name="MBBN",precision=20,scale=4)
    private BigDecimal mbbn;
    
    @Column(name="MASTLO",precision=20,scale=4)
    private BigDecimal mastlo;
    
    @Column(name="MBBNPLUS",precision=20,scale=4)
    private BigDecimal mbbnplus;
    
    @Column(name="VB2BSTAT",length=1)
    private String vb2bstat;
    
    @Column(name="VIDB2B",length=40)
    private String vidb2b;

    @Column(name="VID_AHMDSBSC_MSTDLRCODE",nullable=false,length=64)
    private String vidAhmdsbscMstdlrcode;
    
    @Column(name="VNOINV",length=50)
    private String vnoinv;
    
    @Column(name="DINV")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dinv;
    
    @ManyToOne(targetEntity=AhmdsbscMstdlrcode.class,fetch= FetchType.LAZY)
    @JoinColumn(name="VID_AHMDSBSC_MSTDLRCODE",referencedColumnName="VID",insertable=false,updatable=false)
    private AhmdsbscMstdlrcode ahmdsbscMstdlrcode;
    
    @Column(name="VSHIPPING", length=1)
    private String vshipping;

    @Column(name="MPELUNASAN",precision=20,scale=4)
    private BigDecimal mpelunasan;
    
    @Column(name="MFROMLEASING",precision=20,scale=4)
    private BigDecimal mfromleasing;
    
    @Column(name="MTOTAL",precision=20,scale=4)
    private BigDecimal mtotal;
    
    public Ahmdsh1cHdrunitspk getAhmdsh1cHdrunitspk() {
        return ahmdsh1cHdrunitspk;
    }

    public void setAhmdsh1cHdrunitspk(Ahmdsh1cHdrunitspk ahmdsh1cHdrunitspk) {
        this.ahmdsh1cHdrunitspk = ahmdsh1cHdrunitspk;
    }

    public String getVnoso() {
        return vnoso;
    }

    public void setVnoso(String vnoso) {
        this.vnoso = vnoso;
    }

    public String getVidAhmdsh1cMstmotor() {
        return vidAhmdsh1cMstmotor;
    }

    public void setVidAhmdsh1cMstmotor(String vidAhmdsh1cMstmotor) {
        this.vidAhmdsh1cMstmotor = vidAhmdsh1cMstmotor;
    }

    public Ahmdsh1cMstmotor getAhmdsh1cMstmotor() {
        return ahmdsh1cMstmotor;
    }

    public void setAhmdsh1cMstmotor(Ahmdsh1cMstmotor ahmdsh1cMstmotor) {
        this.ahmdsh1cMstmotor = ahmdsh1cMstmotor;
    }

    public String getVidslsidprg1() {
        return vidslsidprg1;
    }

    public void setVidslsidprg1(String vidslsidprg1) {
        this.vidslsidprg1 = vidslsidprg1;
    }

    public AhmdspimHdrslsprg getAhmdspimHdrslsprg1() {
        return ahmdspimHdrslsprg1;
    }

    public void setAhmdspimHdrslsprg1(AhmdspimHdrslsprg ahmdspimHdrslsprg1) {
        this.ahmdspimHdrslsprg1 = ahmdspimHdrslsprg1;
    }

    public String getVidslsidprg2() {
        return vidslsidprg2;
    }

    public void setVidslsidprg2(String vidslsidprg2) {
        this.vidslsidprg2 = vidslsidprg2;
    }

    public AhmdspimHdrslsprg getAhmdspimHdrslsprg2() {
        return ahmdspimHdrslsprg2;
    }

    public void setAhmdspimHdrslsprg2(AhmdspimHdrslsprg ahmdspimHdrslsprg2) {
        this.ahmdspimHdrslsprg2 = ahmdspimHdrslsprg2;
    }

    public String getVflalokasi() {
        return vflalokasi;
    }

    public void setVflalokasi(String vflalokasi) {
        this.vflalokasi = vflalokasi;
    }

    public String getVflindent() {
        return vflindent;
    }

    public void setVflindent(String vflindent) {
        this.vflindent = vflindent;
    }

    public Date getDso() {
        return dso;
    }

    public void setDso(Date dso) {
        this.dso = dso;
    }

    public String getVidpembeli() {
        return vidpembeli;
    }

    public void setVidpembeli(String vidpembeli) {
        this.vidpembeli = vidpembeli;
    }

    public Ahmdsh1cMstprospek getAhmdsmunMstprospekPembeli() {
        return ahmdsmunMstprospekPembeli;
    }

    public void setAhmdsmunMstprospekPembeli(Ahmdsh1cMstprospek ahmdsmunMstprospekPembeli) {
        this.ahmdsmunMstprospekPembeli = ahmdsmunMstprospekPembeli;
    }

    public BigDecimal getMtandajadi() {
        return mtandajadi;
    }

    public void setMtandajadi(BigDecimal mtandajadi) {
        this.mtandajadi = mtandajadi;
    }

    public String getVjenisjual() {
        return vjenisjual;
    }

    public void setVjenisjual(String vjenisjual) {
        this.vjenisjual = vjenisjual;
    }

    public String getVjenisbayar() {
        return vjenisbayar;
    }

    public void setVjenisbayar(String vjenisbayar) {
        this.vjenisbayar = vjenisbayar;
    }

    public String getVidAhmdspimMstfincoy() {
        return vidAhmdspimMstfincoy;
    }

    public void setVidAhmdspimMstfincoy(String vidAhmdspimMstfincoy) {
        this.vidAhmdspimMstfincoy = vidAhmdspimMstfincoy;
    }

    public AhmdspimMstfincoy getAhmdspimMstfincoy() {
        return ahmdspimMstfincoy;
    }

    public void setAhmdspimMstfincoy(AhmdspimMstfincoy ahmdspimMstfincoy) {
        this.ahmdspimMstfincoy = ahmdspimMstfincoy;
    }

    public String getVponofc() {
        return vponofc;
    }

    public void setVponofc(String vponofc) {
        this.vponofc = vponofc;
    }

    public Date getDpofincoy() {
        return dpofincoy;
    }

    public void setDpofincoy(Date dpofincoy) {
        this.dpofincoy = dpofincoy;
    }

    public Integer getIjmlcicilan() {
        return ijmlcicilan;
    }

    public void setIjmlcicilan(Integer ijmlcicilan) {
        this.ijmlcicilan = ijmlcicilan;
    }

    public BigDecimal getMcicilan() {
        return mcicilan;
    }

    public void setMcicilan(BigDecimal mcicilan) {
        this.mcicilan = mcicilan;
    }

    public BigDecimal getMuangmuka() {
        return muangmuka;
    }

    public void setMuangmuka(BigDecimal muangmuka) {
        this.muangmuka = muangmuka;
    }

    public BigDecimal getMdiscint() {
        return mdiscint;
    }

    public void setMdiscint(BigDecimal mdiscint) {
        this.mdiscint = mdiscint;
    }

    public BigDecimal getMdiscext() {
        return mdiscext;
    }

    public void setMdiscext(BigDecimal mdiscext) {
        this.mdiscext = mdiscext;
    }

    public BigDecimal getMdisckonsumen() {
        return mdisckonsumen;
    }

    public void setMdisckonsumen(BigDecimal mdisckonsumen) {
        this.mdisckonsumen = mdisckonsumen;
    }

    public BigDecimal getMsubleasing1() {
        return msubleasing1;
    }

    public void setMsubleasing1(BigDecimal msubleasing1) {
        this.msubleasing1 = msubleasing1;
    }

    public BigDecimal getMsubleasing2() {
        return msubleasing2;
    }

    public void setMsubleasing2(BigDecimal msubleasing2) {
        this.msubleasing2 = msubleasing2;
    }

    public BigDecimal getMmediator() {
        return mmediator;
    }

    public void setMmediator(BigDecimal mmediator) {
        this.mmediator = mmediator;
    }

    public String getVidmediator() {
        return vidmediator;
    }

    public void setVidmediator(String vidmediator) {
        this.vidmediator = vidmediator;
    }

    public Ahmdsh1cMstemployee getAhmdsh1cMstemployee() {
        return ahmdsh1cMstemployee;
    }

    public void setAhmdsh1cMstemployee(Ahmdsh1cMstemployee ahmdsh1cMstemployee) {
        this.ahmdsh1cMstemployee = ahmdsh1cMstemployee;
    }

    public String getVnokontrak() {
        return vnokontrak;
    }

    public void setVnokontrak(String vnokontrak) {
        this.vnokontrak = vnokontrak;
    }

    public String getVidpemilik() {
        return vidpemilik;
    }

    public void setVidpemilik(String vidpemilik) {
        this.vidpemilik = vidpemilik;
    }

    public Ahmdsh1cMstprospek getAhmdsmunMstprospekPemilik() {
        return ahmdsmunMstprospekPemilik;
    }

    public void setAhmdsmunMstprospekPemilik(Ahmdsh1cMstprospek ahmdsmunMstprospekPemilik) {
        this.ahmdsmunMstprospekPemilik = ahmdsmunMstprospekPemilik;
    }

    public BigDecimal getMbayar() {
        return mbayar;
    }

    public void setMbayar(BigDecimal mbayar) {
        this.mbayar = mbayar;
    }

    public BigDecimal getMunitprice() {
        return munitprice;
    }

    public void setMunitprice(BigDecimal munitprice) {
        this.munitprice = munitprice;
    }

    public BigDecimal getMbbn() {
        return mbbn;
    }

    public void setMbbn(BigDecimal mbbn) {
        this.mbbn = mbbn;
    }

    public BigDecimal getMastlo() {
        return mastlo;
    }

    public void setMastlo(BigDecimal mastlo) {
        this.mastlo = mastlo;
    }

    public BigDecimal getMbbnplus() {
        return mbbnplus;
    }

    public void setMbbnplus(BigDecimal mbbnplus) {
        this.mbbnplus = mbbnplus;
    }

    public String getVb2bstat() {
        return vb2bstat;
    }

    public void setVb2bstat(String vb2bstat) {
        this.vb2bstat = vb2bstat;
    }

    public String getVidb2b() {
        return vidb2b;
    }

    public void setVidb2b(String vidb2b) {
        this.vidb2b = vidb2b;
    }

    public String getVidAhmdsbscMstdlrcode() {
        return vidAhmdsbscMstdlrcode;
    }

    public void setVidAhmdsbscMstdlrcode(String vidAhmdsbscMstdlrcode) {
        this.vidAhmdsbscMstdlrcode = vidAhmdsbscMstdlrcode;
    }

    public AhmdsbscMstdlrcode getAhmdsbscMstdlrcode() {
        return ahmdsbscMstdlrcode;
    }

    public void setAhmdsbscMstdlrcode(AhmdsbscMstdlrcode ahmdsbscMstdlrcode) {
        this.ahmdsbscMstdlrcode = ahmdsbscMstdlrcode;
    }
/*
    public String getVidAhmdsh1cHdrunitspk() {
        return vidAhmdsh1cHdrunitspk;
    }

    public void setVidAhmdsh1cHdrunitspk(String vidAhmdsh1cHdrunitspk) {
        this.vidAhmdsh1cHdrunitspk = vidAhmdsh1cHdrunitspk;
    }
*/
    public String getVnoinv() {
        return vnoinv;
    }

    public void setVnoinv(String vnoinv) {
        this.vnoinv = vnoinv;
    }

    public String getVidAhmdsh1cMsttypeclr() {
        return vidAhmdsh1cMsttypeclr;
    }

    public void setVidAhmdsh1cMsttypeclr(String vidAhmdsh1cMsttypeclr) {
        this.vidAhmdsh1cMsttypeclr = vidAhmdsh1cMsttypeclr;
    }

    public Ahmdsh1cMsttypeclr getAhmdsh1cMsttypeclr() {
        return ahmdsh1cMsttypeclr;
    }

    public void setAhmdsh1cMsttypeclr(Ahmdsh1cMsttypeclr ahmdsh1cMsttypeclr) {
        this.ahmdsh1cMsttypeclr = ahmdsh1cMsttypeclr;
    }

    public Date getDinv() {
        return dinv;
    }

    public void setDinv(Date dinv) {
        this.dinv = dinv;
    }

    public AhmdsbscDtlsetting getAhmdsbscDtlsetting() {
        return ahmdsbscDtlsetting;
    }

    public void setAhmdsbscDtlsetting(AhmdsbscDtlsetting ahmdsbscDtlsetting) {
        this.ahmdsbscDtlsetting = ahmdsbscDtlsetting;
    }

    public String getVshipping() {
        return vshipping;
    }

    public void setVshipping(String vshipping) {
        this.vshipping = vshipping;
    }

    public BigDecimal getMpelunasan() {
        return mpelunasan;
    }

    public void setMpelunasan(BigDecimal mpelunasan) {
        this.mpelunasan = mpelunasan;
    }

    public BigDecimal getMfromleasing() {
        return mfromleasing;
    }

    public void setMfromleasing(BigDecimal mfromleasing) {
        this.mfromleasing = mfromleasing;
    }

    public BigDecimal getMtotal() {
        return mtotal;
    }

    public void setMtotal(BigDecimal mtotal) {
        this.mtotal = mtotal;
    }
    
    
}
