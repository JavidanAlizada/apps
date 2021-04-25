package app.customstorage.library.io.types;

import app.customstorage.library.io.FileHandler;
import app.customstorage.library.io.FileType;
import app.customstorage.library.mapper.File2PojoConverter;
import app.customstorage.library.mapper.Pojo2JsonConverter;

import java.io.File;

public class JSONFileHandler<Type> implements FileHandler<Type> {
    private final Pojo2JsonConverter<Type> jsonConverter;
    private final File2PojoConverter<Type> pojoConverter;

    public JSONFileHandler() {
        this.jsonConverter = new Pojo2JsonConverter<>();
        this.pojoConverter = new File2PojoConverter<>();
    }

    @Override
    public Type readFile(String fileName, Type type) {
        try {
            String content = reader(fileName);
            return pojoConverter.convertFileContent2Pojo(content, FileType.JSON, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean writeFile(Type type) {
        boolean isFileReady = false;
        try {
            String content = jsonConverter.generateJson(type);
            String fileName = getGeneratedFileName(type) + ".json";
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
