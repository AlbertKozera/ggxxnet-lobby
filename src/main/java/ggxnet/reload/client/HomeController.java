package ggxnet.reload.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @GetMapping(path = "/lobby")
    public String getLobby() {
        return "lobby";
    }

    @GetMapping(path = "/statistics")
    public String getStatistics() {
        return "statistics";
    }

    @GetMapping(path = "/options")
    public String getOptions() {
        return "options";
    }

    @GetMapping(path = "/about")
    public String getAbout() {
        return "about";
    }

}
