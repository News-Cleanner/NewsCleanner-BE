package com.project.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsRequestDTO {
	private int news_id;
	private String context;
}
