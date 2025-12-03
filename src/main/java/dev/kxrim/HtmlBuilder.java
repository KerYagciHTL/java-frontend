package dev.kxrim;

import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmlBuilder {
    private final StringBuilder html;
    private final StringBuilder head;
    private String title = "Document";
    private String lang = "en";
    private String charset = "UTF-8";
    private String viewport = "width=device-width, initial-scale=1.0";

    public HtmlBuilder() {
        html = new StringBuilder();
        head = new StringBuilder();
        buildHead();
    }

    private void buildHead() {
        head.setLength(0); // Clear the StringBuilder
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

    public void build() {
        head.append(html);
        head.append("</body>\n");
        head.append("</html>");

        try {
            // create generated folder if not exists
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

    public void setLang(String lang) {
        this.lang = lang;
        buildHead();
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
        buildHead();
    }

    public String getViewport() {
        return viewport;
    }

    public void setViewport(String viewport) {
        this.viewport = viewport;
        buildHead();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        buildHead();
    }
}
