package com.statusraja.admin.ringtone;

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

import com.statusraja.admin.vo.FileDetailsVo;

@Controller
@RequestMapping("/admin")
public class RingTonesController {
	
	private static final Logger logger = LoggerFactory.getLogger(RingTonesController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@GetMapping("/ringtoneslist")
	public ModelAndView getRingtoneList() {
		logger.info("Welcome to ringtone list!..");
		ModelAndView model = new ModelAndView("/admin/ringtone/ringtones_list");
		List<FileDetailsVo> fileDetailsVos=ringtoneService.getMasterDetailsList("ringtone");
		model.addObject("fileDetailsVos", fileDetailsVos);
		
		return model;
	}
	
	@GetMapping("/add/ringtone")
	public ModelAndView addRingtone() {
		logger.info("add to ringtone !..");
		ModelAndView model = new ModelAndView("/admin/ringtone/add_ringtone");
		return model;
	}
	
	@PostMapping("/add/ringtone")
	public ModelAndView submitRingtone(@ModelAttribute FileDetailsVo fIleDetailsVo,RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.info("add to ringtone !..");
		ModelAndView mvc = new ModelAndView("/admin/ringtone/ringtones_list");
		Integer srid=ringtoneService.getMaxSrid();
		if(srid!=null) {
			fIleDetailsVo.setSrid(srid);
		}else {
			fIleDetailsVo.setSrid(1);
		}
		//########## above code is to upload files in filebank root folder ###############
		String fileUrl=null;
        if (!fIleDetailsVo.getFile().isEmpty()) {
        	fileUrl=ringtoneService.uploadFiles(fIleDetailsVo, request );
        	if(fileUrl!=null)
        		mvc.addObject("message","file uploaded successfully!");
        }
		
		return mvc;
	}
}
