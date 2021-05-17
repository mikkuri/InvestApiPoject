package com.kakao.task.repository;

import com.kakao.task.domain.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findByStartedAtBeforeAndFinishedAtAfter(LocalDateTime startedAt, LocalDateTime finishedAt);
    List<Goods> findByTitle(String title);
}
