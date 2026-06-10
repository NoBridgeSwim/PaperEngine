package com.paperintelligence.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.paperintelligence.model.ResearchPaper;
import com.paperintelligence.parsers.PlainTextParser;

/**
 * Testing:
 * Parser detects section headers
 * Parser stores section content correctly
 * Standardized parse format (all uppercase)
 * Confirms correct text parse
 */
public class PaperParserTest {
    @Test
    void parsesKnownSections() {
        String text = """

                METHODS
                This is the methods section.

                RESULTS
                These are the results.
                """;

        PlainTextParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals(3, paper.getSections().size());
        assertEquals("ABSTRACT", paper.getSections().get(0).getName());
        assertEquals("METHODS", paper.getSections().get(1).getName());
        assertEquals("RESULTS", paper.getSections().get(2).getName());
    }

    @Test
    void parsesSectionContent() {
        String text = """
                METHODS
                This is the methods text.
                """;

        PlainTextParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals("This is the abstract text.", paper.getSections().get(0).getContent());
        assertEquals("This is the methods text.", paper.getSections().get(1).getContent());
    }

    @Test
    void handlesLowercaseHeaders() {
        String text = """
                methods
                This is the methods section.
                """;

        PlainTextParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals(2, paper.getSections().size());
        assertEquals("ABSTRACT", paper.getSections().get(0).getName());
        assertEquals("METHODS", paper.getSections().get(1).getName());
    }

    @Test
    void returnsEmptyPaperForNoKnownSections() {
        String text = """
                This is regular text.
                It has no known section headers.
                """;

        PlainTextParser parser = new PlainTextParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals(0, paper.getSections().size());
    }

}
