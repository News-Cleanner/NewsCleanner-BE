package com.project.util;

import org.springframework.stereotype.Component;
import org.jsoup.*;
import org.jsoup.nodes.Document;

@Component
public class NewsScrapper {
	public Document scrape(String url) {
		try {
			return Jsoup.connect(url)
                    .get();
		}
		catch (Exception e) {
			throw new RuntimeException("네이버 뉴스 크롤링 실패", e);
		}
	}
}
