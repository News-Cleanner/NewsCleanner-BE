package com.project.domain;

import com.project.dto.NewsDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="news")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "news_id_gen")
	@SequenceGenerator(name = "news_id_gen", allocationSize = 1, sequenceName = "news_id_gen")
	@Column(name="news_id")
	private int newsId;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 10000)
	private String content;
	
	@Column(length = 20)
	private String press;
	
	@Column(length = 10)
	private String reporter;
	
	@OneToOne(mappedBy = "news", cascade = CascadeType.ALL)
	private LikeIt likeIt;
	
	public void setLikeIt(LikeIt likeIt) {
		this.likeIt=likeIt;
		likeIt.setNews(this);
	}
	
	public News(User user, String content) {
		this.user=user;
		this.content=content;
	}
	
	public News(NewsDTO dto) {
		this.title=dto.getTitle();
		this.content=dto.getContent();
		this.press=dto.getPress();
		this.reporter=dto.getReporter();
	}
	
}
