package dev.kxrim.elements;

public class Image implements Element {
    private final String src;
    private final String alt;

    public Image(String src, String alt) {
        this.src = src;
        this.alt = alt;
    }

    @Override
    public String toHtml() {
        return "<img src=\"" + src + "\" alt=\"" + alt + "\">\n";
    }
}

