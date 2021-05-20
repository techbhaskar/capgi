package com.capgi.spring.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgi.spring.files.csv.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
