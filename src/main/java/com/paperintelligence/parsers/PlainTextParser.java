package com.paperintelligence.parsers;

import java.util.Set;

import com.paperintelligence.model.PaperSection;
import com.paperintelligence.model.ResearchPaper;

public class PlainTextParser implements PaperParser {
    private static final Set<String> KNOWN_SECTIONS = Set.of(
            "SUMMARY",
            "INTRODUCTION",
            "METHODS",
            "RESULTS",
            "DISCUSSION");

    @Override
    public ResearchPaper parse(String text) {
        ResearchPaper paper = new ResearchPaper();

        String[] lines = text.split("\\R");
        String currentSectionName = null;
        StringBuilder currentContent = new StringBuilder();

        for (String line : lines) {
            String trimmedLine = line.trim();
            String upperLine = trimmedLine.toUpperCase();

            // Section header check: is the current line a known header
            if (KNOWN_SECTIONS.contains(upperLine)) {
                // If a new header is recognized, finish the previous line to conclude
                if (currentSectionName != null) {
                    paper.addSection(
                            new PaperSection(currentSectionName, currentContent.toString().trim()));
                }

                // Then Start the new section
                currentSectionName = upperLine;
                currentContent = new StringBuilder();
            } else {
                // If currently within a section, add the line to content.
                if (currentSectionName != null) {
                    currentContent.append(line).append("\n");
                }
            }
        }
        // Add final section once loop ends
        if (currentSectionName != null) {
            paper.addSection(
                    new PaperSection(currentSectionName, currentContent.toString().trim()));

        }
        System.out.println("PlainTextParser scan complete:");
        System.out.println(paper);
        return paper;
    }

}
