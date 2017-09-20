package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.AuctionRecordService;
import com.service.AuctionService;

@Controller
public class AuctionRecordController {
	@Autowired
	private AuctionRecordService auctionRecordService;
	@Autowired
	private AuctionService auctionService;
	@RequestMapping("/endRsult.do")
	public String getEndResult(Model model){
		model.addAttribute("endResult", auctionRecordService.getAuctionEndResult());
		model.addAttribute("preResult", auctionService.getNotEndResult());
		return "auctionResult";
	}
}
