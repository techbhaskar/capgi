package com.capgi.spring.files.csv.service;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgi.spring.files.csv.helper.CSVHelper;
import com.capgi.spring.files.csv.model.Tutorial;
import com.capgi.spring.files.csv.repository.TutorialRepository;

@Service
public class CSVService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}