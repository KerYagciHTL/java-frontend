package dev.kxrim.elements;

public class Code implements Element {
    private final String content;

    public Code(String content) {
        this.content = content;
    }

    @Override
    public String toHtml() {
        return "<code>" + content + "</code>\n";
    }
}

