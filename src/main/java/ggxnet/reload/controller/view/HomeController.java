package ggxnet.reload.controller.view;

import ggxnet.reload.service.dto.RGBa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ObjectInputStream;
import java.util.List;

@Controller
public class HomeController {
  @GetMapping
  public String getStartPage(Model model) throws Exception {
    model.addAttribute("title", PageTitle.DEFAULT);
    return "index";
  }

  @ResponseBody
  @GetMapping("/sprites")
  public List<RGBa> getImage() throws Exception {
    List<RGBa> sprite = readImageData("/static/dizzy_rgb_168_272.bin");
    return sprite;
  }



  public static List<RGBa> readImageData(String filename) throws Exception {
    var in = new ObjectInputStream(HomeController.class.getResourceAsStream(filename));
    return (List<RGBa>) in.readObject();
  }


}
