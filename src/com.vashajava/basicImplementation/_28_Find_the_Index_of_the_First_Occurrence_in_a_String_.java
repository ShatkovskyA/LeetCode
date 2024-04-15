package basicImplementation;

/**
 * basicImplementation._28_Find_the_Index_of_the_First_Occurrence_in_a_String_.
 *
 * @author Anton Shatkovskiy
 * @created 06.04.2024 г.
 */

/*

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

ПЕРЕВОД:

При наличии двух строк needle и haystack верните индекс первого появления needle в haystack или -1, если needle не является частью haystack.

Пример 1:

Ввод: haystack = "sadbutsad", needle = "грустный".
Вывод: 0
Пояснение: "sad" встречается в индексах 0 и 6.
Первое вхождение имеет индекс 0, поэтому мы возвращаем 0.

Пример 2:

Входные данные: стог сена = "leetcode", игла = "leeto"
Выходные данные: -1
Пояснение: "leeto" не встречается в "leetcode", поэтому мы возвращаем значение -1.

Ограничения:

1 <= стог сена.длина, игла.длина <= 104
стог сена и игла состоят только из английских символов нижнего регистра.

 */

public class _28_Find_the_Index_of_the_First_Occurrence_in_a_String_ {

  public static void main(String[] args) {

    String haystack = "leetcode";
    String needle = "leeto";

    Solution28 solution28 = new Solution28();
    System.out.println(solution28.strStr(haystack, needle));

  }

  static class Solution28 {

    public int strStr(String haystack, String needle) {

      // решение прошло, indexOf является стандартным подходом к поиску подстрок, а метод indexOf() доступен практически во всех языках программирования.
      return haystack.indexOf(needle);

    }
  }
}
