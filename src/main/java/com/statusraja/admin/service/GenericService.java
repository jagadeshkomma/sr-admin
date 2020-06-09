package com.statusraja.admin.service;

import java.util.List;

import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

public interface GenericService {

	List<Languages> getLanguageList();

	List<Categories> getCategories(String type);

	void insertRecordInMongo(FileDetailsVo fIleDetailsVo);

}
