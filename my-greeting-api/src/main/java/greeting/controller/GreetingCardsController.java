package greeting.controller;

import api.dto.*;
import greeting.service.GreetingCardsService;
import greeting.service.entity.GreetingCard;
import greeting.service.entity.GreetingCardTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class GreetingCardsController {

    private static final Logger log = Logger.getLogger(GreetingCardsController.class);
    private final GreetingCardsService service;
    private final GreetingCardsMapper mapper;

    @GetMapping(value = "greetingcard/catalog",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AllGCTemplatesDTO> getAllTemplates()
    {
        AllGCTemplatesDTO all = new AllGCTemplatesDTO();
        all.setTemplates(service.getAllTemplates().stream()
                        .map(mapper::toTemplateDto)
                        .collect(Collectors.toList()));
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "greetingcard/cards",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AllCardsDTO> getAllCards()
    {
        AllCardsDTO all = new AllCardsDTO();
        all.setGreetingCardDTOList(service.getAllCards().stream()
                .map(mapper::toGreetingCardDto)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(all);
    }

    @PutMapping(value = "greetingcard/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingCardTemplateDTO> addNewTemplate( @Valid @RequestBody GreetingCardTemplateDTO templateDTO,
                                                                  @PathVariable String name) {
        Optional<GreetingCardTemplate> cardTemplate = service.addNewTemplate(mapper.fromTemplateDTO(templateDTO, name));
        if(!cardTemplate.isPresent()) {
            String warn = "Error adding new template";
            log.warn(warn);
            GreetingCardTemplateDTO warnDTO = new GreetingCardTemplateDTO();
            warnDTO.setName(warn);
            return ResponseEntity.badRequest().body(warnDTO);
        }
        templateDTO.setName(name);
        return ResponseEntity.ok(templateDTO);
    }

    @PostMapping(value = "greetingcard/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingCardDTO> addNewGreetingCard(@Valid @RequestBody GreetingCardTemplateOperationDTO opDTO) {
        Optional<GreetingCard> greetingCard = service.addNewGreetingCard(mapper.fromOpertaionDTO(opDTO));
        if(!greetingCard.isPresent()){
            String warn = "Error adding new greeting card";
            log.warn(warn);
            GreetingCardDTO warnDTO = new GreetingCardDTO();
            warnDTO.setTo(warn);
            return ResponseEntity.badRequest().body(warnDTO);
        }
        return ResponseEntity.ok(mapper.toGreetingCardDto(greetingCard.get()));
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception e)
    {
        log.error("Got exception",e);
    }




}
