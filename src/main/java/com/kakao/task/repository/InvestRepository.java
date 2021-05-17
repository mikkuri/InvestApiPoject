package com.kakao.task.repository;

import com.kakao.task.domain.model.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestRepository extends JpaRepository<Invest, Long> {
    List<Invest> findByUserId(Long userId);
    Invest findByUserIdAndGoodsId(Long userId, Long goodsId);
}
