package com.project.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domain.LikeIt;
import com.project.domain.News;
import com.project.dto.NewsDTO;
import com.project.repository.LikeItRepository;
import com.project.repository.NewsRepository;
import com.project.util.NewsScrapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsRepository newsRep;
	
	@Autowired
	LikeItRepository likeItRep;
	
	@Autowired
	NewsScrapper newsScrapper;

	@Override
	public NewsDTO uploadNews(News news, LikeIt likeIt) {
		news.setLikeIt(likeIt);
		News dbNews=newsRep.save(news);
		return new NewsDTO(dbNews);
	}

	@Override
	public NewsDTO fetchNews(String url) {
		Document doc=newsScrapper.scrape(url);
		
		// 감정 반응 카운트 가져오기
        Element reactionElements = doc.selectFirst("ul.u_likeit_layer._faceLayer");
        int[] reactions=new int[5];
        if (reactionElements != null) {
            // <ul> 내부의 모든 <li> 요소 가져오기
            Elements reactionElement = reactionElements.select("li");
            int idx=0;
            for (Element li : reactionElement) {
            	Element countElement = li.selectFirst("span.u_likeit_list_count._count");
            	reactions[idx]=Integer.parseInt(countElement.text());
            	idx++;
            }
        }
        
        NewsDTO newsDTO=new NewsDTO(reactions);
		
		// 제목 가져오기
        Element titleElement=doc.selectFirst("h2#title_area");
        String title=titleElement != null ? titleElement.text() : "제목 없음";
        newsDTO.setTitle(title);

        // 기자 이름 가져오기
        Element reporterElement=doc.selectFirst(".byline_s"); // 기자 이름 클래스
        String reporter=reporterElement != null ? reporterElement.text().split(" ")[0] : "기자 없음";
        newsDTO.setReporter(reporter);

        // 언론사 이름 가져오기
        Element pressElement=doc.selectFirst(".media_end_head_top_logo img");
        String press=pressElement != null ? pressElement.attr("alt") : "언론사 없음";
        newsDTO.setPress(press);

        // 기사 본문 가져오기
        Element contentElement=doc.selectFirst("#dic_area");
        String content=contentElement != null ? contentElement.text() : "본문 없음";
        newsDTO.setContent(content);
        
		return newsDTO;
	}
	
	

}
