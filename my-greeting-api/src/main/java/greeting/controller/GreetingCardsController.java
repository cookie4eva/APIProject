package greeting.controller;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingCardsController {

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDTO test()
    {
        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setHello("HELLO");
        return helloDTO;
    }

    @Data
    private class HelloDTO
    {
        private String hello;
    }


}
