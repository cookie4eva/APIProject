package greeting.service.repository;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class TemplateRepository{

    private Map<String, String> templates = Maps.newHashMap();

    @PostConstruct
    public void initSomeTemplates(){
        templates.put("Happy BirthDay","Happy BirthDay,\n I wish you {} for many years.\nxoxo");
        templates.put("Congratulations","Congratulations,\n I've heard that you {}.\nHope for the best.");
    }


    public Map<String,String> getAll() {
        return templates;
    }

    public boolean existsByName(String name)
    {
        return templates.containsKey(name);
    }

    public boolean add(String name, String template) {
        return templates.put(name,template) == null;
    }
}
