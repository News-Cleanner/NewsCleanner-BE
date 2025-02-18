package com.project;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;

import com.project.dto.NewsDTO;
import com.project.service.NewsService;
import com.project.util.NewsScrapper;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
//@Commit
public class NewsScrapperTest {
	
	@Autowired
	NewsScrapper newsScrapper;
	
	@Test
	void fetchTest() {
		NewsDTO scrape = newsScrapper.scrape("https://n.news.naver.com/mnews/ranking/article/001/0015220552?ntype=RANKING");
		
		System.out.println(scrape);
	}

}