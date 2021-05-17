package com.kakao.task.repository;

import com.kakao.task.domain.model.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@Transactional
class GoodsRepositoryTest {
    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    void crud() {
        Goods goods = goodsRepository.getOne(1L);
        Goods goods1 = goodsRepository.findById(1L).orElse(null);

        System.out.println(goods1);

    }

    @Test
    void selectByStartedAtAfterAndFinishedAtBefore() {
        System.out.println("findByRecruitmentStatusAndStartedAtBeforeAndFinishedAtAfter :" +
                goodsRepository.findByStartedAtBeforeAndFinishedAtAfter(LocalDateTime.now(), LocalDateTime.now()));

    }

    @Test
    void update() {
       Goods goods = goodsRepository.findById(1L).orElseThrow(RuntimeException::new);
       goods.setNumberOfInvestors(1);

        goodsRepository.save(goods);
       System.out.println(goods);
    }

    @Test
    void prePersistTest() {
        Goods goods = new Goods("prePersistTest", 10000000L, 0L, 0, false, LocalDateTime.of(LocalDate.of(2021, 05, 01), LocalTime.MIN), LocalDateTime.of(LocalDate.of(2021, 05, 30), LocalTime.MAX));
        goodsRepository.save(goods);

        System.out.println("prePersistTest" + goodsRepository.findByTitle("prePersistTest"));
    }

    @Test
    void preUpdateTest() {
        Goods goods = goodsRepository.findById(1L).orElseThrow(RuntimeException::new);
        goods.setTitle("preUpdateTest");

        System.out.println("preUpdateTest" + goodsRepository.findByTitle("preUpdateTest"));
    }

}