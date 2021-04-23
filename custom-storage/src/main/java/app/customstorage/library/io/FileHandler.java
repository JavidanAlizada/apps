package app.customstorage.library.io;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public interface FileHandler<Type> {

    Map<String, ?> readFile(File file);

    boolean writeFile(String fileName, Type type);

    boolean isFileExist();

    boolean deleteFile();

    boolean isFileEmpty();

    default void writer(String content, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            System.out.println(content);
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
