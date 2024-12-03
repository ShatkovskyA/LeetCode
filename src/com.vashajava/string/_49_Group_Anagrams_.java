package com.vashajava.string;

import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.stream.ImageInputStream;

/**
 * _49_Group_Anagrams_.
 *
 * @author Anton Shatkovskiy
 * @created 28.11.2024 г.
 */

/*
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]
Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

ПЕРЕВОД: 49. Групповые анаграммы.
Получив массив строк strs, сгруппируйте анаграммы.
Вы можете вернуть ответ в любом порядке.

Пример 1:
Ввод: strs = ["есть", "чай", "загар", "ел", "нат", "летучая мышь"]
Выходные данные: [["летучая мышь"],["нат", "тан"],["ел", "кушать", "чай"]]
Объяснение:
В strs нет строки, которую можно было бы переставить в виде "bat".
Строки "nat" и "tan" являются анаграммами, поскольку их можно переставлять, чтобы они образовывали друг друга.
Строки "ate", "есть" и "tea" являются анаграммами, поскольку их можно переставлять, чтобы они образовывали друг друга.

Пример 2:
Ввод: strs = [""]
Вывод: [[""]]
Пример 3:
Ввод: strs = ["a"]
Вывод: [["a"]]

Ограничения:

1 <= строка.длина <= 104
0 <= строка[i].длина <= 100
строка[i] состоит из строчных английских букв.
 */
public class _49_Group_Anagrams_ {

  public static void main(String[] args) {

    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    Solution49 solution49 = new Solution49();
    List<List<String>> groupAnagrams = solution49.groupAnagrams(strs);
    System.out.println(groupAnagrams);

  }

  static class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
      // создаем карту для группировки анаграмм - т. е. куда будем все складывать,
      // где ключом является sortedstring, а значением - список исходных строк
      Map<String, List<String>> anagramsMap = new HashMap<>();
      // теперь выполняем итерацию по каждой строке в массиве, используя цикл
      for(String str : strs) {
        // тут преобразуем строку в массив символов и сортируем ее - т. е. создаем массив чаров,
        // где toCharArray() - преобразует строку в новый массив символов, это "заводской" библиотечный метод
        char[] charArray = str.toCharArray();
        // а тут уже сортируем также заводским методом
        Arrays.sort(charArray);

        // далее создаем новую строку из отсортированного массива символов
        // где valueOf() - "заводской" библиотечный метод, который возвращает строковое представление переданного аргумента
        String sortedStr = String.valueOf(charArray);

        // и далее, если отсортированный строковый ключ отсутствует в карте, инициализируем список
        // а затемс добавляем исходную строку в список, связанный с отсортированным строковым ключом
        // Общий смысл: если ключ sortedStr уже существует в anagramsMap, то метод computeIfAbsent возвращает соответствующий список,
        // и строка str добавляется в этот список.
        // Если же ключ sortedStr отсутствует в anagramsMap, то создается новый список ArrayList<>,
        // он добавляется в карту с ключом sortedStr, и затем строка str добавляется в этот новый список.

        /*
        1. computeIfAbsent:
Это метод из интерфейса Map, который выполняет вычисление значения, если ключ отсутствует в карте.
Если ключ sortedStr уже существует в anagramsMap, метод возвращает соответствующее значение.
Если ключ sortedStr отсутствует, метод вычисляет значение с помощью переданного лямбда-выражения key -> new ArrayList<>() и добавляет его в карту.

2. Лямбда-выражение key -> new ArrayList<>():
Это лямбда-выражение, которое вызывается, если ключ sortedStr отсутствует в anagramsMap.
Оно создает новый список ArrayList<> и возвращает его в качестве значения для ключа sortedStr.

3. add(str):
После того как метод computeIfAbsent вернул значение (либо существующий список, либо новый созданный список), вызывается метод add(str) на этом списке.
Метод add(str) добавляет строку str в список.
         */
        anagramsMap.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
      }
      // и тут возвращаем новый список, содержащий все значения из списков карты,
      // эффективно группируя все анаграммы вместе, где values() - это значения карты
      return new ArrayList<>(anagramsMap.values());
    }
  }
}

/*
Временная сложность кода в первую очередь определяется двумя операциями: операцией сортировки для каждой строки и вставкой в словарь.

Сортировка каждой строки: Предполагая, что средняя длина строк равна n и есть m строки для сортировки,
временная сложность сортировки каждой строки с использованием алгоритма TimSort (алгоритм сортировки в Python по умолчанию) равна O(n log n).
Поскольку нам нужно отсортировать m такие строки, общая временная сложность этой части составляет O(m * n log n).

Вставка в словарь: Вставка m строк в словарь требует времени, равного O(m) поскольку каждая операция вставки в словарь занимает O(1) в среднем.

Объединяя эти две, мы получаем общую временную сложность в виде O(m * n log n).
 */
