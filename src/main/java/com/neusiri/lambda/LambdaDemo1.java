package com.neusiri.lambda;

/**
 * @author zhangdj
 * @date 2019/7/26
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //调用show方法 并使用lambada表达式实现方法的逻辑
        System.out.println("单行语句1---------");
        show((n, m) -> n + m + n + m);
        //为了增强可读性，也可以加上数据类型
        System.out.println("单行语句2---------");
        show((String n, String m) -> n + m + n + m);
        //也可以写成 语句块 的形式，可以实现多行业务逻辑，而且必须显示使用return。 上面两种方式只能单行
        System.out.println("语句块--------");
        show((n, m) -> {
            System.out.println(n);
            return n + m + n + m;
        });
        //静态方法引用   method1方法参数类型 和MyInterface接口中的抽象方法参数类型及个数相同
        // 可以使用方法引用 将method1方法作为逻辑传递给MyInterface
        System.out.println("静态方法引用------");
        show(LambdaDemo1::staticMethod);
        //实例对象引用 就是方法不是静态的 需要new出实例引用方法
        System.out.println("实例对象引用-----");
        show(new LambdaDemo1()::noStaticMethod);
        //参数对象引用
        System.out.println("参数对象引用-----");
        //等价于show((n, m) -> m.concat(m))
        show(String::concat);

    }

    public static void show(MyInterface myInterface) {
        System.out.println(myInterface.get("a", "b"));
    }

    public static String staticMethod(String m, String n) {
        return m + n;
    }

    public String noStaticMethod(String m, String n) {
        return m + n;
    }

    /**
     * 声明一个接口,可以使用@FunctionalInterface 标记该接口是一个函数式接口 只要不满足函数式接口的条件就会报错
     */
    @FunctionalInterface
    public interface MyInterface {
        String get(String m, String n);
    }
}
