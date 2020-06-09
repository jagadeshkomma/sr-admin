package com.statusraja.admin.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.statusraja.admin.enums.CategoryStatusEnum;
import com.statusraja.admin.enums.DigiLockerStatusEnum;
import com.statusraja.admin.mongo.GenericMongoDao;
import com.statusraja.admin.ringtone.RingtoneMongoDao;
import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

@Service
public class GenericServiceImpl implements GenericService {

	private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);
	
	@Autowired
	GenericMongoDao genericMongoDao;

	@Autowired
	RingtoneMongoDao ringtoneMongoDao;
	
	@Override
	public List<Languages> getLanguageList() {
		return genericMongoDao.getLanguageList();
	}

	@Override
	public List<Categories> getCategories(String type) {
		return genericMongoDao.getCategories(type);
	}

	@Override
	public void insertRecordInMongo(FileDetailsVo fileDetailsVo) {
		logger.info("************************ preparing Insert object in mongo ******************");
		try {

			fileDetailsVo.setFileStatus(DigiLockerStatusEnum.ACTIVE.toString());
			fileDetailsVo.setCreateddate(new Date());
			fileDetailsVo.setType(CategoryStatusEnum.TEXTSTATUS.getStatus());

			ringtoneMongoDao.insertRecordInMongo(fileDetailsVo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
