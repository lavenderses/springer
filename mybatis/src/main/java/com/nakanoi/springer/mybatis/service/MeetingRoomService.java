package com.nakanoi.springer.mybatis.service;

import com.nakanoi.springer.mybatis.domain.mapper.MeetingRoomMapper;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoom;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoomCriteria;
import java.util.List;
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
    List<MeetingRoom> rooms = meetingRoomMapper.findAll();
    long roomNumber = meetingRoomMapper.count();
    MeetingRoomCriteria criteria = new MeetingRoomCriteria(10);
    rooms = meetingRoomMapper.findAllByCriteria(criteria, "room_name");

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
