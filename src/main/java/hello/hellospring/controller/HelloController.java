package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello!!";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value ="name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
    // ResponseBody : http의 바디부에 이 데이터를 직접 넣어주겠다. (화면이 없어도 리턴 데이터가 그대로 출력됨 ㄷㄷ )
}
