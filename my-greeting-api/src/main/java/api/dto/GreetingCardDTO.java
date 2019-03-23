package api.dto;

import lombok.Data;

@Data
public class GreetingCardDTO {
    private String to;
    private String from;
    private GreetingCardContentDTO content;
}
