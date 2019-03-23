package greeting.service.entity;

import lombok.Data;


@Data
public class GreetingCard {
    private String to;
    private String from;
    private GreetingCardContent content;
}
