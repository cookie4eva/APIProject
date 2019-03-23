package greeting.service.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.log4j.Logger;

@Data
public class GreetingCardTemplate{

    private static final Logger log = Logger.getLogger(GreetingCardTemplate.class);
    private String name;
    private String template;


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof GreetingCardTemplate)) {
            log.debug("object is not of type GreetingCard");
            return false;
        }
        GreetingCardTemplate content = (GreetingCardTemplate) o;

        return StringUtils.equalsIgnoreCase(template,content.getTemplate()) &&
                StringUtils.equalsIgnoreCase(name,content.getName());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
                append(template).
                append(name).
                toHashCode();
    }
}
