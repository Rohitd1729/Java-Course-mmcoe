package com.mmcoe.ds;

public class Stack<T> {

    private Object[] arr;
    private int top;

    public Stack() {
        arr = new Object[10];
        top = -1;
    }

    public void push(T data) {

        if(top == arr.length - 1) {
            throw new IllegalStateException("Stack Overflow");
        }

        arr[++top] = data;
    }

    public T pop() {

        if(top == -1) {
            throw new IllegalStateException("Stack Underflow");
        }

        T data = (T) arr[top];
        arr[top] = null;
        top--;

        return data;
    }

    public void print() {

        if(top == -1) {
            System.out.println("Stack Empty");
            return;
        }

        for(int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}