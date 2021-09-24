package com.zdj.lambda.lambdademo1;

/**
 * @author zhangdj
 * @date 2019/8/1
 */
@FunctionalInterface
public interface AppleFilter {

    /**
     * 过滤条件抽象化
     * @param apple
     * @return
     */
    boolean accept(Apple apple);
}
