package greeting.service.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;

@Data
public class GreetingCardContent {
    private static final Logger log = Logger.getLogger(GreetingCardContent.class);

    private GreetingCardTemplate template;
    private List<String> replaceTemplatePlaceHolders;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof GreetingCardContent)) {
            log.debug("object is not of type GreetingCard");
            return false;
        }
        GreetingCardContent content = (GreetingCardContent) o;

        return template.equals(content.getTemplate()) &&
                new HashSet<>(replaceTemplatePlaceHolders).equals(new HashSet<>(content.getReplaceTemplatePlaceHolders()));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).
                append(template).
                append(replaceTemplatePlaceHolders).
                toHashCode();
    }
}
