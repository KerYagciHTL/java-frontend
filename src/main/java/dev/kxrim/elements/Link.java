package dev.kxrim.elements;

public class Link implements Element {
    private final String href;
    private final String text;

    public Link(String href, String text) {
        this.href = href;
        this.text = text;
    }

    @Override
    public String toHtml() {
        return "<a href=\"" + href + "\">" + text + "</a>\n";
    }
}

