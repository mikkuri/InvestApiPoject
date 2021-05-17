package com.kakao.task.service;

import com.kakao.task.domain.model.response.GoodsStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateInvestServiceImpl implements UpdateInvestService{

    private final InvestService investService;

    @Override
    public String updateInvestGoodsInfo(Long userId, Long goodsId, Long investAmount) {
        GoodsStatus investResponse = investService.updateGoods(goodsId, investAmount);

        if (GoodsStatus.CONTINUE.equals(investResponse))
            investService.updateMyGoods(userId, goodsId, investAmount);

        return investResponse.getStatus();
    }
}
