package com.paperintelligence.model;

import java.util.ArrayList;
import java.util.List;

public class ResearchPaper {
    // belong to each ResearchPaper object
    private String title;
    private List<String> authors;
    private List<PaperSection> sections;

    public ResearchPaper() {
        this.authors = new ArrayList<>();
        this.sections = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String author) {
        authors.add(author);
    }

    public void addSection(PaperSection section) {
        sections.add(section);
    }

    public List<PaperSection> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (PaperSection section : sections) {
            sb.append(section.getName()).append("\n");
            sb.append(section.getContent()).append("\n");
            sb.append("--------------------\n");

        }
        return sb.toString();
    }

}
