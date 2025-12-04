package dev.kxrim.elements;
public class Heading implements Element {
    private final int level;
    private final String content;
    public Heading(int level, String content) {
        if (level < 1 || level > 6) {
            throw new IllegalArgumentException("Heading level must be between 1 and 6");
        }
        this.level = level;
        this.content = content;
    }
    @Override
    public String toHtml() {
        return "<h" + level + ">" + content + "</h" + level + ">\n";
    }
}
