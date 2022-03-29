package com.springdemo;

public class Bar {
    private String name;
    private int age;
    private Foo foo;

    public Bar() {

    }

    public Bar(String name, int age,Foo foo) {
        this.name = name;
        this.age = age;
        this.foo=foo;
    }

//    public void setFoo(Foo foo) {
//        this.foo = foo;
//    }

    public void processFooName() {
        System.out.println("Name in Injected Foo is: " + foo.getName());
    }

    public String toString() {
        return "Bar has name= " + this.name + " and age= " + this.age;
    }
}

