package api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
public class GreetingCardTemplateOperationDTO {

    @NotEmpty private String to;
    @NotEmpty private String from;
    @NotEmpty private String name;
    @NotEmpty private List<String> replaceTemplatePlaceHolders;
}
