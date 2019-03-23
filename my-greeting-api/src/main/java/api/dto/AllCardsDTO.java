package api.dto;

import lombok.Data;

import java.util.List;

@Data
public class AllCardsDTO {
    private List<GreetingCardDTO> greetingCardDTOList;
}
