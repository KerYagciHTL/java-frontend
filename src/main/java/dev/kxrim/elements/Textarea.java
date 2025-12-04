package dev.kxrim.elements;

public class Textarea implements Element {
    private final String name;
    private final String placeholder;
    private final int rows;
    private final int cols;

    public Textarea(String name, String placeholder, int rows, int cols) {
        this.name = name;
        this.placeholder = placeholder;
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public String toHtml() {
        return "<textarea name=\"" + name + "\" placeholder=\"" + placeholder +
               "\" rows=\"" + rows + "\" cols=\"" + cols + "\"></textarea>\n";
    }
}

