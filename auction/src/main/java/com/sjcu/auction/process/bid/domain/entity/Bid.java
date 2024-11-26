package com.sjcu.auction.process.bid.domain.entity;

import com.sjcu.auction.process.auction.domain.entity.Auction;
import com.sjcu.auction.process.user.domain.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    @ManyToOne
    @JoinColumn(name = "auctionId", nullable = false)
    private Auction auction; // 입찰한 경매

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user; // 입찰자

    @Column(nullable = false)
    private Double amount; // 입찰 금액

    @Column(nullable = false)
    private LocalDateTime bidTime; // 입찰 시간
}
