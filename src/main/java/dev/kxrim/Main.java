package dev.kxrim;

import dev.kxrim.elements.*;

/**
 * Main demonstration class showcasing my HtmlBuilder library.
 * Demonstrates all available HTML elements and their usage patterns.
 *
 * @author KerYagciHTL
 * @version 1.0
 */
public class Main {
    private static final String PAGE_TITLE = "HtmlBuilder Full Feature Demonstration";
    private static final String GITHUB_URL = "https://github.com/KerYagciHTL/java-frontend";
    private static final String JAVA_URL = "https://www.java.com";

    public static void main(String[] args) {
        HtmlBuilder builder = new HtmlBuilder(PAGE_TITLE);

        // Using fluent API - chain all method calls
        builder.heading(1, "HtmlBuilder Feature Showcase")
               .heading(2, "All Available Methods Demonstrated")
               .paragraph("This page demonstrates all the features of the HtmlBuilder class.")
               .div("This is a simple div")
               .div("This is a div with a CSS class", "highlighted")
               .heading(3, "Buttons")
               .button("Simple Button")
               .button("Click Me", "alert('Hello from HtmlBuilder!')")
               .button("Console Log", "console.log('Button clicked!')")
               .heading(3, "Links")
               .link(GITHUB_URL, "Visit GitHub")
               .link(JAVA_URL, "Learn Java")
               .heading(3, "Images")
               .image("https://media.tenor.com/mSIfEcNYz5QAAAAj/cute.gif", "Placeholder Image")
               .addLocalImage("images/peach.gif", "GIF")
               .copyAssets("images")
               .heading(3, "Form Elements")
               .input("text", "username", "Enter your username")
               .input("email", "email", "Enter your email")
               .input("password", "password", "Enter your password")
               .textarea("message", "Enter your message", 5, 40)
               .heading(3, "Unordered List")
               .listUnordered("First item", "Second item", "Third item")
               .heading(3, "Ordered List")
               .listOrdered("Step one", "Step two", "Step three")
               .heading(3, "Text Formatting")
               .heading(4, "Subheading")
               .heading(5, "Smaller subheading")
               .heading(6, "Smallest heading")
               .blockQuote("This is a quote using BlockQuote element")
               .code("const x = 42;")
               .strong("Bold text")
               .emphasis("Italic text")
               .horizontalRule()
               .paragraph("Built with ❤️ using HtmlBuilder")
               .build();
    }
}
