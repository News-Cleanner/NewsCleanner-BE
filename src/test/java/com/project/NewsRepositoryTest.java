package com.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;

import com.project.domain.News;
import com.project.repository.NewsRepository;
import com.project.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
//@Commit
public class NewsRepositoryTest {
	
	@Autowired
	NewsRepository newsRep;
	
	@Autowired
	UserRepository userRep;
	
	@Test
	void saveTest() {
		News news=new News(userRep.findByEmail("awa@naver.com"), "[마이데일리 = 김건호 기자] 맨체스터 유나이티드 수비수 루크 쇼가 재활 중 부상을 당했다.\n"
				+ "\n"
				+ "영국 '미러'는 5일(이하 한국시각) \"쇼가 맨유에서 복귀를 위한 오랜 여정 속에서 또 한번의 좌절을 겪었다\"고 전했다.\n"
				+ "\n"
				+ "쇼는 지난 12월 근육 부상을 당했다. 이후 재활에 집중하고 있다. 올 시즌을 앞두고 무릎 부상을 당했던 그는 복귀 후 교체로 3경기에 출전했지만, 다시 근육 문제로 쓰러져 좌절을 느꼈다.\n"
				+ "\n"
				+ "당시 쇼는 자신의 소셜미디어(SNS)를 통해 \"최근에 어려움을 극복하고 긍정적인 방향으로 나아가고 있다고 생각했기 때문에 이 글을 쓰는 것이 많이 아팠지만, 안타깝게도 작은 좌절을 겪었다\"고 밝혔다.\n"
				+ "");
		
		News savedNews=newsRep.save(news);
		
		assertNotNull(savedNews);
	}

}
