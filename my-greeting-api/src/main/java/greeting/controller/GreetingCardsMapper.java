package greeting.controller;

import api.dto.GreetingCardContentDTO;
import api.dto.GreetingCardDTO;
import api.dto.GreetingCardTemplateDTO;
import api.dto.GreetingCardTemplateOperationDTO;
import greeting.service.entity.GreetingCard;
import greeting.service.entity.GreetingCardContent;
import greeting.service.entity.GreetingCardTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingCardsMapper {

    public GreetingCardTemplate fromTemplateDTO(GreetingCardTemplateDTO templateDTO, String name) {
        GreetingCardTemplate template = new GreetingCardTemplate();
        template.setTemplate(templateDTO.getTemplate());
        template.setName(name);
        return template;
    }

    public GreetingCard fromOpertaionDTO(GreetingCardTemplateOperationDTO opDTO) {
        GreetingCard card = new GreetingCard();
        card.setContent(createContent(opDTO.getReplaceTemplatePlaceHolders(),opDTO.getName()));
        card.setFrom(opDTO.getFrom());
        card.setTo(opDTO.getTo());
        return card;
    }

    private GreetingCardContent createContent(List<String> replacements, String name) {
        GreetingCardContent content = new GreetingCardContent();
        content.setReplaceTemplatePlaceHolders(replacements);
        GreetingCardTemplate template = new GreetingCardTemplate();
        template.setName(name);
        content.setTemplate(template);
        return content;
    }


    public GreetingCardTemplateDTO toTemplateDto(GreetingCardTemplate t) {
        GreetingCardTemplateDTO dto = new GreetingCardTemplateDTO();
        dto.setTemplate(t.getTemplate());
        dto.setName(t.getName());
        return dto;
    }

    public GreetingCardDTO toGreetingCardDto(GreetingCard card) {
        GreetingCardDTO dto= new GreetingCardDTO();
        dto.setContent(createContentDTO(card.getContent()));
        dto.setFrom(card.getFrom());
        dto.setTo(card.getTo());
        return dto;
    }

    private GreetingCardContentDTO createContentDTO(GreetingCardContent content) {
        GreetingCardContentDTO dto = new GreetingCardContentDTO();
        dto.setReplaceTemplatePlaceHolders(content.getReplaceTemplatePlaceHolders());
        dto.setTemplate(toTemplateDto(content.getTemplate()));
        return dto;
    }
}
