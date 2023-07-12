package com.bezkoder.spring.security.postgresql.repository;

import com.bezkoder.spring.security.postgresql.models.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITutorialRepository extends JpaRepository<Tutorial, Long> {


    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);


    //
    List<Tutorial> findTutorialsByThemesId(Long themeId);
}
