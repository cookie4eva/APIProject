package api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;


@Data
public class GreetingCardTemplateDTO {

     private String name;
    @NotEmpty private String template;
}
