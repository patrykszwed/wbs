package com.example.demo;

public class MyString {

    private String first;
    private String second;
    private String third;
    private String result;

    public MyString(){}

    public MyString(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;


    }

    public String concatenate(){
        this.result = this.getFirst().concat(this.getSecond()).concat(this.getThird());
        return this.result;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
