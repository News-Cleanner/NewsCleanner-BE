package com.project.util;

import org.springframework.stereotype.Component;

import com.project.dto.NewsDTO;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Component
public class NewsScrapper {
	public NewsDTO scrape(String url) {
		
		// 크롬드라이버 설정
		System.setProperty("webdriver.chrome.driver", "./chromedriver");
		
        // Chrome 브라우저 옵션 설정 (헤드리스 모드 가능)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // 👉 헤드리스 모드 (브라우저 창 없이 실행)
        options.addArguments("--disable-gpu"); // GPU 가속 비활성화 (리소스 절약)
        options.addArguments("--no-sandbox"); // 샌드박스 모드 비활성화 (리눅스에서 필수)

        // WebDriver 객체 생성
        WebDriver driver = new ChromeDriver(options);
        
		try {
			driver.get(url);
			
			// 페이지 로딩 대기 (최대 5초)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
            // 추천 가져오기
            List<WebElement> reactionElements = driver.findElements(By.className("u_likeit_list_count"));
            List<Integer> reactions=new ArrayList<>();
            for (WebElement e : reactionElements) {
                String cnt=e.getText();
                if(cnt.equals("")) continue;
                reactions.add(Integer.parseInt(cnt));
            }
            
            NewsDTO newsDTO=new NewsDTO(reactions);
            
            // 제목 가져오기
            WebElement titleElement = driver.findElement(By.cssSelector("h2#title_area"));
            String title = titleElement != null ? titleElement.getText() : "제목 없음";
            newsDTO.setTitle(title);
            
            // 기자 이름 가져오기
            WebElement reporterElement = driver.findElement(By.cssSelector(".media_journalistcard_summary_name_text"));
            String reporter = reporterElement != null ? reporterElement.getText().split(" ")[0] : "기자 없음";
            newsDTO.setReporter(reporter);
            
            // 언론사 이름 가져오기
            WebElement pressElement = driver.findElement(By.cssSelector(".media_end_head_top_logo img"));
            String press = pressElement != null ? pressElement.getAttribute("alt") : "언론사 없음";
            newsDTO.setPress(press);
            
            // 기사 본문 가져오기
            WebElement contentElement = driver.findElement(By.cssSelector("#dic_area"));
            String content = contentElement != null ? contentElement.getText() : "본문 없음";        
            newsDTO.setContent(content);
            
            return newsDTO;
		}
		catch (Exception e) {
			throw new RuntimeException("네이버 뉴스 크롤링 실패", e);
		}
	}
}
