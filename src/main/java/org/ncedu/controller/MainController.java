package org.ncedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 *
 */
@Controller
public class MainController {

    private static final String OAUTH_URL = "https://oauth.vk.com/authorize";
    private static final String CLIENT_ID = "client_id=5691009";
    private static final String REDIRECT_URI = "redirect_uri=http://localhost:3306/VKMusicListener/oauth2";
    private static final String SCOPE = "scope=65544";
    private static final String RESPONCE_TYPE = "response_type=token&v=5.60";
    private static final String VERSION_API = "v=5.60";

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String vkAuth(ModelMap model) {
        return "redirect:"+
                OAUTH_URL+
                "?"+
                CLIENT_ID+"&"+
                REDIRECT_URI+"&"+
                SCOPE+"&"+
                RESPONCE_TYPE+"&"+
                VERSION_API;
    }


    @RequestMapping(value = "oauth2")
    public String redirectOverJs() {
        return "auth";
    }

    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }
    @RequestMapping(value = "user")
    public String getUser (@RequestParam(value = "access_token") String token,
                           @RequestParam(value = "user_id") String user_id,
                           ModelMap model) {
        model.addAttribute("token", token);
        model.addAttribute("user_id", user_id);
        return "user";
    }
}
