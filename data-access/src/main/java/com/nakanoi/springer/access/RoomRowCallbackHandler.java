package com.nakanoi.springer.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowCallbackHandler;

/** Room row callback handler. */
public class RoomRowCallbackHandler implements RowCallbackHandler {

  @Override
  public void processRow(ResultSet rs) throws SQLException {
    try (BufferedWriter writer =
        new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(File.createTempFile("room_", ".csv")),
                StandardCharsets.UTF_8))) {
      while (rs.next()) {
        List<String> array =
            List.of(
                new String[] {
                  rs.getString("room_id"), rs.getString("room_name"), rs.getString("capacity")
                });
        String reportRow = String.join(",", array);
        writer.write(reportRow);
        writer.newLine();
        writer.flush();
      }
    } catch (IOException e) {
      throw new SQLException(e);
    }
  }
}
