package com.nakanoi.springer.mybatis.controller;

import com.nakanoi.springer.mybatis.domain.mapper.MeetingRoomMapper;
import com.nakanoi.springer.mybatis.domain.model.MeetingRoom;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller for check mybatis. */
@Controller
@RequestMapping("/")
public class MeetingRoomController {
  MeetingRoomMapper meetingRoomMapper;

  public MeetingRoomController(MeetingRoomMapper meetingRoomMapper) {
    this.meetingRoomMapper = meetingRoomMapper;
  }

  @GetMapping
  @ResponseBody
  public String getMeetingRoom() {
    MeetingRoom room = meetingRoomMapper.findOne("X001");
    List<MeetingRoom> rooms = meetingRoomMapper.findAll();
    long roomNumber = meetingRoomMapper.count();
    return "Succeeded.";
  }
}
