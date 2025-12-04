package dev.kxrim.elements;

public class Button implements Element {
    private final String text;
    private final String onClick;

    public Button(String text) {
        this(text, null);
    }

    public Button(String text, String onClick) {
        this.text = text;
        this.onClick = onClick;
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder("<button");
        if (onClick != null && !onClick.isEmpty()) {
            sb.append(" onclick=\"").append(onClick).append("\"");
        }
        sb.append(">").append(text).append("</button>\n");
        return sb.toString();
    }
}

