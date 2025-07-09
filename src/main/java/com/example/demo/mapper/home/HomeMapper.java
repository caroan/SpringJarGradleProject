package com.example.demo.mapper.home;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.vo.home.MbrInfo;


@Mapper
public interface HomeMapper {
	String getMemberNameInfo(MbrInfo param);

	MbrInfo getMemberAllInfo(MbrInfo mbrInfo);

	int updateMemberInfo(MbrInfo mbrInfo);

	int insertMemberInfo(MbrInfo mbrInfo);

	int deleteMemberInfo(MbrInfo mbrInfo);
}
