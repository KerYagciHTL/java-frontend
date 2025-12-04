package dev.kxrim.elements;

public class Paragraph implements Element {
    private final String content;

    public Paragraph(String content) {
        this.content = content;
    }

    @Override
    public String toHtml() {
        return "<p>" + content + "</p>\n";
    }
}

