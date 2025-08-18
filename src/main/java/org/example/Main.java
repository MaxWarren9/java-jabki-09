package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 1. Создайте HashSet<String>, добавьте 5 слов и выведите все элементы
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Я");
        hashSet.add("пишу");
        hashSet.add("код");
        hashSet.add("на");
        hashSet.add("python");
        System.out.println(hashSet);

        // 2. Проверьте, содержится ли слово "java" в множестве
        System.out.println(hashSet.contains("java"));

        // 3. Удалите слово "python" из множества (если оно есть)
        hashSet.removeIf(s -> s.equals("python"));
        System.out.println(hashSet);

        // 4. Дан список строк с повторами. Добавьте их в HashSet и выведите количество уникальных слов
        String[] strings = new String[]{"Я", "программирую", "на", "java", "и", "программирую", "на", "python"};
        Set<String> stringsHashSet = new HashSet<>();
        Collections.addAll(stringsHashSet, strings);
        System.out.println(stringsHashSet.size());

        // 5. Создайте HashMap<String, Integer> с названиями предметов и оценками. Выведите все пары ключ-значение
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Math", 4);
        hashMap.put("English", 1);
        hashMap.put("History", 3);
        hashMap.put("Physics", 2);
        printHashMap(hashMap);

        // 6. Выведите значение по ключу "Math"
        System.out.println(hashMap.get("Math"));

        // 7. Проверьте, есть ли в мапе ключ "History"
        System.out.println(hashMap.containsKey("History"));

        // 8. Измените значение по ключу "English" на 5
        hashMap.replace("English", 5);
        printHashMap(hashMap);

        // 9. Удалите ключ "Physics" из мапы
        hashMap.remove("Physics");
        printHashMap(hashMap);

        // 10. Напишите метод areAnagrams(String a, String b), который возвращает true, если строки состоят из одинаковых символов (используйте Map<Character, Integer>).
        System.out.println(areAnagrams("пилалипка", "qипакилпа"));

        // 11. Напишите метод hasDuplicates(List<Integer> list) — возвращает true, если в списке есть дубликаты
        List<Integer> list = List.of(1, 2, 3, 4, 1);
        System.out.println(hasDuplicates(list));

        // 12. Дан Map<String, Integer> (имя студента → балл). Верните имя студента с максимальным баллом
        Map<String, Integer> studMap = new HashMap<>();
        studMap.put("Максим", 2);
        studMap.put("Василий", 3);
        studMap.put("Евгений", 5);
        studMap.put("Андрей", 4);
        System.out.println(getStudentWithMaxScore(studMap));

        // 13. Создайте Map<String, Set<String>> — ключ: слово, значение: набор синонимов. Реализуйте метод addSynonym(String word, String synonym)
        Map<String, Set<String>> synMap = new HashMap<>();

        Set<String> winter = new HashSet<>();
        winter.add("Холод");
        winter.add("Новый год");

        synMap.put("Зима", winter);
        System.out.println(synMap);

        addSynonym(synMap, "Лето", "Жара");
        addSynonym(synMap, "Зима", "Рождество");
        System.out.println(synMap);
    }

    public static void printHashMap(Map<?, Integer> hashMap) {
        for (Map.Entry<?, Integer> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("\n");
    }

    public static boolean areAnagrams(String a, String b) {

        if ("".equals(a) || "".equals(b)) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        char[] charsOfStringA = a.toLowerCase().toCharArray();
        char[] charsOfStringB = b.toLowerCase().toCharArray();

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        addCountLetters(charsOfStringA, mapA);
        addCountLetters(charsOfStringB, mapB);

        return mapA.equals(mapB);
    }

    public static void addCountLetters(char[] arr, Map<Character, Integer> map) {
        for (char a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
    }

    public static boolean hasDuplicates(List<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int n : list) {
            if (!hashSet.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static String getStudentWithMaxScore(Map<String, Integer> hashMap) {
        if (hashMap.isEmpty()) {
            return "Пустая мапа";
        }

        return hashMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    public static void addSynonym(Map<String, Set<String>> map, String word, String synonym) {
        if (!map.containsKey(word)) {
            map.computeIfAbsent(word, key -> new HashSet<>()).add(synonym);
        } else {
            map.get(word).add(synonym);
        }
    }
}

