package dev.kxrim.elements;

public class Strong implements Element {
    private final String content;

    public Strong(String content) {
        this.content = content;
    }

    @Override
    public String toHtml() {
        return "<strong>" + content + "</strong>\n";
    }
}

