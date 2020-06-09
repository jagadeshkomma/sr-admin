package com.statusraja.admin.status;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.statusraja.admin.enums.CategoryStatusEnum;
import com.statusraja.admin.ringtone.RingtoneService;
import com.statusraja.admin.service.GenericService;
import com.statusraja.admin.vo.Categories;
import com.statusraja.admin.vo.FileDetailsVo;
import com.statusraja.admin.vo.Languages;

@Controller
@RequestMapping("/admin")
public class StatusController {

	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@Autowired
	GenericService genericService;
	
	@GetMapping("/statuslist")
	public ModelAndView getStatuslist() {
		logger.info("Welcome to status list!..");
		ModelAndView model = new ModelAndView("/admin/status/status-list");
		List<FileDetailsVo> fileDetailsVos=ringtoneService.getMasterDetailsList(CategoryStatusEnum.TEXTSTATUS.getStatus());
		model.addObject("fileDetailsVos", fileDetailsVos);
		return model;
	}
	
	@GetMapping("/add-status")
	public ModelAndView addStatus() {
		logger.info("add to status !..");
		ModelAndView model = new ModelAndView("/admin/status/add_status");
		List<Languages> languages=genericService.getLanguageList();
		List<Categories> categories=genericService.getCategories(CategoryStatusEnum.TEXTSTATUS.getStatus());
		model.addObject("languages", languages);
		model.addObject("categories", categories);
		return model;
	}
	
	@PostMapping("/add-status")
	public ModelAndView submitRingtone(@ModelAttribute FileDetailsVo fIleDetailsVo,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.info("add to ringtone !..");
		ModelAndView mvc = new ModelAndView("/admin/ringtone/add_status");
		Integer srid=ringtoneService.getMaxSrid();
		if(srid!=null) {
			fIleDetailsVo.setSrid(srid);
		}else {
			fIleDetailsVo.setSrid(1);
		}
		genericService.insertRecordInMongo(fIleDetailsVo);
        mvc.setViewName("redirect:/admin/statuslist");
		return mvc;
	}
}
