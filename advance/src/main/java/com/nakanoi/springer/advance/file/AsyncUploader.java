package com.nakanoi.springer.advance.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

/** Simple async file uploader. */
@Component
public class AsyncUploader {
  /**
   * Read uploaded file.
   *
   * @param form File upload form.
   * @param model Spring model.
   * @return File upload future.
   */
  @Async
  public CompletableFuture<String> upload(FileUploadForm form, Model model) {
    MultipartFile file = form.getFile();
    String content = file.getContentType() + " | ";
    content += file.getOriginalFilename() + " | ";
    content += file.getName() + " | ";

    try (InputStream stream = file.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      content += bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    model.addAttribute("content", content);

    return CompletableFuture.completedFuture("files/succeeded");
  }
}
