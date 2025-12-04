# HtmlForge

A Java library that makes building HTML way easier. Tired of writing HTML as strings? Yeah, me too.

## What's this?

If you're a backend developer who's ever had to write HTML, you know the pain. String concatenation everywhere, escaped quotes making your eyes hurt, and messy code that's impossible to maintain. HtmlForge changes the game! Just create objects for your HTML elements, compose them together, and you're done. Clean, readable, and actually enjoyable to work with.

## Quick Look

```java
HtmlBuilder builder = new HtmlBuilder("My Page");

builder.addElement(new Heading(1, "Welcome"));
builder.addElement(new Paragraph("This is so much easier than strings."));
builder.addElement(new Link("https://github.com", "Check it out"));

builder.build();
```

That's it. It generates proper HTML for you.

## How it Works

Every HTML element is a class. They all implement the `Element` interface, which basically just means they know how to turn themselves into HTML. You create the elements you want, add them to a builder, and boom – HTML document.

### Basic Elements

```java
// Text stuff
new Heading(1, "Big title");
new Paragraph("Just some text");
new Strong("Make it bold");
new Emphasis("Or italic");

// Links and images
new Link("https://example.com", "Click me");
new Image("cat.jpg", "A cute cat");

// Buttons
new Button("Click here");
new Button("Alert", "alert('Hi!')");

// Containers for grouping stuff
new Div("Put things in here");
```

### Forms

```java
new Input("text", "username", "Your name");
new Input("email", "email", "your@email.com");
new Textarea("message", "Type something", 5, 40);
```

### Lists

```java
// Bullet list
new ListElement(false, "First thing", "Second thing", "Third thing");

// Numbered list  
new ListElement(true, "Step 1", "Step 2", "Step 3");
```

## What You Can Build With

**Text Elements**
- `Heading` - H1 through H6, you pick the number
- `Paragraph` - Regular text
- `Strong` - Bold text
- `Emphasis` - Italic text
- `Code` - For showing code snippets
- `BlockQuote` - Quotes and stuff

**Interactive Stuff**
- `Link` - Links to other pages
- `Button` - Buttons that can run JavaScript
- `Input` - Text fields, email, password, whatever
- `Textarea` - Bigger text boxes

**Layout**
- `Div` - The classic container
- `ListElement` - Ordered or unordered lists
- `HorizontalRule` - Those `<hr>` lines

**Media**
- `Image` - Pictures (works with URLs and local files)

## Adding Your Own Elements

Want to create a custom element? Just implement the `Element` interface:

```java
public class MyElement implements Element {
    @Override
    public String toHtml() {
        return "<whatever>your html here</whatever>";
    }
}
```

Then use it like any other element. Easy.

## The Files

```
src/main/java/dev/kxrim/
├── HtmlBuilder.java          # The main class that builds everything
├── Main.java                 # Example of how to use it
└── elements/                 # All the HTML elements
    ├── Element.java          # The interface everyone implements
    ├── Div.java
    ├── Paragraph.java
    └── ... all the others
```

## Running the Example

```bash
mvn compile
mvn exec:java -Dexec.mainClass="dev.kxrim.Main"
```

Check the `generated/` folder for your HTML file.

## Why This Exists

Because writing HTML in Java strings sucks. This way you get:
- No more escaping quotes everywhere
- Your IDE actually helps you with autocomplete
- Catch mistakes when you compile, not when you run
- Easier to read and modify

## Contributing

If you want to add more elements or fix something, go for it. The code is pretty straightforward. Just make sure to test your changes before submitting.

## License

MIT License with Attribution

You're free to use, modify, and distribute this software. If you make changes or use it in your project, just give credit to the original author (KerYagciHTL). That's it.

**TL;DR**: Use it however you want, just keep the credits if you modify or redistribute it.
