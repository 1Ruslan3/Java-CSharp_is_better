import org.json.JSONException;

import java.io.IOException;


public class Main
{
    public static void main(String[] args)
    {

        try
        {
            // Загружаем конфигурацию и файл для проверки
            BracketChecker.loadConfig("C:\\Users\\user\\IdeaProjects\\Java_1\\src\\config.json");
            String content = BracketChecker.readFile("C:\\Users\\user\\IdeaProjects\\Java_1\\src\\input.txt");
            // Проверяем скобки и выводим результат
            boolean isCorrect = BracketChecker.checkBrackets(content);
            System.out.println(isCorrect ? "Скобки расставлены правильно" : "Скобки расставлены неправильно");
        } catch (IOException e)
        {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (JSONException e)
        {
            System.out.println("Ошибка парсинга JSON: " + e.getMessage());
        }
    }
}