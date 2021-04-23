package app.customstorage;

import app.customstorage.client.entity.User;
import app.customstorage.library.io.types.JSONFileHandler;
import app.customstorage.library.mapper.Pojo2JsonConverter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        Map2PojoConverter<User> mapper = new Map2PojoConverter<>();
//        Map<String, Object> map = new LinkedHashMap<>();
//        List<String> hobbies = new ArrayList<>();
//        hobbies.add("Reading");
//        hobbies.add("Writing");
//        map.put("id", 1);
//        map.put("username", "A");
//        map.put("password", "AAB");
//        map.put("hobbies", hobbies);
//        User user = mapper.convertMapToPojo(map, new User());
//        System.out.println(user);
        User user = new User();
        user.setId(1);
        user.setUsername("Javidan");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Writing");
        user.setHobbies(hobbies);
        user.setActive(true);
        user.setWeight(78.23f);
        Map<String, String> keyv = new LinkedHashMap<>();
        keyv.put("aa", "bb");
        keyv.put("11", "cv3f2d");
        keyv.put("cesc", "cn3hu2bu");
        user.setPositionAndSalary(keyv);
        Pojo2JsonConverter<User> converter = new Pojo2JsonConverter<>();
//        converter.generateJson(user);
        JSONFileHandler<User> fileHandler = new JSONFileHandler<>(converter);
        fileHandler.writeFile("person1.json", user);

    }
}
