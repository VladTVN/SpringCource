package ru.tvn.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tvn.springcourse.services.PeopleService;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {
    private final PeopleService peopleService;

    public BatchController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public String index(){
        return "batch/index";
    }



}
