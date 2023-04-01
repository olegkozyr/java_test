package com.softserve.edu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private Pattern Regex;
    public Pattern getPattern() {
        return Regex;
    }

    public App() {
        this.Regex = Pattern.compile("^([a-zA-Z])+\\w*(\\.\\w+)*@(\\w+\\.)+\\w{2,}");
    }
    public boolean checkEmail(String text) {
        if (text == null) { return false; }

        Matcher m = Regex.matcher(text);
        return  m.matches();
    }

    public void printMatches(String text) {
        if (checkEmail(text)) {
            System.out.println("Matches: TRUE");
        } else {
            System.out.println("Matches: FALSE");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Pattern = " + app.getPattern());
        String text = "a.bd.c@gmail.com";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "first.second.third@mail.com.ua";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "a.b.c@gmail.com";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "a@i.ua";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "a.@gmail.com";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "a@gmail.a";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "a@gmail";
        System.out.print(text + " - ");
        app.printMatches(text);
        text = "@gmail.ua";
        System.out.print(text + " - ");
        app.printMatches(text);
    }
}
