package com.nakanoi.springer.jpa.controller;

import com.nakanoi.springer.jpa.room.Room;
import com.nakanoi.springer.jpa.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** Simple controller for room. */
@Controller
@RequestMapping("/")
public class RoomController {
  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  @ResponseBody
  public String getRooms() {
    Room room = roomService.getRoom(1);
    room = roomService.createRoom("roomA", 50);
    room = roomService.updateRoom(room.getRoomId(), "updated room");
    roomService.deleteRoom(room.getRoomId());
    return room.toString();
  }
}
