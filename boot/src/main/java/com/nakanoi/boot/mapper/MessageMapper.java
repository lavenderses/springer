package com.nakanoi.boot.mapper;

import com.nakanoi.boot.domain.Message;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/** Simple mapper for mybatis. */
@Mapper
public interface MessageMapper {
  @Select("SELECT text FROM messages ORDER BY id")
  List<Message> findAll();

  @Insert("INSERT INTO messages (text) VALUE (#{text})")
  int create(Message message);
}
