package com.sjcu.auction.process.user.domain;

import com.sjcu.auction.process.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
