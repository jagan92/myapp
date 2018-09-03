package com.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.dto.MasterDetailVO;
import com.myapp.entity.MasterDetails;
import com.myapp.repository.MasterDetailRepository;
import com.myapp.repository.UserRepository;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MasterDetailRepository masterDetailRepository;

	@Override
	public boolean saveMasterDetail(MasterDetailVO masterDetailVO) {
		try {
			MasterDetails masterDetail = new MasterDetails();
			BeanUtils.copyProperties(masterDetail, masterDetailVO);
			masterDetailRepository.save(masterDetail);
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<MasterDetails> listMasterDetailsByType(String masterType) {
		List<MasterDetails> masterDetails = new ArrayList<>(); 
		try {
			masterDetails = masterDetailRepository.findByMasterType(masterType);
		} catch(Exception e) {
			System.out.println(e);
			masterDetails = new ArrayList<>();
		}
		return masterDetails;
	}

	@Override
	public List<MasterDetailVO> listMasterDetailVOByType(String masterType) {
		List<MasterDetailVO> masterDetailVOs = new ArrayList<>(); 
		try {
			List<MasterDetails> masterDetails = masterDetailRepository.findByMasterType(masterType);
			for(MasterDetails masterDet : masterDetails) {
				MasterDetailVO masterDetailVO = new MasterDetailVO(masterDet);
				masterDetailVOs.add(masterDetailVO);
			}
		} catch(Exception e) {
			System.out.println(e);
			masterDetailVOs = new ArrayList<>();
		}
		return masterDetailVOs;
	}
	
	
}
