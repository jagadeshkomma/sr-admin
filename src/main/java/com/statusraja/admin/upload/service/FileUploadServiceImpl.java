package com.statusraja.admin.upload.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.statusraja.admin.constant.WebDavServerConstant;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	static Sardine sardine = SardineFactory.begin();
	
	@Override
	public String uploadWebDavServer(MultipartFile multipartFile,Integer filepathId, HttpServletRequest request) {
		boolean status=false;
		String fileURL=null;
		String filename=multipartFile.getOriginalFilename().replaceAll(" ", "_");
		File file =new File(filename);
		System.out.println("file name::"+file.getAbsolutePath());
		InputStream fis;
		try {
			 byte[] bytes = multipartFile.getBytes();
			fis = new ByteArrayInputStream(bytes);
			StringBuilder directoryPath=new StringBuilder(WebDavServerConstant.WEBDAV_SERVER_URL);
			//directoryPath.append(FilePathVariables.FLASH).append(FilePathVariables.DOWNLOAD_RINGTONE);
			directoryPath.append(FilePathVariables.FLASH).append(filepathId);
			//unCreatedFolder(folderPath);
			if(!sardine.exists(directoryPath.toString()))
				sardine.createDirectory(directoryPath.toString());
			
			sardine.put(directoryPath+"/"+filename, fis);
			//sardine.delete("http://104.155.27.172:8081/caweb_admin/images/actions/delete.png");
			System.out.println("file stored successfully!");
			//status=true;
			//fileURL=directoryPath+"/"+filename;
			fileURL=request.getContextPath()+WebDavServerConstant.MEDIA_URL+"?filePath="+filepathId+""+filename;
		
		} catch (Exception e) {	
			e.printStackTrace();
			fileURL=null;;
		}
		
		return fileURL;
	}

	

}
