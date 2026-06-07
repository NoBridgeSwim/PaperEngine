package com.paperintelligence.model;

public class PaperSection {

    private String name;
    private String content;


    public PaperSection(String name, String content) {

        this.name = name;
        this.content = content;

    }
    
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
    
}
