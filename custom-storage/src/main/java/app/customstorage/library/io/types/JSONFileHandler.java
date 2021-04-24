package app.customstorage.library.io.types;

import app.customstorage.library.io.FileHandler;
import app.customstorage.library.mapper.Pojo2JsonConverter;

import java.io.File;
import java.util.Map;

public class JSONFileHandler<Type> implements FileHandler<Type> {

    //    @Autowired
    private Pojo2JsonConverter<Type> jsonConverter;

    public JSONFileHandler(Pojo2JsonConverter<Type> jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override
    public Map<String, Object> readFile(File file) {
        return null;
    }

    @Override
    public boolean writeFile(String fileName, Type type) {
        boolean isFileReady = false;
        try {
            String content = jsonConverter.generateJson(type);
            System.out.println(content);
            writer(content, fileName);
            File file = new File(fileName);
            isFileReady = file.length() != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFileReady;
    }

    @Override
    public boolean isFileExist() {
        return false;
    }

    @Override
    public boolean deleteFile() {
        return false;
    }

    @Override
    public boolean isFileEmpty() {
        return false;
    }
}
