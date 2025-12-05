package dev.kxrim.elements;

import java.util.ArrayList;
import java.util.List;

public class Div implements Element {
    private String textContent;
    private final String className;
    private final String id;
    private final List<Element> children;

    public Div(String content) {
        this(content, null, null);
    }

    public Div(String content, String className) {
        this(content, className, null);
    }

    public Div(String content, String className, String id) {
        this.textContent = content;
        this.className = className;
        this.id = id;
        this.children = new ArrayList<>();
    }

    public Div() {
        this(null, null, null);
    }

    public Div(String className, boolean isClassConstructor) {
        this(null, className, null);
    }

    public Div add(Element element) {
        this.children.add(element);
        return this;
    }

    public Div addText(String text) {
        if (this.textContent == null) {
            this.textContent = text;
        } else {
            this.textContent += text;
        }
        return this;
    }

    public Div heading(int level, String text) {
        return add(new Heading(level, text));
    }

    public Div paragraph(String content) {
        return add(new Paragraph(content));
    }

    public Div div(String content) {
        return add(new Div(content));
    }

    public Div div(String content, String className) {
        return add(new Div(content, className));
    }

    public Div div(Div nestedDiv) {
        return add(nestedDiv);
    }

    public Div button(String text) {
        return add(new Button(text));
    }

    public Div button(String text, String onClick) {
        return add(new Button(text, onClick));
    }

    public Div link(String url, String text) {
        return add(new Link(url, text));
    }

    public Div image(String src, String alt) {
        return add(new Image(src, alt));
    }

    public Div input(String type, String name, String placeholder) {
        return add(new Input(type, name, placeholder));
    }

    public Div textarea(String name, String placeholder, int rows, int cols) {
        return add(new Textarea(name, placeholder, rows, cols));
    }

    public Div listUnordered(String... items) {
        return add(new ListElement(false, items));
    }

    public Div listOrdered(String... items) {
        return add(new ListElement(true, items));
    }

    public Div blockQuote(String content) {
        return add(new BlockQuote(content));
    }

    public Div code(String content) {
        return add(new Code(content));
    }

    public Div strong(String content) {
        return add(new Strong(content));
    }

    public Div emphasis(String content) {
        return add(new Emphasis(content));
    }

    public Div horizontalRule() {
        return add(new HorizontalRule());
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder("<div");

        if (className != null && !className.isEmpty()) {
            sb.append(" class=\"").append(className).append("\"");
        }

        if (id != null && !id.isEmpty()) {
            sb.append(" id=\"").append(id).append("\"");
        }

        sb.append(">");

        if (textContent != null && !textContent.isEmpty()) {
            sb.append(textContent);
        }

        for (Element child : children) {
            sb.append(child.toHtml());
        }

        sb.append("</div>\n");
        return sb.toString();
    }
}

