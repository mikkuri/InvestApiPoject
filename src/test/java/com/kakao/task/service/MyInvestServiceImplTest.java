package com.kakao.task.service;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import com.kakao.task.domain.model.response.MyInvestGoods;
import com.kakao.task.repository.InvestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyInvestServiceImplTest {

    @Autowired
    InvestService investService;

    @Autowired
    InvestRepository investRepository;

    @Test
    void getMyInvestGoodsInfosTest() {
        Long userId = 1234L;

        Invest investGoods = new Invest(1234L, 1L, 10000L);
        investRepository.save(investGoods);

        List<Invest> myInvestInfo = investService.getMyInvestGoods(userId);

        System.out.println("myInvetInfo:::" + myInvestInfo);
        List<MyInvestGoods> myInvestGoods = myInvestInfo.stream()
                .map(invest -> {
                    Goods goods = investService.getGoodsById(invest.getGoodsId());
                    return MyInvestGoods.of(invest, goods);
                })
                .collect(Collectors.toList());
        assertEquals(1L, myInvestGoods.get(0).getProductId());
    }

}