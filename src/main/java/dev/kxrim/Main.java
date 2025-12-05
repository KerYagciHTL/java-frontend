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
               .paragraph("Built with ❤️ using HtmlBuilder");

        builder.heading(2, "Div Fluent API Demonstration")
               .paragraph("The Div class now supports fluent API for nesting elements:");

        Div card = new Div("container", true)
                .heading(3, "Card Title")
                .paragraph("This is a card created using the Div fluent API.")
                .button("Action Button", "alert('Card button clicked!')");

        builder.div(card);

        Div complexDiv = new Div("wrapper", true)
                .addText("This div contains multiple nested elements:")
                .div(new Div("inner-section", true)
                        .heading(4, "Nested Section")
                        .paragraph("This paragraph is inside a nested div.")
                        .listUnordered("Nested item 1", "Nested item 2", "Nested item 3"))
                .horizontalRule()
                .paragraph("Back to the outer div content.")
                .link(GITHUB_URL, "GitHub Link inside Div");

        builder.div(complexDiv);

        builder.div(builder.createDiv("highlight")
                .heading(4, "Created via Builder")
                .paragraph("This div was created using builder.createDiv().")
                .code("builder.createDiv(\"className\").paragraph(\"text\");"));

        builder.div(new Div()
                .heading(4, "Simple Inline Div")
                .paragraph("Created without a class name.")
                .strong("Bold text inside div")
                .emphasis("Italic text inside div"));

        builder.build();
    }
}
