package com.paperintelligence;

import java.io.IOException;

import com.paperintelligence.model.ResearchPaper;

//stores parsing logic, beggining with PaperParser
public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0 || args[0].isBlank()) {
            throw new IllegalArgumentException("Missing XML File path");
        }

        // Convert XML file to single text string

        String xmlFilePath = args[0];

        PaperProcessingPipeline pipeline = new PaperProcessingPipeline();
        ResearchPaper paper = pipeline.processXml(xmlFilePath);

        System.out.println("Sections found:");
        System.out.println(paper);
        paper.getSections().forEach(section -> {
            System.out.println(section.getName());
            System.out.println(section.getContent());
            System.out.println("--------------------");
        });
    }
}
