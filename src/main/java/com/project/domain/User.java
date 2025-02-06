package com.project.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="users")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_gen")
	@SequenceGenerator(name = "user_id_gen", allocationSize = 1, sequenceName = "user_id_gen")
	private int user_id;
	
	@Column(unique = true, length = 50)
	@Schema(example="awa@naver.com", required = true)
	private String email;
	
	@Column(length = 50)
	@Schema(example="1234", required = true)
	private String password;
	
	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}

}
