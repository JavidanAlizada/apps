package app.customstorage.library.io;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface FileHandler<Type> {

    Type readFile(String fileName, Type type);

    boolean writeFile(Type type);

    boolean isFileExist();

    boolean deleteFile();

    boolean isFileEmpty();

    default void writer(String content, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default String reader(String fileName) {
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    default String getGeneratedFileName(Type type) throws NoSuchFieldException, IllegalAccessException {
        Field field = type.getClass().getDeclaredField("id");
        field.setAccessible(true);
        String fileName = type.getClass().getSimpleName().toLowerCase() + "_" + field.get(type);
        field.setAccessible(false);
        return fileName;
    }
}
