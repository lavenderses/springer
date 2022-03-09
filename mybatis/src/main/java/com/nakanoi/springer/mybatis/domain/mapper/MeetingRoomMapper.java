package com.nakanoi.springer.mybatis.domain.mapper;

import com.nakanoi.springer.mybatis.domain.model.MeetingRoom;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoomCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

/** Simple mapper interface for room. */
public interface MeetingRoomMapper {
  MeetingRoom findOne(String roomId);

  List<MeetingRoom> findAll();

  List<MeetingRoom> findAllByCriteria(
      @Param("criteria") MeetingRoomCriteria criteria,
      @Param("orderByColumn") Integer orderByColumn);

  long count();

  void collectByCapacity(int capacity, ResultHandler<Long> resultHandler);

  void create(MeetingRoom room);

  void create(
      @Param("roomId") String roomId,
      @Param("roomName") String roomName,
      @Param("capacity") int capacity);
}
