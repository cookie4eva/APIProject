package greeting.controller;

import api.dto.*;
import greeting.service.GreetingCardsService;
import greeting.service.entity.GreetingCard;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class GreetingCardsController {

    private final GreetingCardsService service;
    private final GreetingCardsMapper mapper;

    @GetMapping(value = "greetingcard/catalog",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AllGCTemplatesDTO getAllTemplates()
    {
        AllGCTemplatesDTO all = new AllGCTemplatesDTO();
        all.setTemplates(service.getAllTemplates().stream()
                        .map(mapper::toTemplateDto)
                        .collect(Collectors.toList()));
        return all;
    }

    @GetMapping(value = "greetingcard/cards",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AllCardsDTO getAllCards()
    {
        AllCardsDTO all = new AllCardsDTO();
        all.setGreetingCardDTOList(service.getAllCards().stream()
                .map(mapper::toGreetingCardDto)
                .collect(Collectors.toList()));
        return all;
    }

    @PutMapping(value = "greetingcard/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GreetingCardTemplateDTO addNewTemplate(@RequestBody GreetingCardTemplateDTO templateDTO,
                                                  @PathVariable String name) {
        if(!service.addNewTemplate(mapper.fromTemplateDTO(templateDTO,name))) {
            throw new GreetingException("Error adding new template");
        }
        templateDTO.setName(name);
        return templateDTO;
    }

    @PostMapping(value = "greetingcard/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public GreetingCardDTO addNewGreetingCard(@RequestBody GreetingCardTemplateOperationDTO opDTO) {
        Optional<GreetingCard> greetingCard = service.addNewGreetingCard(mapper.fromOpertaionDTO(opDTO));
        if(!greetingCard.isPresent()){
            throw new GreetingException("Error adding new greeting card");
        }
        return mapper.toGreetingCardDto(greetingCard.get());
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception e)
    {
        System.err.println("got exception");
        e.printStackTrace();
    }




}
