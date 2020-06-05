package com.statusraja.admin.ringtone;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statusraja.admin.enums.DigiLockerStatusEnum;
import com.statusraja.admin.upload.service.FilePathVariables;
import com.statusraja.admin.upload.service.FileUploadService;
import com.statusraja.admin.vo.FileDetailsVo;

@Service
public class RingtoneServiceImpl implements RingtoneService {

	private static final Logger logger = LoggerFactory.getLogger(RingtoneServiceImpl.class);
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	RingtoneMongoDao ringtoneMongoDao;
	
	@Override
	public String uploadFiles(FileDetailsVo fileDetailsVo, HttpServletRequest request) {
		
		String fileURL=fileUploadService.uploadWebDavServer(fileDetailsVo.getFile(),fileDetailsVo.getSrid(), request);
		if(fileURL!=null){
			this.insertRecordInMongo(fileDetailsVo);
		}
		return fileURL;
	}

	private void insertRecordInMongo(FileDetailsVo fileDetailsVo) {
		logger.info("************************ preparing Insert object in mongo ******************");
		
		String fileName = fileDetailsVo.getFile().getOriginalFilename();
		StringBuilder filePath =new StringBuilder()
		.append(fileDetailsVo.getSrid()).append(FilePathVariables.FLASH).append(fileName.replaceAll(" ", "_"));
		logger.info(" FilePath :: {}", filePath);
		
		String fileExtension=fileName.substring(fileName.lastIndexOf(".")+1);
		fileDetailsVo.setSrid(fileDetailsVo.getSrid());
		fileDetailsVo.setExtension(fileExtension);
		fileDetailsVo.setFilename(fileName);
		fileDetailsVo.setFile_url(filePath.toString());
		fileDetailsVo.setFileStatus(DigiLockerStatusEnum.ACTIVE.toString());
		fileDetailsVo.setCreateddate(new Date());
		fileDetailsVo.setType("ringtone");
		
		ringtoneMongoDao.insertRecordInMongo(fileDetailsVo);
	}

	@Override
	public Integer getMaxSrid() {
		return ringtoneMongoDao.getMaxSrid();
	}

	@Override
	public List<FileDetailsVo> getMasterDetailsList(String type) {
		return ringtoneMongoDao.getMasterDetailsList(type);
	}

}
