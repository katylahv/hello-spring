package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    // lives at hello/hello
    // handles request of form /hello?name=launchcode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
    public String helloWithQueryParam(@RequestParam String language, @RequestParam String name){
        return "<html>" +
                "<body>" +
                "<p style='color:Tomato;'>" +
                language +
                ", " +
                name +
                "! </p>" +
                "</body>" +
                "</html>";
    }

    // handles requests of the form /hello/launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){return "Hello, "+ name + "!";}
    // lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method ='post'>" + // submit a request to /hello
                "<input type='text' name='name' method ='post'>" +
                "<select name='language' method = 'post'>" +
                "<option value ='Hello'>English</option>" +
                "<option value ='Hola'>Spanish</option>" +
                "<option value ='Bonjour'>French</option>" +
                "<option value ='Ni Hao'>Mandarin</option>" +
                "<option value ='Konnichiwa'>Japanese</option>" +
                "</select>"+
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
