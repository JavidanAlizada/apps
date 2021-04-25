package app.customstorage;

import app.customstorage.client.entity.User;
import app.customstorage.library.io.types.JSONFileHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        long a =  System.currentTimeMillis();
        User user = createUser();
        JSONFileHandler<User> fileHandler = new JSONFileHandler<>();
//        Pojo2JSON
        fileHandler.writeFile(user);
//        File2POJO
        System.out.println(System.currentTimeMillis() - a);
        long b =  System.currentTimeMillis();
        User userRead = fileHandler.readFile("user_1.json", new User());
        System.out.println(System.currentTimeMillis() - b);
    }

    private static User createUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("Ja\tvidan");
        List<Object> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Writing");
        hobbies.add(1);
        hobbies.add(true);
        user.setHobbies(hobbies);
        user.setWeight(78.23f);
        Map<String, Object> keyv = new LinkedHashMap<>();
        keyv.put("isTrue", true);
        keyv.put("number", 100);
        keyv.put("ad", "alizada");
        user.setPositionAndSalary(keyv);
        user.setActive(false);
        return user;
    }
}
