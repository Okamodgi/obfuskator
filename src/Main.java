import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import javax.tools.*;

public class Main {
    public String fileName = "C:\\Users\\nadak\\IdeaProjects\\Tart\\obfuskator\\src\\Kod.java";
    public String newClassName = "New";
    public String newFileName = "Kodik.java";

    public String constructorName = "NewConstructor";
    public Path sourceFile = Paths.get(fileName);
    public Path targetFile = Paths.get(newFileName);

    public static void main(String[] args) {

        try {
            String fileName = "C:\\Users\\nadak\\IdeaProjects\\Tart\\obfuskator\\src\\Kod.java";
            String newClassName = "New";
            String newFileName = "Kodik.java";
            compressCode(fileName, newFileName, newClassName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Задача 1: Сжать код за счет удаления лишних пробелов и символов перехода на новую строку
    public static void compressCode(String inputfile, String outputfile, String newClassName) throws IOException {
        try {
            // Чтение исходного файла
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            StringBuilder codeBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                codeBuilder.append(line).append(System.lineSeparator());
            }
            reader.close();

            // Удаление комментариев
            String codeWithoutComments = removeComments(codeBuilder.toString(),newClassName );

            // Запись кода без комментариев в новый файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile));
            writer.write(codeWithoutComments);
            writer.close();

            System.out.println("Комментарии успешно удалены. Код записан в файл: " + outputfile);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файлов: " + e.getMessage());
        }
    }
//удаление комментариев (задание2) + задание 3 (изменение имени класса)
    private static String removeComments(String code, String newClassName) {
        // Удаление однострочных комментариев
        code = code.replaceAll("//.*", "");
        code = code.replaceAll("class\\s+\\w+", "class " + newClassName);

        // Удаление многострочных комментариев
        Pattern pattern = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(code);
        code = matcher.replaceAll("");

        return code;
    }
//задание 4 - изменение идентификаторов
    private static String replaceIdentifiersWithShortNames(String code) {
        return code.replaceAll("\\b\\w+\\b", "a");
    }


}
