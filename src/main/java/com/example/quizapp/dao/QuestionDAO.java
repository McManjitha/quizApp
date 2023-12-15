package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
    @Query(value = "SELECT q FROM Question q WHERE q.category = :category")
    Page<Question> findQuestionByCategory(String category, Pageable pageable);
}
