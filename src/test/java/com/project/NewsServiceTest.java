package com.project;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;

import com.project.service.NewsService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
//@Commit
public class NewsServiceTest {
	
	@Autowired
	NewsService newsService;
	
	@Test
	void fetchTest() {
		newsService.fetchNews("https://n.news.naver.com/mnews/article/119/0002923076");
	}

}