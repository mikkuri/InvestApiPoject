package com.kakao.task.service;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import com.kakao.task.domain.model.response.MyInvestGoods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyInvestServiceImpl implements MyInvestService{

    private final InvestService investService;

    public List<MyInvestGoods> getMyInvestGoodsInfos(Long userId) {
        List<Invest> myInvestInfo = investService.getMyInvestGoods(userId);

        System.out.println("myInvetInfo:::" + myInvestInfo);
        List<MyInvestGoods> myInvestGoods = myInvestInfo.stream()
                .map(invest -> {
                    Goods goods = investService.getGoodsById(invest.getGoodsId());
                    return MyInvestGoods.of(invest, goods);
                })
                .collect(Collectors.toList());
        System.out.println("myInvestGoods:::" + myInvestGoods);

        return myInvestGoods;
    }
}
