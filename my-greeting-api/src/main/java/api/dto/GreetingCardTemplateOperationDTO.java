package api.dto;

import lombok.Data;

import java.util.List;

@Data
public class GreetingCardTemplateOperationDTO {

    private String to;
    private String from;
    private String name;
    private List<String> replaceTemplatePlaceHolders;
}
