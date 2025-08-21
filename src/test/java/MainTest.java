import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainTest {

    @Test
    public void areAnagramsTest() {
        Assertions.assertTrue(Main.areAnagrams("Один", "один"));
        Assertions.assertFalse(Main.areAnagrams("Один", "два"));
        Assertions.assertFalse(Main.areAnagrams("Один", "пять"));
        Assertions.assertFalse(Main.areAnagrams("", "пять"));
    }

    @Test
    public void addCountLettersTest() {
        char[] ar = {'a', 'd', 'a'};
        Map<Character, Integer> map = new HashMap<>();
        Main.addCountLetters(ar, map);
        Assertions.assertTrue(map.containsKey('a'));
        Assertions.assertTrue(map.containsKey('d'));
        Assertions.assertEquals(1, map.get('d'));
        Assertions.assertEquals(2, map.get('a'));
    }

    @Test
    public void hasDuplicatesTest() {
        List<Integer> list = List.of(1, 2, 3, 3);
        Assertions.assertTrue(Main.hasDuplicates(list));

        List<Integer> list2 = List.of(1, 2, 3);
        Assertions.assertFalse(Main.hasDuplicates(list2));

        List<Integer> list3 = new ArrayList<>();
        Assertions.assertFalse(Main.hasDuplicates(list3));
    }

    @Test
    public void getStudentWithMaxScoreTest() {
        Map<String, Integer> studMap = new HashMap<>();
        studMap.put("Максим", 2);
        studMap.put("Василий", 3);
        studMap.put("Евгений", 5);
        studMap.put("Андрей", 4);
        Assertions.assertEquals("Евгений" ,Main.getStudentWithMaxScore(studMap));
        studMap.put("Евгений", 4);
        Assertions.assertTrue(Main.getStudentWithMaxScore(studMap).equals("Евгений")|| Main.getStudentWithMaxScore(studMap).equals("Андрей"));
    }

    @Test
    public void addSynonymTest() {
        Map<String, Set<String>> map = new HashMap<>();

        Main.addSynonym(map, "Холод", "Зима");
        Assertions.assertTrue(map.containsKey("Холод"));
        Assertions.assertEquals(1, map.get("Холод").size());
        Assertions.assertTrue(map.get("Холод").contains("Зима"));

        Main.addSynonym(map, "Холод", "Зима");
        Assertions.assertEquals(1, map.get("Холод").size());

        Main.addSynonym(map, "Холод", "Мороз");
        Assertions.assertEquals(2, map.get("Холод").size());
        Assertions.assertTrue(map.get("Холод").contains("Зима"));
        Assertions.assertTrue(map.get("Холод").contains("Мороз"));
    }
}
