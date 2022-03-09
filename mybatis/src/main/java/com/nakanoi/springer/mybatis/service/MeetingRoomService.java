package com.nakanoi.springer.mybatis.service;

import com.nakanoi.springer.mybatis.domain.mapper.MeetingRoomMapper;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoom;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoomCriteria;
import java.util.Arrays;
import java.util.List;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Simple service for meeting room. */
@Service
public class MeetingRoomService {
  MeetingRoomMapper meetingRoomMapper;

  public MeetingRoomService(MeetingRoomMapper meetingRoomMapper) {
    this.meetingRoomMapper = meetingRoomMapper;
  }

  @Transactional
  public void callMyBatisApis() {
    MeetingRoom room = meetingRoomMapper.findOne("X001");
    room = meetingRoomMapper.findOneWithReservableDates("X001");
    room = meetingRoomMapper.findOneWithReservableDatesOnOneQuery("A090");
    List<MeetingRoom> rooms = meetingRoomMapper.findAll();
    RowBounds rowBounds = new RowBounds(1, 2);
    rooms = meetingRoomMapper.findAll(rowBounds);
    MeetingRoomCriteria criteria = new MeetingRoomCriteria(20);
    rooms = meetingRoomMapper.findAllByCriteria(criteria, "room_name");
    rooms = meetingRoomMapper.findAllByCriteriaWithBuilder(criteria);
    rooms = meetingRoomMapper.findByCapacityClass("small");
    rooms = meetingRoomMapper.findByRoomIds(Arrays.asList("A090", "Y222"));

    long roomNumber = meetingRoomMapper.count();
    meetingRoomMapper.collectAll(
        context -> {
          int resultPosition = context.getResultCount();
          MeetingRoom resultRoom = context.getResultObject();
        });

    String newRoomId = "xyz";
    String newRoomName = "Hole X";
    int newRoomCapacity = 3;
    String updateRoomName = "Hole XYZ";
    int updateRoomCapacity = 5;

    MeetingRoom newRoom = new MeetingRoom();
    newRoom.setRoomId(newRoomId);
    newRoom.setRoomName(newRoomName);
    newRoom.setCapacity(newRoomCapacity);

    meetingRoomMapper.create(newRoom);
    newRoom.setRoomName(updateRoomName);
    newRoom.setCapacity(updateRoomCapacity);
    boolean isUpdated = meetingRoomMapper.update(newRoom);
    newRoom.setRoomName(newRoomName);
    newRoom.setCapacity(newRoomCapacity);
    meetingRoomMapper.delete(newRoom);

    meetingRoomMapper.create(newRoomId, newRoomName, newRoomCapacity);
    meetingRoomMapper.delete(newRoomId);

    newRoom.setRoomId(null);
    meetingRoomMapper.createWithNullRoomId(newRoom);
    meetingRoomMapper.delete(newRoom);
  }
}
