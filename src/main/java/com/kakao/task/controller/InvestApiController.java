package com.kakao.task.controller;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.response.MyInvestGoods;
import com.kakao.task.service.InvestService;
import com.kakao.task.service.MyInvestService;
import com.kakao.task.service.UpdateInvestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class InvestApiController {

    private final InvestService investService;
    private final UpdateInvestService updateInvestService;
    private final MyInvestService myInvestService;

    @GetMapping("/invest/goods")
    public List<Goods> getInvestGoodsInfo() {
        return investService.getGoods();
    }

    @PutMapping("/invest/put/{goodsId}/{investAmount}")
    public String doInvest(@RequestHeader Map<String, Object> requestHeader, @PathVariable Long goodsId, @PathVariable Long investAmount) {
        final var X_USER_ID = Long.parseLong(String.valueOf(requestHeader.get("x-user-id")));

        return updateInvestService.updateInvestGoodsInfo(X_USER_ID, goodsId, investAmount);
    }

    @GetMapping("/invest/my_goods")
    public List<MyInvestGoods> getMyInvestGoodsInfo(@RequestHeader Map<String, Object> requestHeader) {
        final var X_USER_ID = Long.parseLong(String.valueOf(requestHeader.get("x-user-id")));

        return myInvestService.getMyInvestGoodsInfos(X_USER_ID);
    }

    @GetMapping("/invest/hello")
    public String hello() {
        return "hello invest api";
    }

}
