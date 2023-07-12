package com.bezkoder.spring.security.postgresql.restDto;

import java.util.List;

public class TutorialDto {


    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Long> getThemeIds() {
        return themeIds;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThemeIds(List<Long> themeIds) {
        this.themeIds = themeIds;
    }

    List<Long> themeIds;


    public TutorialDto(String title, String description, List<Long> themeIds) {
        this.title = title;
        this.description = description;
        this.themeIds = themeIds;
    }
}