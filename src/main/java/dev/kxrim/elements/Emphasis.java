package dev.kxrim.elements;

public class Emphasis implements Element {
    private final String content;

    public Emphasis(String content) {
        this.content = content;
    }

    @Override
    public String toHtml() {
        return "<em>" + content + "</em>\n";
    }
}

