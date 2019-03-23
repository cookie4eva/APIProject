package api.dto;

import lombok.Data;

import java.util.List;

@Data
public class GreetingCardContentDTO {
    private GreetingCardTemplateDTO template;
    private List<String> replaceTemplatePlaceHolders;
}
