package app.customstorage.library.mapper;

import app.customstorage.library.io.FileType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class File2PojoConverter<Type> {
    private static final String JSON_SQUARE_BRACKET_PATTERN = "\\[(.*?)\\]";
    private static final String JSON_CURLY_BRACES_PATTERN = "\\{([^}]+)}";

    private final PojoStateGenerator<Type> pojoStateGenerator;

    public File2PojoConverter() {
        this.pojoStateGenerator = new PojoStateGenerator<>();
    }

    public Type convertFileContent2Pojo(String content, FileType fileType, Type type) {
        switch (fileType) {
            case JSON:
                return parseJsonStructure(content, type);
            case XML:
                return parseXmlStructure(content, type);
            case TXT:
                return parseTextStructure(content, type);
            case CSV:
                return parseCsvStructure(content, type);
        }
        return null;
    }

    private Type parseJsonStructure(String content, Type type) {
        content = content.substring(1, content.length() - 1);
        int i = 0;
        int j = 0;
        Pattern patternList = Pattern.compile(JSON_SQUARE_BRACKET_PATTERN);
        Matcher matcherList = patternList.matcher(content);
        Pattern patternMap = Pattern.compile(JSON_CURLY_BRACES_PATTERN);
        Matcher matcherMap = patternMap.matcher(content);
        String list = "";
        String map = "";
        if (matcherList.find()) {
            list = matcherList.group();
            content = content.replace(list, "list");
        }
        if (matcherMap.find()) {
            map = matcherMap.group();
            content = content.replace(map, "map");
        }
        content = content.replace(" ", "").trim();
        for (String byComma : content.split(",")) {
            String[] splittedByComma = byComma.split(":");
            for (int k = 1; k < splittedByComma.length; k++) {
                String byColon = splittedByComma[k];
                String formattedKey = splittedByComma[0].replace("\"", "").trim();
                Object formatValue = splittedByComma[1];
                if (byColon.equals("list"))
                    pojoStateGenerator.generatePojoState(formattedKey, parseJsonStructureListType(list), type);
                else if (byColon.equals("map")) {
                    pojoStateGenerator.generatePojoState(formattedKey, parseJsonStructureMapType(map), type);
                } else {
                    pojoStateGenerator.generatePojoState(formattedKey, formatValue, type);
                }
            }
        }
        return type;
    }

    private Type parseXmlStructure(String content, Type type) {
        return null;
    }

    private Type parseTextStructure(String content, Type type) {
        return null;
    }

    private Type parseCsvStructure(String content, Type type) {
        return null;
    }

    private List<Object> parseJsonStructureListType(String listStr) {
        List<Object> list1 = new ArrayList<>();
        listStr = listStr.substring(1, listStr.length() - 1);
        for (String byComma : listStr.split(",")) {
            list1.add(byComma.trim());
        }
        return list1;
    }

    private Map<String, Object> parseJsonStructureMapType(String mapStr) {
        mapStr = mapStr.substring(1, mapStr.length() - 1).trim();
        Map<String, Object> map = new HashMap<>();
        for (String byComma : mapStr.split(",")) {
            String[] splittedByComma = byComma.split(":");
            for (int k = 0; k < splittedByComma.length; k++) {
                String key = splittedByComma[0].replace("\"", "").trim();
                map.put(key, splittedByComma[1].trim());
            }
        }
        return map;
    }


}
