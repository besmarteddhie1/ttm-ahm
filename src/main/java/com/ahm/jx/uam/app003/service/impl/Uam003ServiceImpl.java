/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahm.jx.uam.app003.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahm.jx.app000.dao.AhmjxuamMstservicesDao;
import com.ahm.jx.app000.model.AhmjxuamMstservices;
import com.ahm.jx.common.constant.CommonConstant;
import com.ahm.jx.common.rest.dto.DtoParamPaging;
import com.ahm.jx.common.rest.dto.DtoRespond;
import com.ahm.jx.common.rest.dto.DtoRespondPaging;
import com.ahm.jx.dashboard.service.DashboardService;
import com.ahm.jx.uam.app003.dao.Uam003AhmjxuamMstappsDao;
import com.ahm.jx.uam.app003.dao.Uam003AhmjxuamMstservicesDao;
import com.ahm.jx.uam.app003.service.Uam003Service;
import com.ahm.jx.uam.app003.util.Uam003Util;
import com.ahm.jx.uam.app003.vo.Uam003VoAhmjxuamMstservice;
import com.ahm.jx.uam.app003.vo.Uam003VoApp;

/**
 *
 * @author sigit
 */
@Service("uam003Service")
@Transactional(readOnly = false)
public class Uam003ServiceImpl implements Uam003Service {

	@Autowired
	@Qualifier("uam003AhmjxuamMstservicesDao")
	private Uam003AhmjxuamMstservicesDao uam003AhmjxuamMstservicesDao;

	@Autowired
	@Qualifier("ahmjxuamMstservicesDao")
	private AhmjxuamMstservicesDao ahmjxuamMstservicesDao;

	@Autowired
	@Qualifier("uam003AhmjxuamMstappsDao")
	private Uam003AhmjxuamMstappsDao uam003AhmjxuamMstappsDao;

	@Autowired
	@Qualifier("dashboardService")
	private DashboardService dashboardService;

	@Override
	public int getPagingCountAhmjxuamMstservice(Map<String, Object> filters) {
		return uam003AhmjxuamMstservicesDao.getPagingCountAhmjxuamMstservices(filters);
	}

	@Override
	public List<Uam003VoAhmjxuamMstservice> getPagingDataAhmjxuamMstservice(int first, int pageSize, String sortField,
			String sortOrder, Map<String, Object> filters) {
		return uam003AhmjxuamMstservicesDao.getPagingDataAhmjxuamMstservices(first, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public DtoRespond disableState(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			List<Uam003VoAhmjxuamMstservice> list, String token, String appId) {
		DtoRespond dtoRespond = new DtoRespond();

		String username = dashboardService.getUsername(httpServletRequest);
		dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token,
				appId);
		if (dtoRespond.getStat().equals(CommonConstant._200)) {
			for (Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice : list) {
				String id = uam003VoAhmjxuamMstservice.getVid();

				System.out.println("VID UPdate " + id);

				AhmjxuamMstservices ahmjxuamMstservices = ahmjxuamMstservicesDao.get(id);
				ahmjxuamMstservices.setVstat("F");

				ahmjxuamMstservicesDao.update(ahmjxuamMstservices, username);
			}
			dtoRespond.setDetailMsg("User telah dinonaktifkan");
		}

		return dtoRespond;
	}

	@Override
	public DtoRespondPaging pagingService(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, DtoParamPaging dtoParamPaging, String token, String appId) {
		DtoRespondPaging dtoRespondPaging;

		dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest,
				httpServletResponse, token, appId);

		if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
			int count = getPagingCountAhmjxuamMstservice(dtoParamPaging.getSearch());
			List<Uam003VoAhmjxuamMstservice> listData = getPagingDataAhmjxuamMstservice(dtoParamPaging.getOffset(),
					dtoParamPaging.getLimit(), dtoParamPaging.getSort(), dtoParamPaging.getOrder(),
					dtoParamPaging.getSearch());
			dtoRespondPaging.setRows(listData);
			dtoRespondPaging.setTotal(count);
		}

		return dtoRespondPaging;
	}

	@Transactional(readOnly = false)
	public DtoRespond insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId) {
		DtoRespond dtoRespond = new DtoRespond();

		String username = dashboardService.getUsername(httpServletRequest);
		dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token,
				appId);
		if (dtoRespond.getStat().equals(CommonConstant._200)) {
			AhmjxuamMstservices ahmjxuamMstservices = new AhmjxuamMstservices();
			ahmjxuamMstservices.setVid(uam003VoAhmjxuamMstservice.getVid());
			ahmjxuamMstservices.setVsvcName(uam003VoAhmjxuamMstservice.getVsvcName());
			ahmjxuamMstservices.setVsvcDesc(uam003VoAhmjxuamMstservice.getVsvcDesc());
			ahmjxuamMstservices.setVurl(uam003VoAhmjxuamMstservice.getVurl());
			ahmjxuamMstservices.setVstat("T");
			ahmjxuamMstservices.setVidAhmjxuamMstapps(uam003VoAhmjxuamMstservice.getVidAhmjxuamMstapps());

			uam003AhmjxuamMstservicesDao.save(ahmjxuamMstservices, username);
			dtoRespond.setMsg(CommonConstant._200Msg);
			dtoRespond.setStat(CommonConstant._200);
			dtoRespond.setDetailMsg("Penambahan Service berhasil!");
			return dtoRespond;
		}

		return dtoRespond;
	}

	@Transactional(readOnly = false)
	public DtoRespond update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Uam003VoAhmjxuamMstservice uam003VoAhmjxuamMstservice, String token, String appId,
			Uam003VoAhmjxuamMstservice oldObj) {
		DtoRespond dtoRespond = new DtoRespond();

		String username = dashboardService.getUsername(httpServletRequest);
		dtoRespond = dashboardService.authenticationAndAuthorization(httpServletRequest, httpServletResponse, token,
				appId);

		try {
			if (dtoRespond.getStat().equals(CommonConstant._200)) {
				AhmjxuamMstservices ahmjxuamMstservices = new AhmjxuamMstservices();
				System.out.println("Nilai : " + uam003VoAhmjxuamMstservice.getVid() + "--"
						+ uam003VoAhmjxuamMstservice.getVsvcName() + "--" + uam003VoAhmjxuamMstservice.getVsvcDesc()
						+ "--" + uam003VoAhmjxuamMstservice.getVstat());
				ahmjxuamMstservices.setVid(uam003VoAhmjxuamMstservice.getVid());
				ahmjxuamMstservices.setCreateBy(uam003VoAhmjxuamMstservice.getVcrea());
				ahmjxuamMstservices.setCreateDate(uam003VoAhmjxuamMstservice.getDcrea());
				ahmjxuamMstservices.setVsvcName(uam003VoAhmjxuamMstservice.getVsvcName());
				ahmjxuamMstservices.setVsvcDesc(uam003VoAhmjxuamMstservice.getVsvcDesc());
				ahmjxuamMstservices.setVurl(uam003VoAhmjxuamMstservice.getVurl());
				ahmjxuamMstservices.setVstat(Uam003Util.convertStatus(uam003VoAhmjxuamMstservice.getVstat()));
				ahmjxuamMstservices.setVidAhmjxuamMstapps(uam003VoAhmjxuamMstservice.getVidAhmjxuamMstapps());
				ahmjxuamMstservices.setIver(uam003VoAhmjxuamMstservice.getIver());
				ahmjxuamMstservicesDao.update(ahmjxuamMstservices, username);

				dtoRespond.setStat(CommonConstant._200);
				dtoRespond.setMsg(CommonConstant._200Msg);
				dtoRespond.setDetailMsg("Perubahan data service berhasil!");
			}
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return dtoRespond;

	}

	@Override
	public Uam003VoAhmjxuamMstservice getServiceById(String vid) {
		AhmjxuamMstservices ahmjxuamMstservices = ahmjxuamMstservicesDao.get(vid);

		Uam003VoAhmjxuamMstservice vo = null;
		if (ahmjxuamMstservices != null) {
			vo = new Uam003VoAhmjxuamMstservice();
			vo.setVid(ahmjxuamMstservices.getVid());
			vo.setIver(ahmjxuamMstservices.getIver());
			vo.setVcrea(ahmjxuamMstservices.getCreateBy());
			vo.setDcrea(ahmjxuamMstservices.getCreateDate());
			vo.setVsvcName(ahmjxuamMstservices.getVsvcName());
			vo.setVsvcDesc(ahmjxuamMstservices.getVsvcDesc());
			vo.setVurl(ahmjxuamMstservices.getVurl());
			vo.setVstat(ahmjxuamMstservices.getVstat());

		}

		return vo;
	}

	public DtoRespondPaging getLovApp(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			DtoParamPaging dtoParamPaging, String token, String appId) {
		DtoRespondPaging dtoRespondPaging = new DtoRespondPaging();
		dtoRespondPaging = dashboardService.authenticationAndAuthorizationPaging(httpServletRequest,
				httpServletResponse, token, appId);
		if (dtoRespondPaging.getStat().equals(CommonConstant._200)) {
			dtoRespondPaging.setTotal(getPagingCountAhmjxuamMstapps(dtoParamPaging.getSearch()));
			dtoRespondPaging.setRows(getPagingDataAhmjxuamMstapps(dtoParamPaging.getOffset(), dtoParamPaging.getLimit(),
					dtoParamPaging.getSort(), dtoParamPaging.getOrder(), dtoParamPaging.getSearch()));
		}
		return dtoRespondPaging;
	}

	private List<Uam003VoApp> getPagingDataAhmjxuamMstapps(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters) {
		return uam003AhmjxuamMstappsDao.getPagingDataAhmjxuamMstapps(first, pageSize, sortField, sortOrder, filters);
	}

	private int getPagingCountAhmjxuamMstapps(Map<String, Object> filters) {
		return uam003AhmjxuamMstappsDao.getPagingCountAhmjxuamMstapps(filters);
	}

}
