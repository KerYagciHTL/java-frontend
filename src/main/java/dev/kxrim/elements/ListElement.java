package dev.kxrim.elements;

public class ListElement implements Element {
    private final boolean ordered;
    private final String[] items;

    public ListElement(boolean ordered, String... items) {
        this.ordered = ordered;
        this.items = items;
    }

    @Override
    public String toHtml() {
        String tag = ordered ? "ol" : "ul";
        StringBuilder sb = new StringBuilder("<").append(tag).append(">\n");
        for (String item : items) {
            sb.append("<li>").append(item).append("</li>\n");
        }
        sb.append("</").append(tag).append(">\n");
        return sb.toString();
    }
}

