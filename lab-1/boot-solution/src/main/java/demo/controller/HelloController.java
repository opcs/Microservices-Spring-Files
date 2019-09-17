package demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

	@GetMapping("/{name}")
	public String hi(Map model, @PathVariable String name) {
		model.put("name", name);
		return "hello";             // logical View name -> matching with hello.html
	}
}
