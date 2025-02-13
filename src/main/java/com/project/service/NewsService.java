package com.project.service;

import com.project.domain.LikeIt;
import com.project.domain.News;

public interface NewsService {
	News uploadNews(News news, LikeIt likeit);
}
