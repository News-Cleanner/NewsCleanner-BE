package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.LikeIt;
import com.project.domain.News;
import com.project.dto.NewsDTO;
import com.project.repository.LikeItRepository;
import com.project.repository.NewsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsRepository newsRep;
	
	@Autowired
	LikeItRepository likeItRep;

	@Override
	public NewsDTO uploadNews(News news, LikeIt likeIt) {
		news.setLikeIt(likeIt);
		News dbNews=newsRep.save(news);
		return new NewsDTO(dbNews);
	}
	
	

}
