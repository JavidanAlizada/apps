package app.customstorage.client.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User extends Object {

    private int id;
    private String username;
    private float weight;
    private List<Object> hobbies;
    private Map<String, Object> positionAndSalary;
    private boolean isActive;

}
