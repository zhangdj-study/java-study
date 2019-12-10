package com.neusiri.obj;

/**
 * @author zhangdj
 * @date 2019/10/24
 */
public class MyTest {
    public static void main(String[] args) {
        Object o = getPerson();
        if (o instanceof Person){
            System.out.println(((Person) o).getName());
        }
    }

    public static Object getPerson(){
        Person p = new Person();
        p.setName("111");
        return p;
    }
}
