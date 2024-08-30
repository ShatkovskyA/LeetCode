package com.vashajava.string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * _3_Longest_Substring_Without_Repeating_Characters_.
 *
 * @author Anton Shatkovskiy
 * @created 28.08.2024 г.
 */

/*
Given a string s, find the length of the longest
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

ПЕРЕВОД: 3. Самая длинная подстрока без повторяющихся символов.
Для заданной строки s найдите длину самой длинной
подстроки без повторяющихся символов.

Пример 1:

Входные данные: s = "abcabcbb"
Выходные данные: 3
Пояснение: Ответом будет "abc", длина которого равна 3.
Пример 2:

Ввод: s = "bbbbb"
Вывод: 1
Пояснение: Ответ - "b", длина которого равна 1.
Пример 3:

Ввод: s = "pwwkew"
Вывод: 3
Пояснение: Ответом будет "we", длина которого равна 3.
Обратите внимание, что ответом должна быть подстрока, "pwke" - это подпоследовательность, а не подстрока.

Ограничения:

0 <= сек.длина <= 5 * 104
сек. состоит из английских букв, цифр, символов и пробелов.

 */
public class _3_Longest_Substring_Without_Repeating_Characters_ {

  public static void main(String[] args) {

    String s = "abcabcbb";

    Solution3 solution3 = new Solution3();
    int lengthOfLongestSubstring = solution3.lengthOfLongestSubstring(s);
    System.out.println(lengthOfLongestSubstring);

  }

  static class Solution3 {

    // это, собственно говоря, сам вычисления длины самой длинной подстроки без повторяющихся символов
    public int lengthOfLongestSubstring(String s) {
      // ТУТ ВВОДИМ СТАНДАРТНЫЕ ПЕРЕМЕННЫЕ ДЛЯ ПОДОБНОГО ТИПА ЗАДАЧ, ИХ ТРИ:
      // вводим для дальнейшего использования хэш-набор для хранения символов в текущем окне без дубликатов
      Set<Character> charSet = new HashSet<>();
      // создаем и инициализируем левый указатель для скользящего окна
      int leftPointer = 0;
      // создаем и инициализируем переменную для отслеживания длины самой длинной подстроки
      int maxLength = 0;

      // теперь выполняем итерацию по строке с помощью правого указателя,
      // правый указатель создаем и инициалищируем в цикле, а не отдельно
      for(int rightPointer = 0; rightPointer < s.length(); ++rightPointer) {
        // тут получаем текущий символ с правым указателем, вводим новую переменную - счетчик
        // гда charAt() - "заводской" библиотечный метод, возвращает символ из массива строки по указанному индексу
        char currentChar = s.charAt(rightPointer);

        // и, если, currentChar уже есть в наборе, это означает, что мы нашли повторяющийся символ
        // поэтому перемещаем левый указатель окна вправо до тех пор, пока дубликат не будет удален,
        // гда contains() — "заводской" библиотечный метод класса String,
        // предназначенная для поиска определённой последовательности или набора символов в заданной строке.
        while (charSet.contains(currentChar)) {
          // гда remove() — "заводской" библиотечный метод для удаления элементов
          // гда charAt() - "заводской" библиотечный метод, возвращает символ из массива строки по указанному индексу.
          charSet.remove(s.charAt(leftPointer++));
        }
        // и теперь добавляем текущий символ в набор, так как теперь он уникален в текущем окне
        charSet.add(currentChar);

        // далее вычисляем длину текущего окна (указатель вправо - указатель влево + 1)
        // обновляем максимальную длину, если текущее окно больше, применяем также "заводской" библиотечный метод Math.max()
        maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
      }
      // и возвращаем получившуюся длину самой длинной подстроки без повторяющихся символов
      return maxLength;
    }
  }
}

/*
Временная сложность кода составляет, O(2n) что упрощает до O(n), где n - длина строки s.
Это связано с тем, что в худшем случае на каждый символ будут дважды наведены два указателя i и j - один раз, когда j встречается с символом,
и один раз, когда i проходит мимо символа после того, как он был найден в наборе ss.
Однако каждый символ обрабатывается только постоянное количество раз, следовательно, мы считаем, что общая временная сложность линейна.
 */
