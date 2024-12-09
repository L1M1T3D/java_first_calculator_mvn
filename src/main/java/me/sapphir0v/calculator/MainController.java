package me.sapphir0v.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping
    public String greeting() {
        return mainService.greeting();
    }

    @GetMapping(path="/{operation}")
    public String calculate(@PathVariable String operation, @RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Для вычисления нужны два числа.";
        }
        try {
            return mainService.calculate(operation, num1, num2);
        } catch (IllegalArgumentException e) {
            return "Ошибка: " + e.getMessage();
        }
    }
}
