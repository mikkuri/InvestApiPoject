package com.kakao.task.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
public class Goods {
    //상품 ID, 상품 제목, 총 모집금액, 현재 모집금액, 투자자 수,
    //투자모집상태(모집중, 모집 완료), 상품 모집기간

    @Id
    @GeneratedValue
    private Long productId;

    @NonNull
    private String title;

    @NonNull
    private Long totalInvestingAmount;

    @NonNull
    private Long nowInvestingAmount;

    @NonNull
    private int numberOfInvestors;

    @NonNull
    private boolean recruitmentStatus;

    @NonNull
    private LocalDateTime startedAt;

    @NonNull
    private LocalDateTime finishedAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
