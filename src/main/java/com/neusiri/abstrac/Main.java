package com.neusiri.abstrac;

/**
 * @author zhangdj
 * @date 2020-06-04 17:49
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person() {
            @Override
            public void method() {
                System.out.println("method....");
            }
        };
        person.method();
    }

    public void print() {
        System.out.println("Aaaaaa");
    }
}
