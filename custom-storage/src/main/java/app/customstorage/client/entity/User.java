package app.customstorage.client.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class User extends Object {

    private int id;
    private String username;
    private float weight;
    private boolean isActive;
    private List<String> hobbies;
    private Map<String, String> positionAndSalary;
}
