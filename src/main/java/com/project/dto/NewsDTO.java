package com.project.dto;
import com.project.domain.LikeIt;
import com.project.domain.News;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDTO {
	private int news_id;
	
	@Schema(example="크롬·엣지·파이어폭스, 개인정보위와 자동로그인 보안 개선키로")
	private String title;
	
	@Schema(example="개인정보보호위원회는 주요 웹브라우저인 구글 크롬, 마이크로소프트(MS) 엣지, 모질라 파이어폭스 사업자들과 자동 로그인 서비스를 개선하기로 했다고 13일 밝혔다.\n"
			+ "자동 로그인은 웹사이트에 1차례 로그인하면 웹브라우저가 아이디·비밀번호를 기억한 뒤 다음 회차 로그인 때 계정정보를 자동으로 입력해주는 서비스다.\n")
	private String context;
	
	@Schema(example="머니투데이")
	private String mediaCompany;
	
	@Schema(example="성시호")
	private String reporter;
	
	@Schema(example="1")
	private int useful;
	
	@Schema(example="2")
	private int wow;
	
	@Schema(example="3")
	private int toched;
	
	@Schema(example="4")
	private int analtical;
	
	@Schema(example="5")
	private int recommend;
	
	public NewsDTO(News news) {
		this.news_id=news.getNewsId();
		this.title=news.getTitle();
		this.context=news.getContext();
		this.mediaCompany=news.getMediaCompany();
		this.reporter=news.getReporter();
		LikeIt likeIt=news.getLikeIt();
		this.useful=likeIt.getUseful();
		this.wow=likeIt.getWow();
		this.toched=likeIt.getToched();
		this.analtical=likeIt.getAnaltical();
		this.recommend=likeIt.getRecommend();
	}
}
