package com.example.demo.service.home;

import java.net.URISyntaxException;
import java.util.Map;

import com.example.demo.vo.home.MbrInfo;

public interface HomeService {
	public String getMemberNameInfo(MbrInfo mbrInfo);
	public Map<String, Object> getApartmentDeals(String lawdCd, String dealYmd, String serviceKey) throws URISyntaxException;
}
