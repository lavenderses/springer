package com.nakanoi.springer.advance.file;

import org.springframework.web.multipart.MultipartFile;

/** Simple form for file uploading. */
public class FileUploadForm {
  private MultipartFile file;

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }
}
