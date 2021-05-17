package com.kakao.task.repository;

import com.kakao.task.domain.model.Invest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InvestRepositoryTest {

    @Autowired
    InvestRepository investRepository;

    @Test
    void getInvestGoodsByUserIdTest() {
        Invest invest = new Invest(1212L, 1L, 100000L);

        investRepository.save(invest);

        System.out.println("investTest:" +investRepository.findAll());
    }

}