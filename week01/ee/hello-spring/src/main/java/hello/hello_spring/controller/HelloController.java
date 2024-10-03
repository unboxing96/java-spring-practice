package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // url
    public String hello(Model model) {
        model.addAttribute("data", "hello!"); // key: "data", value: "hello!"
        return "hello";  // resources/templates/hello.html 렌더링
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http Body부에 내용을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name) {
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
