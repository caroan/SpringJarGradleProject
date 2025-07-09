package com.example.demo.Repository.home.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.mapper.home.HomeMapper;
import com.example.demo.vo.home.MbrInfo;

@Repository
public class HomeRepository implements com.example.demo.Repository.home.HomeRepository {

	@Autowired
	HomeMapper homeMapper;

	@Override
	public String getMemberNameInfo(MbrInfo param) {
		// TODO Auto-generated method stub
		return homeMapper.getMemberNameInfo(param);
	}

	@Override
	public MbrInfo getMemberAllInfo(MbrInfo mbrInfo) {
		// TODO Auto-generated method stub
		return homeMapper.getMemberAllInfo(mbrInfo);
	}

	@Override
	public int updateMemberInfo(MbrInfo mbrInfo) {
		// TODO Auto-generated method stub
		return homeMapper.updateMemberInfo(mbrInfo);
	}

	@Override
	public int insertMemberInfo(MbrInfo mbrInfo) {
		// TODO Auto-generated method stub
		return homeMapper.insertMemberInfo(mbrInfo);
	}

	@Override
	public int deleteMemberInfo(MbrInfo mbrInfo) {
		// TODO Auto-generated method stub
		return homeMapper.deleteMemberInfo(mbrInfo);
	}

}
