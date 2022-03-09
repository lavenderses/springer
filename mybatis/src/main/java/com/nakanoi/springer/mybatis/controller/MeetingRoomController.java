package com.nakanoi.springer.mybatis.controller;

import com.nakanoi.springer.mybatis.service.MeetingRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller for check mybatis. */
@Controller
@RequestMapping("/")
public class MeetingRoomController {
  MeetingRoomService meetingRoomService;

  public MeetingRoomController(MeetingRoomService meetingRoomService) {
    this.meetingRoomService = meetingRoomService;
  }

  @GetMapping
  @ResponseBody
  public String getMeetingRoom() {
    meetingRoomService.callMyBatisApis();

    return "Succeeded.";
  }
}
