package basicImplementation;

/**
 * Класс basicImplementation._1768_Merge_Strings_Alternately_ - реализовывает решение задачи № 768.
 *
 * @author Anton Shatkovskiy
 * @created 05.04.2024 г.
 */

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.

ПЕРЕВОД:

У вас есть две строки word1 и word2. Объедините строки,
добавляя буквы в чередующемся порядке, начиная со слова1.
Если одна строка длиннее другой, добавьте дополнительные буквы в конец объединенной строки.

Верните объединенную строку.

 ример 1:

Ввод: word1 = "abc", word2 = "pqr"
Вывод: "apbqcr"
Пояснение: Объединенная строка будет объединена следующим образом:
слово 1: a b c
слово 2: p q r
объединено: a p b q c r
Пример 2:

Ввод: word1 = "ab", word2 = "pqrs"
Вывод: "apbqrs"
Пояснение: Обратите внимание, что, поскольку word2 длиннее, в конце добавляется "rs".
слово 1: a b
слово 2: p q r s
объединено: a p b q r s
Пример 3:

Входные данные: word1 = "abcd", word2 = "pq"
Выходные данные: "apbqcd"
Пояснение: Обратите внимание, что, поскольку слово 1 длиннее, в конце добавляется "cd".
слово 1: a b c d
слово 2: p q
объединено: a p b q c d

Ограничения:

1 <= word1.length, word2.length <= 100
, word1 и word2 состоят из строчных английских букв.
*/

public class _1768_Merge_Strings_Alternately_ {

  public static void main(String[] args) {

    String word1 = "abc";
    String word2 = "pqr";

    Solution1768 solution1768 = new Solution1768();
    System.out.println(solution1768.mergeAlternately(word1, word2));

  }

  static class Solution1768 {


    public String mergeAlternately(String word1, String word2) {

      // исп. StringBuilder - создаем объект типа StringBuilder
      StringBuilder stringBuilder = new StringBuilder();

      // можно использовать цикл while или же for
      // задаем начальное значение
      int i = 0;

      // пишем условие пока индекс меньше длины строки 1 ИЛИ пока индекс меньше длины строки 2
      while (i < word1.length() || i < word2.length()) {
        // далее циклом, если индекс меньше строчки, то
        if (i <  word1.length()) {
          // append - добавляем в конец символ, кот. находится по указанной позиции через метод charAt(i)
          stringBuilder.append(word1.charAt(i));
        }
         // далее циклом, если индекс меньше строчки, то для второй строки
        if (i <  word2.length()) {
          // append - добавляем в конец символ, кот. находится по указанной позиции через метод charAt(i)
          stringBuilder.append(word2.charAt(i));
        }
        // и соотв инкрементим
        i++;

      }
// тут возрвщаем итоговую объедененную строчку - объект stringBuilder через метод toString
      return stringBuilder.toString();
    }
  }
}
