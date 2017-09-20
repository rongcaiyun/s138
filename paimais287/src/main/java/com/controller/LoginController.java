package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.AuctionUserService;

@Controller
public class LoginController {
	@Autowired
	private AuctionUserService auctionUserService;

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		return "auctionLogin";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String userName, String userPassword, String randomNum,
			HttpSession session, Model model) {
		// 1.判断验证码和session中的验证码是否一致
		if (session.getAttribute("numrand") != null) {
			if (randomNum.equals(session.getAttribute("numrand").toString())) {
				// 2.判断用户名和密码在数据库中是否存在
				Map<String, Object> map = auctionUserService.login(userName,
						userPassword);
				if (map.get("status").equals("-1")) {
					// 帐户不存在
					model.addAttribute("mess", "帐户不存在");
				} else if (map.get("status").equals("0")) {
					model.addAttribute("mess", "密码错误");
				} else {
					// 成功
					session.setAttribute("user", map.get("user"));
					return "redirect:auctionList.do";
				}
			} else {
				// 验证码错误
				model.addAttribute("mess", "验证码错误");
			}
		} else {
			model.addAttribute("mess", "页面已过期");
		}
		return "auctionLogin";
	}
}
