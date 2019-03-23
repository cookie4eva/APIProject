package api.dto;

import lombok.Data;

import java.util.List;

@Data
public class AllGCTemplatesDTO {
    private List<GreetingCardTemplateDTO> templates;
}
