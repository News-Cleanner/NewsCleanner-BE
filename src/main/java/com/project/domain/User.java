package com.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String email;
	
	@Column(length = 50)
	private String password;
	
	User(int user_id){
		this.user_id=user_id;
	}
}
