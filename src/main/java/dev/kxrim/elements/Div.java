package dev.kxrim.elements;

public class Div implements Element {
    private final String content;
    private final String className;

    public Div(String content) {
        this(content, null);
    }

    public Div(String content, String className) {
        this.content = content;
        this.className = className;
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder("<div");
        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }
        sb.append(">").append(content).append("</div>\n");
        return sb.toString();
    }
}

