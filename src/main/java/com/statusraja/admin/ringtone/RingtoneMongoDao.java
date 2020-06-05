package com.statusraja.admin.ringtone;

import java.util.List;

import com.statusraja.admin.vo.FileDetailsVo;

public interface RingtoneMongoDao {

	void insertRecordInMongo(FileDetailsVo fileDetailsVo);

	Integer getMaxSrid();

	List<FileDetailsVo> getMasterDetailsList(String type);

}
