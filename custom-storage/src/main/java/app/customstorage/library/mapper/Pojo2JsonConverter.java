package app.customstorage.library.mapper;

import java.lang.reflect.Field;

//@Component
public class Pojo2JsonConverter<Type> {

    public String generateJson(Type type) {
        System.out.println(type);
        StringBuilder json = new StringBuilder("");
        if (type == null)
            return "";
        Field[] fields = type.getClass().getDeclaredFields();
        json.append("{");
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                String fieldType = formatFieldType(field.getType().getName());
                Object fieldValue = field.get(type);
                field.setAccessible(false);
//                System.out.println("fieldName: " + fieldName + "\nfieldType: " + fieldType + "\nfieldValue: " + fieldValue);
                json.append(makeJsonBody(fieldName, fieldType, fieldValue));
            }
            System.out.println(json.append("}"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String formatFieldType(String fieldType) {
        String[] fieldTypeSplit = fieldType.contains(".") ? fieldType.split("\\.") : new String[]{};
        return fieldTypeSplit.length > 0 ? fieldTypeSplit[fieldTypeSplit.length - 1] : fieldType;
    }

    public StringBuilder makeJsonBody(Object... args) {
        StringBuilder jsonBody = new StringBuilder();
        jsonBody.append("\n  \"" + args[0] + "\"");
        args[2] = !args[1].equals("String") ? args[2] : "\"" + args[2] + "\"";
        jsonBody.append(":  " + args[2] + ",");
        jsonBody.append("\n  \"type_" + args[0] + "\"");
        jsonBody.append(":  " + args[1] + ",\n");
        return jsonBody;
    }


}
