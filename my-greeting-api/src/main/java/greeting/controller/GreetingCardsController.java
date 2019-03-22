package greeting.controller;

import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingCardsController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public HelloDTO test()
    {
        HelloDTO helloDTO = new HelloDTO();
        helloDTO.setHello("HELLO");
        return helloDTO;
    }

    @Data
    public class HelloDTO
    {
        private String hello;
    }


}
