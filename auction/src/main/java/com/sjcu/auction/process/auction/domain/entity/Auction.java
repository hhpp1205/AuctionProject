package com.sjcu.auction.process.auction.domain.entity;

import com.sjcu.auction.process.auction.enums.AuctionStatus;
import com.sjcu.auction.process.bid.domain.entity.Bid;
import com.sjcu.auction.process.user.domain.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User sellerId; // 판매자

    @Column(nullable = false)
    private String title; // 상품 제목

    @Column(nullable = false)
    private String description; // 상품 설명

    @Column(nullable = false)
    private Double startingPrice; // 시작 가격

    @Column(nullable = true)
    private Double currentPrice; // 현재 최고 입찰가

    @Column(nullable = false)
    private LocalDateTime startTime; // 경매 시작 시간

    @Column(nullable = false)
    private LocalDateTime endTime; // 경매 종료 시간

    @OneToMany(mappedBy = "auction")
    private List<Bid> bids; // 입찰 목록

    @Enumerated(EnumType.STRING)
    private AuctionStatus status; // 경매 상태 (OPEN, CLOSED 등)
}

