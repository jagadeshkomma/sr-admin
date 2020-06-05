package com.statusraja.admin.ringtone;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.statusraja.admin.vo.FileDetailsVo;

public interface RingtoneService {

	String uploadFiles(FileDetailsVo fIleDetailsVo, HttpServletRequest request);

	Integer getMaxSrid();

	List<FileDetailsVo> getMasterDetailsList(String type);

}
