package app.customstorage.library.mapper;

import java.lang.reflect.Field;

import java.util.Map;


public class Map2PojoConverter<Type> {

    public Type convertMapToPojo(Map<String, Object> obj, Type type) {
        try {
            Field[] fields = type.getClass().getDeclaredFields();
            if (fields.length != obj.values().size())
                return null;
            int i = 0;
            for (Object val : obj.values()) {
                fields[i].setAccessible(true);
                fields[i].set(type, val);
                fields[i].setAccessible(false);
                ++i;
            }
            return type;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
