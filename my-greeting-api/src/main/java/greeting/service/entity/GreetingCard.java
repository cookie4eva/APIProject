package greeting.service.entity;

import greeting.controller.GreetingCardsController;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.log4j.Logger;


@Data
public class GreetingCard {
    private static final Logger log = Logger.getLogger(GreetingCard.class);
    private String to;
    private String from;
    private GreetingCardContent content;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof GreetingCard)) {
            log.debug("object is not of type GreetingCard");
            return false;
        }
        GreetingCard card = (GreetingCard) o;

        return StringUtils.equalsIgnoreCase(to,card.getTo()) &&
                StringUtils.equalsIgnoreCase(from,card.getFrom()) &&
                content.equals(card.getContent());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
                append(to).
                append(from).
                append(content).
                toHashCode();
    }
}
