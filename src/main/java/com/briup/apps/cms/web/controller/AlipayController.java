package com.briup.apps.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alipay")
public class AlipayController {
	@GetMapping("/show")
	public String showPay() {
		return "index";
	}
	
	@PostMapping("/pay")
	public String pay() {
		return "alipay.trade.page.pay";
	}
}
