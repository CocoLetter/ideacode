package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class Hello {
    @RequestMapping("/msgpage")
    public String indexMethod(Model model){
        return "msgpage";
    }
}
