package com.nakanoi.springer.mybatis.domain.mapper;

import com.nakanoi.springer.mybatis.domain.model.MeetingRoom;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoomCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/** Simple mapper interface for room. */
public interface MeetingRoomMapper {
  MeetingRoom findOne(String roomId);

  MeetingRoom findOneWithReservableDates(String roomId);

  MeetingRoom findOneWithReservableDatesOnOneQuery(String string);

  List<MeetingRoom> findAll();

  List<MeetingRoom> findAll(RowBounds rowBounds);

  List<MeetingRoom> findAllByCriteria(
      @Param("criteria") MeetingRoomCriteria criteria,
      @Param("orderByColumn") String orderByColumn);

  @SelectProvider(type = MeetingRoomSqlProvider.class, method = "findAllByCriteria")
  List<MeetingRoom> findAllByCriteriaWithBuilder(MeetingRoomCriteria criteria);

  class MeetingRoomSqlProvider {
    public String findAllByCriteria(MeetingRoomCriteria criteria) {
      return new SQL() {
        {
          SELECT("room_id AS roomId, room_name AS roomName, capacity");
          FROM("meeting_rooms");
          if (criteria.getRoomId() != null) {
            WHERE("room_id LIKE #{roomId} || '%'");
          }
          if (criteria.getRoomName() != null) {
            WHERE("room_name LIKE #{roomName} || '%'");
          }
          if (criteria.getCapacity() != null) {
            WHERE("capacity >= #{capacity}");
          }
          ORDER_BY("room_id");
        }
      }.toString();
    }
  }

  List<MeetingRoom> findByCapacityClass(@Param("capacityClass") String capacityClass);

  List<MeetingRoom> findByRoomIds(List<String> roomIds);

  long count();

  void collectAll(ResultHandler<MeetingRoom> resultHandler);

  void create(MeetingRoom room);

  void create(
      @Param("roomId") String roomId,
      @Param("roomName") String roomName,
      @Param("capacity") int capacity);

  void createWithNullRoomId(MeetingRoom room);

  boolean update(MeetingRoom room);

  void delete(MeetingRoom room);

  void delete(String roomId);
}
