package com.zhangs.sbdemos.demo;

import com.zhangs.sbdemos.websocket.DemoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoCcontroller {
    @Autowired
    DemoHandler demoHandler;

    /**
     * session 测试
     *
     * @param request
     * @return
     */
    @RequestMapping("session")
    @ResponseBody
    public String session(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("session") + "###############");
        session.setAttribute("session", "bbbbbbbbbbbb");
        System.out.println(session.getMaxInactiveInterval() + ">>>>");
        return "sssssssssss";
    }

    @RequestMapping("hello")
    public ModelAndView aaa(ModelAndView modelAndView) {
        DemoHandler.users.forEach(u -> {
            try {
                if (u.isOpen()) {
                    u.sendMessage(new TextMessage("xxxxxxxxxxxxxxxx"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            h.sendMessageToUser(u.getId(), new TextMessage("xxxxxxxxxxxxxxxx"));
        });

        Map<String, Object> map = new HashMap<>();
        map.put("a", "zhagnsan");
        map.put("b", "lisi");
        modelAndView.setViewName("aaa");
        modelAndView.addObject("lists", map);
        return modelAndView;
    }

    @RequestMapping("/")
    public String bbb() {
        return "index";
    }

    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(1530924960000L);
        System.out.println(f.format(date));


    }
}
