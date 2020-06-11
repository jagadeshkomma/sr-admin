package com.statusraja.admin.ringtone;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import com.statusraja.admin.enums.CategoryStatusEnum;
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
		if(fileDetailsVo.getImgfile()!=null) {
			String fileImgUrl=fileUploadService.uploadWebDavServer(fileDetailsVo.getImgfile(),fileDetailsVo.getSrid(), request);
		}
		if(fileURL!=null){
			this.insertRecordInMongo(fileDetailsVo);
		}
		return fileURL;
	}

	private void insertRecordInMongo(FileDetailsVo fileDetailsVo) {
		logger.info("************************ preparing Insert object in mongo ******************");
		try {
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
			fileDetailsVo.setType(CategoryStatusEnum.RINGTONE.getStatus());
			if(fileDetailsVo.getImgfile()!=null) {
				String ImgfileName = fileDetailsVo.getImgfile().getOriginalFilename();
				StringBuilder ImgfilePath =new StringBuilder()
						.append(fileDetailsVo.getSrid()).append(FilePathVariables.FLASH).append(ImgfileName.replaceAll(" ", "_"));
				fileDetailsVo.setBanner_img_url(ImgfilePath.toString());
				fileDetailsVo.setBannerimgName(ImgfileName);
			}
			String duration=getDurationWithMp3(fileDetailsVo.getFile());
			fileDetailsVo.setFile_duration(duration);
			
			ringtoneMongoDao.insertRecordInMongo(fileDetailsVo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static String getDurationWithMp3(MultipartFile multipartFile) throws UnsupportedAudioFileException, IOException {
		
		File file = convertMultiPartToFile(multipartFile);
		String duration=null;
	    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
	    if (fileFormat instanceof TAudioFileFormat) {
	        Map<?, ?> properties = ((TAudioFileFormat) fileFormat).properties();
	        String key = "duration";
	        Long microseconds = (Long) properties.get(key);
	        int mili = (int) (microseconds / 1000);
	        int sec = (mili / 1000) % 60;
	        int min = (mili / 1000) / 60;
	        System.out.println("time = " + min + ":" + sec);
	        duration=min + ":" + sec;
	    } else {
	        throw new UnsupportedAudioFileException();
	    }
	    return duration;
	}
	
	private static File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
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
