package com.nakanoi.springer.access;

/** No room id found exception. */
public class NotFoundRoomIdException extends RuntimeException {

  /**
   * Exception for no room ID.
   *
   * @param message Exception message.
   */
  public NotFoundRoomIdException(String message) {
    super(message);
  }
}
