package dev.kxrim.elements;

public class Input implements Element {
    private final String type;
    private final String name;
    private final String placeholder;

    public Input(String type, String name, String placeholder) {
        this.type = type;
        this.name = name;
        this.placeholder = placeholder;
    }

    @Override
    public String toHtml() {
        return "<input type=\"" + type + "\" name=\"" + name +
               "\" placeholder=\"" + placeholder + "\">\n";
    }
}

