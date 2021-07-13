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
    public Sum getSum(@PathVariable String num1, @PathVariable String num2) {
        int n1 = 0, n2 = 0;
        try {
            n1 = Integer.parseInt(num1);
            n2 = Integer.parseInt(num2);
        } catch (NumberFormatException e) {
            log.error("Please enter an integer to calculate sum.", e);
        }
        return new Sum(Integer.sum(n1, n2));
    }
}
