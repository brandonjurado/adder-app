package com.brandon.bootcamp.controller;

import com.brandon.bootcamp.model.Sum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SumController {

    @GetMapping(value = "/{num1}/{num2}")
    public Sum getSum(@PathVariable int num1, @PathVariable int num2) {
        int sum = num1 + num2;
        return new Sum(sum);
    }

}
