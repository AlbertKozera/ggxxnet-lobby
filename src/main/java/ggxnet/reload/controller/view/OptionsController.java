package ggxnet.reload.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/options")
public class OptionsController {
  @GetMapping
  public String getOptions(Model model) {
    model.addAttribute("title", PageTitle.OPTIONS);
    return "options";
  }
}
