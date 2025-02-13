package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.LikeIt;
import com.project.domain.News;
import com.project.domain.User;
import com.project.dto.NewsDTO;
import com.project.dto.RequestDTO;
import com.project.service.NewsService;

import io.swagger.v3.oas.annotations.media.Content;
import jakarta.servlet.http.HttpSession;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@PostMapping("/news-upload")
	public NewsDTO uploadNews(@RequestBody RequestDTO request, HttpSession session) {
		
		// 뉴스 정보 담기
		String url=request.getUrl();
		NewsDTO dto=newsService.fetchNews(url);
		
		// 뉴스 정보들로 객체 생성
		News news=new News(dto);
		news.setUser((User)session.getAttribute("loginUser"));
		
		LikeIt likeIt=new LikeIt(dto);
		likeIt.setNews(news);
		
		return newsService.uploadNews(news, likeIt);
	}
	
	
}
