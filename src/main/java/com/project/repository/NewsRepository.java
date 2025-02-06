package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.domain.News;

public interface NewsRepository extends JpaRepository<News, Integer> {

}
