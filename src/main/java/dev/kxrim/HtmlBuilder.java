package dev.kxrim;

import dev.kxrim.elements.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class HtmlBuilder {
    private final StringBuilder html;
    private final StringBuilder head;
    private final String title;
    private final String lang;
    private final String charset;
    private final String viewport;
    private static final Path OUTPUT_DIR = Paths.get("generated");
    private static final Path ASSETS_DIR = OUTPUT_DIR.resolve("assets");

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

    public void addElement(Element element) {
        html.append(element.toHtml());
    }


    public void copyAssets(String sourceDir) {
        try {
            Path sourcePath = Paths.get(sourceDir);
            if (!Files.exists(sourcePath) || !Files.isDirectory(sourcePath)) {
                System.out.println("Source directory does not exist: " + sourceDir);
                return;
            }

            Files.createDirectories(ASSETS_DIR);

            try (Stream<Path> files = Files.walk(sourcePath)) {
                files.filter(Files::isRegularFile)
                     .filter(p -> {
                         String name = p.getFileName().toString().toLowerCase();
                         return name.endsWith(".png") || name.endsWith(".jpg") ||
                                name.endsWith(".jpeg") || name.endsWith(".gif") ||
                                name.endsWith(".svg") || name.endsWith(".webp");
                     })
                     .forEach(source -> {
                         try {
                             Path destination = ASSETS_DIR.resolve(source.getFileName());
                             Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                             System.out.println("Copied asset: " + source.getFileName() + " -> assets/");
                         } catch (IOException e) {
                             System.err.println("Failed to copy: " + source);
                         }
                     });
            }
        } catch (IOException e) {
            System.err.println("Error copying assets: " + e.getMessage());
        }
    }

    public void addLocalImage(String localPath, String alt) {
        try {
            Path source = Paths.get(localPath);
            if (!Files.exists(source)) {
                System.err.println("Image file not found: " + localPath);
                addElement(new Image(localPath, alt)); // Add anyway with original path
                return;
            }

            Files.createDirectories(ASSETS_DIR);
            String fileName = source.getFileName().toString();
            Path destination = ASSETS_DIR.resolve(fileName);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

            addElement(new Image("assets/" + fileName, alt));
            System.out.println("Added local image: " + fileName);
        } catch (IOException e) {
            System.err.println("Error adding local image: " + e.getMessage());
            addElement(new Image(localPath, alt)); // Fallback to original path
        }
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
