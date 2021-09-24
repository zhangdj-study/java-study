package com.zdj.copyproperties;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
public class CopyPropertiesTest {

    @Test
    public void test(){
        PersonDO personDO = new PersonDO(1L,"zhangsan",new Date(),20);
        PersonVO personVO = new PersonVO();
        BeanUtils.copyProperties(personDO,personVO);
        System.out.println(personDO);
        System.out.println(personVO);
    }

    @Test
    public void test2(){
        PersonDO personDO = new PersonDO(1L,"zhangsan",new Date(),20);
        PersonVO personVO = ResponseUtil.converter(personDO, PersonVO.class);
        System.out.println(personDO);
        System.out.println(personVO);
    }

    @Test
    public void test3(){
        List<PersonDO> list = new ArrayList<>();
        PersonDO personDO1 = new PersonDO(1L,"zhangsan",new Date(),20);
        PersonDO personDO2 = new PersonDO(2L,"zhangsan",new Date(),20);
        PersonDO personDO3 = new PersonDO(3L,"zhangsan",new Date(),20);
        list.add(personDO1);
        list.add(personDO2);
        list.add(personDO3);
        List<PersonVO> voList = ResponseUtil.converterListToList(list, PersonVO.class);
        System.out.println(list);
        System.out.println(voList);
        throw new RuntimeException("123");
    }
}
