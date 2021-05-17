package com.kakao.task.domain.model.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GoodsStatus {

    CONTINUE("투자 완료되었습니다."),
    COMPLETE("모집이 완료된 상품입니다."),
    SOLD_OUT("모집 금액을 초과하였습니다.");

    @Getter
    public final String status;
}
