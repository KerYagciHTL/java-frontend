package dev.kxrim;

import dev.kxrim.elements.*;

public class Main {
    public static void main(String[] args) {
        HtmlBuilder htmlBuilder = new HtmlBuilder("HtmlBuilder Full Feature Demonstration");

        htmlBuilder.addElement(new Heading(1, "HtmlBuilder Feature Showcase"));
        htmlBuilder.addElement(new Heading(2, "All Available Methods Demonstrated"));

        htmlBuilder.addElement(new Paragraph("This page demonstrates all the features of the HtmlBuilder class."));

        htmlBuilder.addElement(new Div("This is a simple div"));
        htmlBuilder.addElement(new Div("This is a div with a CSS class", "highlighted"));

        htmlBuilder.addElement(new Heading(3, "Buttons"));
        htmlBuilder.addElement(new Button("Simple Button"));
        htmlBuilder.addElement(new Button("Click Me", "alert('Hello from HtmlBuilder!')"));
        htmlBuilder.addElement(new Button("Console Log", "console.log('Button clicked!')"));

        htmlBuilder.addElement(new Heading(3, "Links"));
        htmlBuilder.addElement(new Link("https://github.com/KerYagciHTL", "Visit GitHub"));
        htmlBuilder.addElement(new Link("https://www.java.com", "Learn Java"));

        htmlBuilder.addElement(new Heading(3, "Images"));
        htmlBuilder.addElement(new Image("https://media.tenor.com/mSIfEcNYz5QAAAAj/cute.gif", "Placeholder Image"));

        htmlBuilder.addLocalImage("images/peach.gif", "Company Logo");
        htmlBuilder.copyAssets("images");

        htmlBuilder.addElement(new Heading(3, "Form Elements"));
        htmlBuilder.addElement(new Input("text", "username", "Enter your username"));
        htmlBuilder.addElement(new Input("email", "email", "Enter your email"));
        htmlBuilder.addElement(new Input("password", "password", "Enter your password"));
        htmlBuilder.addElement(new Textarea("message", "Enter your message", 5, 40));

        htmlBuilder.addElement(new Heading(3, "Unordered List"));
        htmlBuilder.addElement(new ListElement(false, "First item", "Second item", "Third item"));

        htmlBuilder.addElement(new Heading(3, "Ordered List"));
        htmlBuilder.addElement(new ListElement(true, "Step one", "Step two", "Step three"));

        htmlBuilder.addElement(new Heading(3, "Text Formatting"));
        htmlBuilder.addElement(new Heading(4, "Subheading"));
        htmlBuilder.addElement(new Heading(5, "Smaller subheading"));
        htmlBuilder.addElement(new Heading(6, "Smallest heading"));
        htmlBuilder.addElement(new BlockQuote("This is a quote using BlockQuote element"));
        htmlBuilder.addElement(new Code("const x = 42;"));
        htmlBuilder.addElement(new Strong("Bold text"));
        htmlBuilder.addElement(new Emphasis("Italic text"));

        htmlBuilder.addElement(new HorizontalRule());
        htmlBuilder.addElement(new Paragraph("Built with ❤️ using HtmlBuilder"));

        htmlBuilder.build();
    }
}
