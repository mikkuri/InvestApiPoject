package com.kakao.task.service;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import com.kakao.task.repository.GoodsRepository;
import com.kakao.task.repository.InvestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InvestServiceImplTest {

    @Autowired
    InvestRepository investRepository;
    @Autowired
    GoodsRepository goodsRepository;

    @Test
    void getInvestGoodsByUserIdTest() {
        Invest invest = new Invest(12344L, 1L, 100000L);
        investRepository.save(invest);

        Invest invest2 = new Invest(123445L, 1L, 100000L);
        investRepository.save(invest2);

        Invest invest3 = new Invest(123446L, 1L, 100000L);
        investRepository.save(invest3);

        Invest invest4 = new Invest(12344L, 1L, 100000L);
        investRepository.save(invest4);

        Long userId = 12344L;
        List<Invest> myInvestGoods = investRepository.findByUserId(userId);

        List<Invest> testGoods = new ArrayList<>();
        testGoods.add(invest);
        testGoods.add(invest4);

        assertEquals(myInvestGoods, testGoods);
    }

    @Test
    void updateGoods() {
        Goods goods = goodsRepository.findById(1L).orElseThrow(RuntimeException::new);
        goods.setNumberOfInvestors(goods.getNumberOfInvestors() + 1);
        goods.setNowInvestingAmount(goods.getTotalInvestingAmount() + 100000);

        goodsRepository.save(goods);

        assertEquals(goods.getNumberOfInvestors(), 1);
        assertEquals(goods.getNowInvestingAmount(), 1100000);
    }

}