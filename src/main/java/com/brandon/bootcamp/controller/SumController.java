package com.brandon.bootcamp.controller;

import com.brandon.bootcamp.model.Sum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SumController {

    @GetMapping(value = {"/", "/{num1}", "/{num1}/{num2}"})
    public ResponseEntity<Object> getSum(@PathVariable(required = false) String num1, @PathVariable(required = false) String num2) {
        int n1 = 0, n2 = 0;
        try {
            if (num1 != null) {
                n1 = Integer.parseInt(num1);
            } else {
                return ResponseEntity.badRequest().body("Hello, world! Please provide two integer values to return a sum (e.g. /10/5)");
            }
            if (num2 != null) {
                n2 = Integer.parseInt(num2);
            }
        } catch (NumberFormatException e) {
            log.error("ERROR: Invalid input provided by user.", e);
            return ResponseEntity.badRequest().body("Please enter a valid integer to calculate sum (e.g. /10/5).");
        }
        return ResponseEntity.ok(new Sum(Integer.sum(n1, n2)));
    }

}
