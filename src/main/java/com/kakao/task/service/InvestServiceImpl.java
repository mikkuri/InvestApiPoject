package com.kakao.task.service;

import com.kakao.task.domain.model.Goods;
import com.kakao.task.domain.model.Invest;
import com.kakao.task.domain.model.response.GoodsStatus;
import com.kakao.task.repository.GoodsRepository;
import com.kakao.task.repository.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvestServiceImpl implements InvestService{

    private final InvestRepository investRepository;
    private final GoodsRepository goodsRepository;

    @Override
    public List<Goods> getGoods() {
        List<Goods> goods = goodsRepository.findByStartedAtBeforeAndFinishedAtAfter(LocalDateTime.now(), LocalDateTime.now());
        return goods;
    }

    @Override
    public Goods getGoodsById(Long id) {
        Goods goods = goodsRepository.findById(id).orElseThrow(RuntimeException::new);
        return goods;
    }

    @Override
    public GoodsStatus updateGoods(Long goodsId, Long investAmount) {
        Goods goods = goodsRepository.findById(goodsId).orElseThrow(RuntimeException::new);

        if (!goods.isRecruitmentStatus())
            return GoodsStatus.COMPLETE;
        else if (goods.getNowInvestingAmount() + investAmount > goods.getTotalInvestingAmount())
            return GoodsStatus.SOLD_OUT;

        goods.setNumberOfInvestors(goods.getNumberOfInvestors() + 1);
        goods.setNowInvestingAmount(goods.getNowInvestingAmount() + investAmount);
        goodsRepository.save(goods);

        return GoodsStatus.CONTINUE;
    }

    @Override
    public void updateMyGoods(Long userId, Long goodsId, Long investAmount) {
        Invest myInvestGoods = investRepository.findByUserIdAndGoodsId(userId, goodsId);
        if (Objects.nonNull(myInvestGoods)) {
            myInvestGoods.setInvestAmount(myInvestGoods.getInvestAmount() + investAmount);
            investRepository.save(myInvestGoods);
        } else {
            Invest myNewGoods = new Invest(userId, goodsId, investAmount);
            investRepository.save(myNewGoods);
        }
    }

    @Override
    public List<Invest> getMyInvestGoods(Long userId) {
        List<Invest> myInvestGoods = investRepository.findByUserId(userId);

        return myInvestGoods;
    }

}
