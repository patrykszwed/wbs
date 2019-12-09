package com.example.demo;

public class Calculator {
    private int first;
    private int second;
    private int third;
    private int forth;
    private int fifth;
    private int sum;

    public void sum(){
        this.sum = this.first + this.second + this.third + this.forth + this.fifth;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public int getForth() {
        return forth;
    }

    public void setForth(int forth) {
        this.forth = forth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setFifth(int fifth) {
        this.fifth = fifth;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
