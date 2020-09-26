package at.ta.spring.api;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import at.ta.spring.modle.Greeting;
import at.ta.spring.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingControler {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {

        greetingRepository.save(greeting);
        model.addAttribute("greeting",greeting);
        return "result";
    }

    // test?id=1
    @GetMapping("/test")
    public Greeting testGreeting(@RequestParam(value = "id") Integer id) {
        Optional<Greeting> g = greetingRepository.findById(id);
        return g.get();
    }

    @PostMapping("/add")
    public String addGreeting(String content, String test) {

        return "added";
    }
}
