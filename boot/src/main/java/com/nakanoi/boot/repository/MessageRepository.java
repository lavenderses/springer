package com.nakanoi.boot.repository;

import com.nakanoi.boot.domain.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/** Simple repository for message. */
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {}
