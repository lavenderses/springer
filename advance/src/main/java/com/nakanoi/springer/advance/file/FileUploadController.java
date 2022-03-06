package com.nakanoi.springer.advance.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/** Simple controller for file uploading. */
@Controller
@RequestMapping("/files")
public class FileUploadController {
  @GetMapping
  public String getFileUpload(Model model) {
    model.addAttribute(new FileUploadForm());
    return "files/upload";
  }

  @PostMapping
  public String uploadFile(FileUploadForm form, Model model) {
    MultipartFile file = form.getFile();
    String contentType = file.getContentType();
    String parameterName = file.getName();
    String originalFileName = file.getOriginalFilename();
    long fileSize = file.getSize();
    String content = "";

    try (InputStream stream = file.getInputStream()) {
      InputStreamReader reader = new InputStreamReader(stream);
      BufferedReader bufferedReader = new BufferedReader(reader);
      content = bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    model.addAttribute("content", content);
    return "files/succeeded";
  }
}
