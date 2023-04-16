package com.brandon.bootcamp.controller

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@Subject(SumController)
class SumControllerTest extends Specification {

    MockMvc mockMvc

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new SumController()).build()
    }

    @Unroll
    def "should return sum of #num1 and #num2"() {
        given:
        def expectedSum = num1 + num2

        when:
        def response = mockMvc.perform(get("/" + num1 + "/" + num2))

        then:
        response.andExpect(status().isOk())
        response.andExpect(jsonPath('$.sum').value(expectedSum))

        where:
        num1 | num2
        10   | 20
        30   | 40
        50   | 60
    }

    def "should handle non-integer input values"() {
        when:
        def response = mockMvc.perform(get("/abc/def"))

        then:
        response.andExpect(status().isBadRequest())
    }
}
