package dev.kxrim.elements;

public class BlockQuote implements Element {
    private final String content;

    public BlockQuote(String content) {
        this.content = content;
    }

    @Override
    public String toHtml() {
        return "<blockquote>" + content + "</blockquote>\n";
    }
}

