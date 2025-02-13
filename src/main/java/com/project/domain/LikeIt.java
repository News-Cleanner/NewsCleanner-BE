package com.project.domain;

import com.project.dto.NewsRequestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="likeits")
@ToString
@AllArgsConstructor
@Builder
public class LikeIt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "likeit_id_gen")
	@SequenceGenerator(name = "likeit_id_gen", allocationSize = 1, sequenceName = "likeit_id_gen")
	@Column(name="likeit_id")
	private int likeitId;
	
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
	
	@JoinColumn(name="newsId")
	@OneToOne
	private News news;
	
	public LikeIt(NewsRequestDTO dto) {
		this.useful=dto.getUseful();
		this.wow=dto.getWow();
		this.toched=dto.getToched();
		this.analtical=dto.getAnaltical();
		this.recommend=dto.getRecommend();
	}
	
	public void setNews (News news) {
		this.news=news;
	}
}
