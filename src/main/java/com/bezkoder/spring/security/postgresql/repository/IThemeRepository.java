package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IThemeRepository extends JpaRepository<Theme,Long> {
    List<Theme> findThemesByTutorialsId(Long tutorialId);


    List<Theme> findByNomContaining(String nom);
}