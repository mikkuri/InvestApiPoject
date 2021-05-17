package com.kakao.task.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsTest {
    @Test
    void test() {
        Goods goods = new Goods();
        goods.setProductId(1L);
        goods.setTitle("test");
        System.out.println("test>> " + goods.toString());
    }

}