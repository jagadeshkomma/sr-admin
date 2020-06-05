package com.statusraja.admin.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.statusraja.admin.enums.DigiLockerFileTypeEnum;

public class FileFormatsUtil {

	public String getFileType(MultipartFile multipart) {
		List<String> imageList = new ArrayList<>();
		List<String> audioList = new ArrayList<>();
		List<String> videoList = new ArrayList<>();
		List<String> documentList = new ArrayList<>();
		imageList.add("jpg");
		imageList.add("jpeg");
		imageList.add("png");

		audioList.add("wav");
		audioList.add("mp3");

		videoList.add("avi");
		videoList.add("flv");
		videoList.add("wmv");
		videoList.add("mov");
		videoList.add("mp4");

		documentList.add("pdf");
		documentList.add("xml");
		documentList.add("xlsx");
		documentList.add("xls");
		documentList.add("doc");
		documentList.add("docx");
		documentList.add("json");
		documentList.add("pptx");
		documentList.add("ppt");
		documentList.add("txt");
		documentList.add("log");

		String fileName = multipart.getOriginalFilename();
		String fileExtention = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (imageList.contains(fileExtention.toLowerCase()))
			return DigiLockerFileTypeEnum.IMAGE.toString();
		else if (audioList.contains(fileExtention.toLowerCase()))
			return DigiLockerFileTypeEnum.AUDIO.toString();
		else if (videoList.contains(fileExtention.toLowerCase()))
			return DigiLockerFileTypeEnum.VIDEO.toString();
		else if (documentList.contains(fileExtention.toLowerCase()))
			return DigiLockerFileTypeEnum.DOCUMENT.toString();
		else
			return DigiLockerFileTypeEnum.UNKNOWN.toString();

	}// getFileType() closing

	public String fileExtension(MultipartFile multipart) {
		String fileName = multipart.getOriginalFilename();
		if (fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg")
				|| fileName.endsWith(".gif")) {
			return "IMG";
		} else if (fileName.endsWith(".pdf")) {
			return "PDF";
		} else if (fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) {
			return "XLS";
		} else if (fileName.endsWith(".txt")) {
			return "TXT";
		} else if (fileName.endsWith(".doc") || fileName.endsWith(".docx")) {
			return "DOC";
		} else
			return "UNKNOWN";
	}

}
