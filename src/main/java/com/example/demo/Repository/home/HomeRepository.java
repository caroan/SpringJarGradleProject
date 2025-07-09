package com.example.demo.Repository.home;

import com.example.demo.vo.home.MbrInfo;

public interface HomeRepository {

	String getMemberNameInfo(MbrInfo param);

	MbrInfo getMemberAllInfo(MbrInfo mbrInfo);
	
	int updateMemberInfo(MbrInfo mbrInfo);
	
	int insertMemberInfo(MbrInfo mbrInfo);
	
	int deleteMemberInfo(MbrInfo mbrInfo);
}
