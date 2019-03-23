package greeting.service;

import greeting.service.entity.GreetingCard;
import lombok.Data;

import java.util.List;

@Data
public class UserGreetingCards {
    private String user;
    private List<GreetingCard> greetingCard;
}
