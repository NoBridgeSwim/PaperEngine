package com.paperintelligence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.paperintelligence.model.ResearchPaper;
import com.paperintelligence.parsers.PaperParser;
import com.paperintelligence.parsers.PlainTextParser;

//stores parsing logic, beggining with PaperParser
public class Main {
    public static void main(String[] args) throws IOException {

        String text = Files.readString(Path.of("data/paper.txt"));

        PaperParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(text);

        System.out.println("Sections found:");
        paper.getSections().forEach(section -> System.out.println(section.getName()));

    }

}
