package com.project.domain;

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
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="results")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "result_id_gen")
	@SequenceGenerator(name = "result_id_gen", allocationSize = 1, sequenceName = "result_id_gen")
	private int result_id;
	
	@JoinColumn(name="news_id")
	@OneToOne
	private News news;
	
	private int fact_check;

	private int source_reliability;

	private int logical_consistency;

	private int emotional_bias;

	private int political_bias;

	private int virality;

	private int score;
}
