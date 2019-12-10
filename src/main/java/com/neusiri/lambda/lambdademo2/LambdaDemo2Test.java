package com.neusiri.lambda.lambdademo2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhangdj
 * @date 2019/8/1
 */
public class LambdaDemo2Test {

    @Test
    public void predicateTest() {
        List<Integer> integerList = new ArrayList<>();
        integerList.addAll(Arrays.asList(1, 1, 2, 3, 4, 5, 6));
        List<Integer> filterList = predicateFilter(integerList, num -> num % 2 == 0);
        System.out.println(filterList);

    }

    public <T> List<T> predicateFilter(List<T> integers, Predicate<T> predicate) {
        List<T> filterList = new ArrayList<>();
        for (T t : integers) {
            //满足条件加入到集合中
            if (predicate.test(t)) {
                filterList.add(t);
            }
        }
        return filterList;
    }


    @Test
    public void consumerTest() {
        Consumer<String> consumer = p -> System.out.println(p);
        consumer.accept("123");
    }

    /**
     *  Function<T, R>    R apply(T t);
     */
    @Test
    public void functionTest() {
        Function<Integer,Double> function = p -> p * 10.0;
        System.out.println(function.apply(7));
    }
}
