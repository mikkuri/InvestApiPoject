package com.kakao.task.repository;

import com.kakao.task.domain.model.Invest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvestRepositoryTest {

    @Autowired
    InvestRepository investRepository;

    @Test
    void getInvestGoodsByUserIdTest() {
        Invest invest = new Invest(1212L, 1L, 100000L);
        investRepository.save(invest);

        Invest invest2 = new Invest(1212L, 1L, 5000L);
        investRepository.save(invest2);

        Invest invest3 = new Invest(1211L, 2L, 100000L);
        investRepository.save(invest3);

        assertEquals(100000L, investRepository.findByUserId(1212L).get(0).getInvestAmount());
        assertEquals(1L, investRepository.findByUserId(1212L).get(0).getGoodsId());

        assertEquals(5000L, investRepository.findByUserId(1212L).get(1).getInvestAmount());
        assertEquals(1L, investRepository.findByUserId(1212L).get(1).getGoodsId());

        assertEquals(100000L, investRepository.findByUserId(1211L).get(0).getInvestAmount());
        assertEquals(2L, investRepository.findByUserId(1211L).get(0).getGoodsId());
    }

    @Test
    void update() {
        Invest invest = new Invest(1212L, 1L, 100000L);
        investRepository.save(invest);

        invest.setInvestAmount(150000L);
        investRepository.save(invest);

        assertEquals(150000L, investRepository.findByUserId(1212L).get(0).getInvestAmount());
    }

    @Test
    void fetByUserIdAndGoodsIdTest() {
        Invest invest = new Invest(1212L, 1L, 100000L);
        investRepository.save(invest);

        Invest invest3 = new Invest(1211L, 2L, 100000L);
        investRepository.save(invest3);

        assertEquals(100000L, investRepository.findByUserIdAndGoodsId(1212L, 1L).getInvestAmount());
        assertEquals(100000L, investRepository.findByUserIdAndGoodsId(1211L, 2L).getInvestAmount());
    }


}