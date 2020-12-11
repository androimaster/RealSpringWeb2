package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.common.util.CommonUtil;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest req, HttpServletResponse res) {
        Locale locale = new Locale("ko", "KR");
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("combo", CommonUtil.getSelect());
        return "home";
    }

    @GetMapping("home/registForm")
    public String registForm(Model model, HttpServletRequest req, HttpServletResponse res) { 
        return "home/registForm";
    }

    @RequestMapping("/study/doReg")
    public String doReg(@RequestParam Map<String, String> map, Model model, HttpServletRequest req, HttpServletResponse res) {
         System.out.println("Parameter :: " + map.toString());
         return "home/registOK";
    }
}
