package greeting.service.entity;

import lombok.Data;

import java.util.List;

@Data
public class GreetingCardContent {
    private GreetingCardTemplate template;
    private List<String> replaceTemplatePlaceHolders;
}
