package com.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private int news_id;
	
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	
	@Column(length = 1000)
	private String context;
	
}
