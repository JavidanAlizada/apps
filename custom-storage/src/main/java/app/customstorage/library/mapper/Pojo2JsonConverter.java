package app.customstorage.library.mapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pojo2JsonConverter<Type> {

    public String generateJson(Type type) {
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
                fieldValue = fieldType.equals("List") ? makeListBodyInJson((ArrayList<Object>) fieldValue) : fieldValue;
                fieldValue = fieldType.equals("Map") ? makeMapBodyInJson((Map<String, Object>) fieldValue) : fieldValue;
                field.setAccessible(false);
                json.append(makeJsonBody(fieldName, fieldType, fieldValue));

            }
            json.replace(json.length() - 1, json.length(), "");
            return json.append("\n}").toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String formatFieldType(String fieldType) {
        String[] fieldTypeSplit = fieldType.split("\\.");
        return fieldTypeSplit[fieldTypeSplit.length - 1];
    }

    public StringBuilder makeJsonBody(Object... args) {
        StringBuilder jsonBody = new StringBuilder();
        jsonBody.append("\n  \"" + args[0] + "\"");
        args[2] = !args[1].equals("String") ? args[2] : "\"" + args[2] + "\"";
        jsonBody.append(":  " + args[2] + ",");
        jsonBody.append("\n  \"type_" + args[0] + "\"");
        jsonBody.append(": \"" + args[1] + "\",");
        return jsonBody;
    }

    private List<Object> makeListBodyInJson(ArrayList<Object> listValue) {
        List<Object> list = new ArrayList<>();
        for (Object o : listValue) {
            if (o instanceof String) {
                list.add("\"" + o + "\"");
            } else
                list.add(o);
        }
        return list;
    }

    private String makeMapBodyInJson(Map<String, Object> mapValue) {
        StringBuilder resultMap = new StringBuilder();
        resultMap.append("{");
        for (Map.Entry<String, Object> mapVal : mapValue.entrySet()) {
            resultMap.append("\n\t\"" + mapVal.getKey() + "\":  ");
            if (mapVal.getValue() instanceof String)
                resultMap.append("\"" + mapVal.getValue() + "\",");
            else
                resultMap.append("" + mapVal.getValue() + ",");
        }
        resultMap.replace(resultMap.length() - 1, resultMap.length(), "");
        resultMap.append("\n  }");
        return resultMap.toString();
    }


}
