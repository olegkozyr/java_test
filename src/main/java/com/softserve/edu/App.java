package com.softserve.edu;

public class App { // extends Object
    private int i = 123;

    public void print() {
        System.out.println("i = " + i);
    }

    @Override
    public String toString() {
        return "App{" +
                "i=" + i +
                '}';
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("main i = " + app.i);
        app.print();
        //
        App app2 = new App();
        app2.i = 456;
        System.out.println("main i2 = " + app2.i);
        app2.print();
        //
        System.out.println("main i = " + app.i);
        //
        System.out.println("app = " + app);
    }
}
