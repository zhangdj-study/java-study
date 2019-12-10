package com.neusiri.lambda.lambdademo1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangdj
 * @date 2019/8/1
 */
public class AppleTest {


    /**
     * 过滤指定条件的Apple
     */
    @Test
    public void appleTest(){
        List<Apple> list = new ArrayList<>();
        Apple apple1 = new Apple(1L,"blue",10f,"北京");
        list.add(apple1);
        Apple apple2 = new Apple(2L,"red",9f,"山东");
        list.add(apple2);
        Apple apple3 = new Apple(3L,"yellow",8f,"广州");
        list.add(apple3);
        //过滤出红色的苹果
        List<Apple> filterApples = filterApple(list, (Apple a) -> "red".equals(a.getColor()));
        System.out.println(filterApples);
    }

    /**
     * 创建一个过滤方法
     * @param apples 要过滤的原始列表
     * @param appleFilter 函数式接口
     * @return 过滤后的列表
     */
    public List<Apple> filterApple(List<Apple> apples,AppleFilter appleFilter){
        List<Apple> filterApples = new ArrayList<>();
        for (Apple apple : apples){
            if (appleFilter.accept(apple)){
                filterApples.add(apple);
            }
        }
        return filterApples;
    }
}
