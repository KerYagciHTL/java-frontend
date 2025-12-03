package dev.kxrim;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlBuilder {
    private final StringBuilder html;
    private final StringBuilder head;
    private final String title;
    private final String lang;
    private final String charset;
    private final String viewport;

    public HtmlBuilder() {
        this("en", "UTF-8", "width=device-width, initial-scale=1.0", "Document");
    }

    public HtmlBuilder(String title) {
        this("en", "UTF-8", "width=device-width, initial-scale=1.0", title);
    }

    public HtmlBuilder(String lang, String charset, String viewport, String title) {
        html = new StringBuilder();
        head = new StringBuilder();

        this.lang = lang;
        this.charset = charset;
        this.viewport = viewport;
        this.title = title;

        buildHead();
    }

    private void buildHead() {
        head.setLength(0);
        head.append("<!DOCTYPE html>\n");
        head.append("<html lang=\"").append(lang).append("\">\n");
        head.append("<head>\n");
        head.append("<meta charset=\"").append(charset).append("\">\n");
        head.append("<meta name=\"viewport\" content=\"").append(viewport).append("\">\n");
        head.append("<title>").append(title).append("</title>\n");
        head.append("</head>\n");
        head.append("<body>\n");
    }

    public void addElement(String tag, String content) {
        html.append("<").append(tag).append(">")
            .append(content)
            .append("</").append(tag).append(">\n");
    }

    public void addButton(String text) {
        html.append("<button>")
            .append(text)
            .append("</button>\n");
    }

    public void addButton(String text, String onClick) {
        html.append("<button onclick=\"")
            .append(onClick)
            .append("\">")
            .append(text)
            .append("</button>\n");
    }

    public void addDiv(String content) {
        html.append("<div>")
            .append(content)
            .append("</div>\n");
    }

    public void addDiv(String content, String className) {
        html.append("<div class=\"")
            .append(className)
            .append("\">")
            .append(content)
            .append("</div>\n");
    }

    public void addLink(String href, String text) {
        html.append("<a href=\"")
            .append(href)
            .append("\">")
            .append(text)
            .append("</a>\n");
    }

    public void addImage(String src, String alt) {
        html.append("<img src=\"")
            .append(src)
            .append("\" alt=\"")
            .append(alt)
            .append("\">\n");
    }

    public void addInput(String type, String name, String placeholder) {
        html.append("<input type=\"")
            .append(type)
            .append("\" name=\"")
            .append(name)
            .append("\" placeholder=\"")
            .append(placeholder)
            .append("\">\n");
    }

    public void addTextarea(String name, String placeholder, int rows, int cols) {
        html.append("<textarea name=\"")
            .append(name)
            .append("\" placeholder=\"")
            .append(placeholder)
            .append("\" rows=\"")
            .append(rows)
            .append("\" cols=\"")
            .append(cols)
            .append("\"></textarea>\n");
    }

    public void build() {
        head.append(html);
        head.append("</body>\n");
        head.append("</html>");

        try {
            Files.createDirectories(Paths.get("generated"));
            var filePath = Paths.get("generated/index.html");
            Files.writeString(filePath, head.toString());
            System.out.println("HTML file created at: " + filePath.toAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getLang() {
        return lang;
    }

    public String getCharset() {
        return charset;
    }

    public String getViewport() {
        return viewport;
    }

    public String getTitle() {
        return title;
    }
}
