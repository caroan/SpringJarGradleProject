package com.example.demo.service.home.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.Repository.home.HomeRepository;
import com.example.demo.service.home.HomeService;
import com.example.demo.vo.home.MbrInfo;

import reactor.core.publisher.Mono;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeRepository homeRepository;
	
	private final WebClient webClient;
	
	@Autowired
    public HomeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }
	
	@Override
	public Map<String, Object> getApartmentDeals(String lawdCd, String dealYmd, String serviceKey) throws URISyntaxException {
        //String url = "https://apis.data.go.kr/1613000/ApartmentTradeService2/getTradeAptList";
		String lawdCd2 = "11110";
		String dealYmd2 = "201512";
        // WebClient를 이용한 GET 요청
		
		String serviceKey2 = "YGL7jPfZQJaVoX7sUyqkSzFSdJwC1KMpYqcgJfk4PSvGdlRoiOAWRtRNQUhWR5LtBLnMLOjB+g005gIp065Z2A==";
		String encodedKey2 = URLEncoder.encode(serviceKey2, StandardCharsets.UTF_8);
		
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			    .scheme("https")
			    .host("apis.data.go.kr")
			    .path("/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade")
			    .queryParam("serviceKey", encodedKey2)
			    .queryParam("LAWD_CD", lawdCd2)
			    .queryParam("DEAL_YMD", dealYmd2)
			    .queryParam("_type", "json")
			    .build();

		String urlString = uriComponents.toUriString();
		
		URI a = new URI(urlString);
		Mono<Map<String, Object>> response = webClient.get().uri(a).retrieve().bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});
		
        return response.block(); // 동기식으로 결과 받기
		
//        Mono<String> response = webClient.get()
//                .uri(uriBuilder -> uriBuilder
//                        .scheme("https")
//                        .host("apis.data.go.kr")
//                        .path("/1613000/RTMSDataSvcAptTrade/getRTMSDataSvcAptTrade")
//                        .queryParam("serviceKey", serviceKey2)
//                        .queryParam("LAWD_CD", lawdCd2)
//                        .queryParam("DEAL_YMD", dealYmd2)
//                        .queryParam("_type", "json")
//                        .build(false)
//                )
//                .retrieve()
//                .bodyToMono(String.class); // 람다 내부에서 자체적으로 인코딩을 해버리기 때문에 이거 쓰지 않는다.
    }

	@Override
	public String getMemberNameInfo(MbrInfo param) {
		return homeRepository.getMemberNameInfo(param);
	}
}
