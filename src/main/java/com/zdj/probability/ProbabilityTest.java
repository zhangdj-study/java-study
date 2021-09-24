package com.zdj.probability;

import com.zdj.designmode.builder.Builder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author zhangdj
 * @date 2021/03/10
 */
public class ProbabilityTest {

    public static final int BOUND = 1000;

    public static final int CYCLE_TIMES = 10000000;
    Random random = new Random();

    static List<Entity> list = new ArrayList<>();

    static {
        list.add(Builder.of(Entity::new).with(Entity::setId, 1).with(Entity::setWeight, 360).build());
        list.add(Builder.of(Entity::new).with(Entity::setId, 2).with(Entity::setWeight, 160).build());
        list.add(Builder.of(Entity::new).with(Entity::setId, 3).with(Entity::setWeight, 160).build());
        list.add(Builder.of(Entity::new).with(Entity::setId, 4).with(Entity::setWeight, 160).build());
        list.add(Builder.of(Entity::new).with(Entity::setId, 5).with(Entity::setWeight, 160).build());
    }

    @Test
    public void t1() {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        for (int i = 0; i < CYCLE_TIMES; i++) {
            Entity byWeight = getByWeight(list);
            switch (byWeight.getId()) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                default:
            }
        }

        System.out.println("一共循环" + CYCLE_TIMES + "次");
        System.out.println("1出现" + count1 + "次," + "概率约为" + (float) count1 / (float) CYCLE_TIMES);
        System.out.println("2出现" + count2 + "次," + "概率约为" + (float) count2 / (float) CYCLE_TIMES);
        System.out.println("3出现" + count3 + "次," + "概率约为" + (float) count3 / (float) CYCLE_TIMES);
        System.out.println("4出现" + count4 + "次," + "概率约为" + (float) count4 / (float) CYCLE_TIMES);
        System.out.println("5出现" + count5 + "次," + "概率约为" + (float) count5 / (float) CYCLE_TIMES);
    }

    private Entity getByWeight(List<Entity> list) {
        int bound = 0;
        int i = random.nextInt(BOUND);
        for (Entity item : list) {
            Integer weight = item.getWeight();
            if (i < weight + bound) {
                return item;
            }
            bound += weight;
        }
        throw new RuntimeException("出错了");
    }

    @Test
    public void randomTest() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            System.out.println(random.nextInt(1));
        }
    }


    @Test
    public void divide() {
        float a = 100f;
        float b = 3f;
        System.out.println(a / b);
    }

    @Test
    public void listSumTest() {
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(Entity::getId));
        System.out.println(collect);
    }

    @Test
    public void exponentialIncrease() {
        int count = 3;
        int result = 2;
        for (int i = 0; i < 5-1; i++) {
            result *= 2;
        }
        System.out.println(result);
    }
}
