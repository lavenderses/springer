package com.nakanoi.springer.advance.file;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/** Simple controller for file uploading. */
@Controller
@RequestMapping("/files")
public class FileUploadController {
  @Autowired AsyncUploader asyncUploader;
  @Autowired FileMessager fileMessager;

  @GetMapping
  public String getFileUpload(Model model) {
    model.addAttribute(new FileUploadForm());
    return "files/upload";
  }

  @GetMapping("/emmit")
  public SseEmitter getFileWithEmmiter() throws IOException, InterruptedException {
    SseEmitter emitter = new SseEmitter();
    fileMessager.send(emitter);
    return emitter;
  }

  @PostMapping
  public CompletableFuture<String> uploadFile(FileUploadForm form, Model model) {
    return asyncUploader.upload(form, model);
  }
}
