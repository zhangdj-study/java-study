package com.neusiri.hashcode;

/**
 * @author zhangdj
 * @date 2020-01-20 13:03
 */
public class Key {

    private Integer id;

    public Key(Integer id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || ! (o instanceof Key)){
            return false;
        }else {
            return this.id.equals(((Key) o).id);
        }
    }

//    @Override
//    public int hashCode() {
//        return this.id;
//    }


}
