package app.customstorage.library.mapper;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class PojoStateGenerator<Type> {

    public void generatePojoState(String key, Object value, Type type) {
        try {
            if (!(value instanceof List || value instanceof Map))
                value = getCorrectType((String) value);
            Field field = type.getClass().getDeclaredField(key);
            field.setAccessible(true);
            field.set(type, value);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getCorrectType(String value) {
        for (int i = 0; i < 4; i++) {
            try {
                return Integer.valueOf(value);
            } catch (Exception ignored) {
            }
            try {
                return Float.valueOf(value);
            } catch (Exception ignored) {
            }
            try {
                if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false"))
                    return value.equals("true");
            } catch (Exception ignored) {
            }
            try {
                return value.replace("\"", "");
            } catch (Exception ignored) {
            }
        }
        return value;
    }
}

