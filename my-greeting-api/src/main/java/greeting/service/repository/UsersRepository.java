package greeting.service.repository;

import greeting.service.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsersRepository {

    private Map<String, User> users;

    public boolean exists(String user) {
        return users.containsKey(user);
    }

    public void add(String user, User userEntity) {
        users.put(user,userEntity);
    }
}
