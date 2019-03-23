package greeting.service;

import com.google.common.collect.Lists;
import greeting.service.entity.GreetingCard;
import greeting.service.entity.GreetingCardTemplate;
import greeting.service.entity.User;
import greeting.service.repository.CardsRepository;
import greeting.service.repository.TemplateRepository;
import greeting.service.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GreetingCardsService {

    private final TemplateRepository templateRepository;
    private final UsersRepository usersRepository;
    private final CardsRepository cardsRepository;


    public List<GreetingCardTemplate> getAllTemplates() {
        return templateRepository.getAll().entrySet().stream()
                .map(this::template)
                .collect(Collectors.toList());
    }

    public boolean addNewTemplate(GreetingCardTemplate template)
    {
        if(templateRepository.existsByName(template.getName())){
            return false;
        }
        return templateRepository.add(template.getName(),template.getTemplate());
    }


    private GreetingCardTemplate template(Map.Entry<String, String> e) {
        GreetingCardTemplate template = new GreetingCardTemplate();
        template.setName(e.getKey());
        template.setTemplate(e.getValue());
        return template;
    }

    public boolean addNewGreetingCard(GreetingCard greetingCard) {
        String user = greetingCard.getFrom();
        if(!usersRepository.exists(user))
        {
            usersRepository.add(user,new User());
            cardsRepository.put(user, Lists.newArrayList());
        }
        return cardsRepository.addByUser(user,greetingCard);
    }

    public List<GreetingCard> getAllCards() {
        ArrayList<GreetingCard> all = Lists.newArrayList();
        cardsRepository.getAll().values()
                .forEach(all::addAll);
        return all;
    }
}
