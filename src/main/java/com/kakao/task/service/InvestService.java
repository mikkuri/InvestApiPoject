package com.kakao.task.service;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import com.kakao.task.domain.model.response.GoodsStatus;

import java.util.List;

public interface InvestService {
    List<Goods> getGoods();
    Goods getGoodsById(Long id);
    GoodsStatus updateGoods(Long goodsId, Long investAmount);
    void updateMyGoods(Long userId, Long goodsId, Long investAmount);
    List<Invest> getMyInvestGoods(Long userId);
}
