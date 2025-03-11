import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BracketChecker
{

    // Хранит пары скобок: ключ — закрывающая скобка, значение — открывающая
    private static Map<Character, Character> brackets = new HashMap<>();

    /** Загрузка конфигурации из JSON-файла */
    public static void loadConfig(String configFile) throws IOException
    {
        // Читаем содержимое файла в строку
        String content = new String(Files.readAllBytes(Paths.get(configFile)));
        JSONObject json = new JSONObject(content);
        JSONArray bracketArray = json.getJSONArray("bracket");

        // Парсим JSON и заполняем карту пар скобок
        for (int i = 0; i < bracketArray.length(); i++)
        {
            JSONObject bracket = bracketArray.getJSONObject(i);
            char left = bracket.getString("left").charAt(0);   // Открывающая скобка
            char right = bracket.getString("right").charAt(0); // Закрывающая скобка
            brackets.put(right, left);
        }
    }

    /** Чтение файла для проверки */
    public static String readFile(String filePath) throws IOException
    {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /** Проверка правильности расстановки скобок */
    public static boolean checkBrackets(String content)
    {
        // Множество открывающих скобок для быстрого поиска
        Set<Character> openBrackets = new HashSet<>(brackets.values());
        // Стек для отслеживания открывающих скобок
        Deque<Character> stack = new ArrayDeque<>();

        // Проходим по каждому символу в строке
        for (char ch : content.toCharArray())
        {
            if (openBrackets.contains(ch))
            {
                // Если символ — открывающая скобка, добавляем в стек
                stack.push(ch);
            } else if (brackets.containsKey(ch))
            {
                // Если символ — закрывающая скобка
                if (stack.isEmpty() || stack.pop() != brackets.get(ch))
                {
                    // Стек пуст или последняя открывающая скобка не соответствует — ошибка
                    return false;
                }
            }
        }
        // Скобки расставлены правильно, если стек пуст
        return stack.isEmpty();
    }
}
