package com.paperintelligence.parser;

import com.paperintelligence.model.ResearchPaper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
                ABSTRACT
                This is the abstract.

                METHODS
                This is the methods section.

                RESULTS
                These are the results.
                """;

        PaperParser parser = new PaperParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals(3, paper.getSections().size());
        assertEquals("ABSTRACT", paper.getSections().get(0).getName());
        assertEquals("METHODS", paper.getSections().get(1).getName());
        assertEquals("RESULTS", paper.getSections().get(2).getName());
    }

    @Test
    void parsesSectionContent() {
        String text = """
                ABSTRACT
                This is the abstract text.

                METHODS
                This is the methods text.
                """;

        PaperParser parser = new PaperParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals("This is the abstract text.", paper.getSections().get(0).getContent());
        assertEquals("This is the methods text.", paper.getSections().get(1).getContent());
    }

    @Test
    void handlesLowercaseHeaders() {
        String text = """
                abstract
                This is the abstract.

                methods
                This is the methods section.
                """;

        PaperParser parser = new PaperParser();
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

        PaperParser parser = new PaperParser();
        ResearchPaper paper = parser.parse(text);

        assertEquals(0, paper.getSections().size());
    }

}
