package org.ncedu.controller;

import org.ncedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 *
 */
@Controller
public class MainController {

    private static final String OAUTH_URL = "https://oauth.vk.com/authorize";
    private static final String CLIENT_ID = "client_id=5691009";
    private static final String REDIRECT_URI = "redirect_uri=http://localhost:8080/VKMusicListener/oauth2";
    private static final String SCOPE = "scope=65544";
    private static final String RESPONCE_TYPE = "response_type=token&v=5.60";
    private static final String VERSION_API = "v=5.60";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public String vkoAuth(ModelMap model) {
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

    @RequestMapping(value = "user")
    public String getUser (@RequestParam(value = "access_token") String token,
                           @RequestParam(value = "user_id") String user_id,
                           ModelMap model) {
        model.addAttribute("token", token);
        model.addAttribute("user_id", user_id);
        return "user";
    }

    @RequestMapping(value = "mp3")
    public HttpServletResponse mp3 (HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        File mp3 = new File("/Users/nick/rooms/VKMusicListener/t.mp3");
        FileInputStream fis = new FileInputStream(mp3);
        response.setContentType("audio/mpeg");
        //response.setContentLength((int) mp3.length());
        OutputStream os = response.getOutputStream();
        byte[] buf = new byte[1024];
        int len;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        os.close();
        return response;
    }

    @RequestMapping(value = "hello")
    public String hello (ModelMap model) {
        return "home";
    }
}
