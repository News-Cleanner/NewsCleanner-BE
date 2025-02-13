package com.project.service;

import com.project.domain.LikeIt;
import com.project.domain.News;
import com.project.dto.NewsDTO;

public interface NewsService {
	NewsDTO uploadNews(News news, LikeIt likeit);
}
