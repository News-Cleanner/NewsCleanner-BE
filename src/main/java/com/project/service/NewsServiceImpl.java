package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.News;
import com.project.repository.NewsRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsRepository newsRep;

	@Override
	public News uploadNews(News news) {
		News saveNews = newsRep.save(news);
		return saveNews;
	}

}
