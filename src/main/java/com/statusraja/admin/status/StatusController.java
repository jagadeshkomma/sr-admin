package com.statusraja.admin.status;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.statusraja.admin.ringtone.RingtoneService;
import com.statusraja.admin.vo.FileDetailsVo;

@Controller
@RequestMapping("/admin")
public class StatusController {

	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

	@Autowired
	RingtoneService ringtoneService;
	
	@GetMapping("/statuslist")
	public ModelAndView getStatuslist() {
		logger.info("Welcome to status list!..");
		ModelAndView model = new ModelAndView("/admin/ringtone/status-list");
		List<FileDetailsVo> fileDetailsVos=ringtoneService.getMasterDetailsList("status");
		model.addObject("fileDetailsVos", fileDetailsVos);
		
		return model;
	}
}
