package greeting.service.repository;

import com.google.common.collect.Lists;
import greeting.service.entity.GreetingCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CardsRepository{
    private Map<String, List<GreetingCard>> cards;

    public void put(String user, ArrayList<GreetingCard> compeleteList) {
        cards.put(user,compeleteList);
    }

    public boolean addByUser(String user, GreetingCard greetingCard) {
        if(!cards.containsKey(user))
        {
            cards.put(user, Lists.newArrayList());
        }
        return cards.get(user).add(greetingCard);
    }

    public Map<String, List<GreetingCard>> getAll() {
        return cards;
    }
}
