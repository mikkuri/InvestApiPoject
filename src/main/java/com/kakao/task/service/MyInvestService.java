package com.kakao.task.service;

import com.kakao.task.domain.model.response.MyInvestGoods;

import java.util.List;

public interface MyInvestService {
    List<MyInvestGoods> getMyInvestGoodsInfos(Long userId);
}
