package greeting.service.repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import greeting.service.entity.GreetingCard;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CardsRepository{
    private static final Logger log = Logger.getLogger(CardsRepository.class);
    private Map<String, List<GreetingCard>> cards  = Maps.newHashMap();

    public void put(String user,List<GreetingCard> compeleteList) {
        cards.put(user,compeleteList);
    }

    public boolean addByUser(String user, GreetingCard greetingCard) {
        if(!cards.containsKey(user))
        {
            cards.put(user, Lists.newArrayList());
        }
        List<GreetingCard> greetingCards = cards.get(user);
        if(greetingCards.contains(greetingCard))
        {
            log.warn("Greeting card for this user already exists.");
            return false;
        }
        return greetingCards.add(greetingCard);
    }

    public Map<String, List<GreetingCard>> getAll() {
        return cards;
    }
}
