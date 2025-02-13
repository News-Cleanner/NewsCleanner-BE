package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.domain.LikeIt;
import com.project.domain.News;
import com.project.domain.User;
import com.project.dto.NewsDTO;
import com.project.service.NewsService;

import io.swagger.v3.oas.annotations.media.Content;
import jakarta.servlet.http.HttpSession;

@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@PostMapping("/news-upload")
	public NewsDTO uploadNews(@RequestBody NewsDTO dto, HttpSession session) {
		
		// context 내용에 쌍따옴표(")나 줄바꿈이 있어서는 안된다. 따라서 프론트에서 처리를 해줘서 서버에 보내줘야한다.
		News news=new News(dto);
		news.setUser((User)session.getAttribute("loginUser"));
		
		LikeIt likeIt=new LikeIt(dto);
		likeIt.setNews(news);
		
		return newsService.uploadNews(news, likeIt);
	}
	
	
}
