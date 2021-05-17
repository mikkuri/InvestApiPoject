package com.kakao.task.domain.model.response;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@RequiredArgsConstructor
public class MyInvestGoods {
    /*상품 ID, 상품 제목, 총 모집금액, 나의 투자금액, 투자일시*/
    Long productId;

    String productTitle;

    Long totalInvestingAmount;

    Long investAmount;

    LocalDateTime investDateTime;


    public static MyInvestGoods of(Invest invest, Goods goods) {
        return MyInvestGoods.builder()
                .productId(goods.getProductId())
                .productTitle(goods.getTitle())
                .totalInvestingAmount(goods.getTotalInvestingAmount())
                .investAmount(invest.getInvestAmount())
                .investDateTime(invest.getUpdatedAt())
                .build();
    }
}
