package com.statusraja.admin.upload.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	String uploadWebDavServer(MultipartFile file, Integer filepathId, HttpServletRequest request);


}
