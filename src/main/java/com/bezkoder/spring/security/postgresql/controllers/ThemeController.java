package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.exception.ResourceNotFoundException;
import com.bezkoder.spring.security.postgresql.models.Theme;
import com.bezkoder.spring.security.postgresql.repository.IThemeRepository;
import com.bezkoder.spring.security.postgresql.repository.ITutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ThemeController {
    @Autowired
    private ITutorialRepository tutorialRepository;

    @Autowired
    private IThemeRepository themeRepository;

    @GetMapping("/themes")
    public ResponseEntity<List<Theme>> getAllThemes() {
        List<Theme> themes = new ArrayList<Theme>();

        themeRepository.findAll().forEach(themes::add);

        if (themes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(themes, HttpStatus.OK);
    }


    @GetMapping("/tutorials/{tutorialId}/themes")
    public ResponseEntity<List<Theme>> getAllThemesByTutorialId(@PathVariable(value = "tutorialId") Long tutorialId) {
        if (!tutorialRepository.existsById(tutorialId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId);
        }

        List<Theme> themes = themeRepository.findThemesByTutorialsId(tutorialId);
        return new ResponseEntity<>(themes, HttpStatus.OK);


    }

    @PostMapping("/themess")
    public Theme createTheme(@RequestBody Theme theme) {
        try {
            return themeRepository.save(theme);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PutMapping("/themes/{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable(value = "id") Long themeId,
                                             @RequestBody Theme themeDetails) {
        Theme theme = themeRepository.findById(themeId)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id = " + themeId));

        theme.setNom(themeDetails.getNom());

        Theme updatedTheme = themeRepository.save(theme);
        return ResponseEntity.ok(updatedTheme);
    }
    @DeleteMapping("/themes/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable("id") Long id) {
        try {
            themeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Failed to delete theme with id = " + id);
        }
    }


}