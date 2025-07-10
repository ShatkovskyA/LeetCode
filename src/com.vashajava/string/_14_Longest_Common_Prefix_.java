package com.vashajava.string;

/**
 * Класс _14_Longest_Common_Prefix_ - самый длинный общий префикс.
 *
 * @author Anton Shatkovskiy
 * @created 12.07.2024 г.
 */

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

ПЕРЕВОД: 14. Самый длинный общий префикс.
Напишите функцию, которая найдет самую длинную строку с общим префиксом среди массива строк.

Если общего префикса нет, верните пустую строку "".

Пример 1:

Входные данные: strs = ["цветок","поток", "полет"]
Выходные данные: "fl"
Пример 2:

Ввод: strs = ["собака","гоночный автомобиль","легковой автомобиль"]
Вывод: ""
Пояснение: Среди входных строк нет общего префикса.

Ограничения:

1 <= длина строки <= 200
0 <= strs[i].длина <= 200
строк[i] состоит только из строчных английских букв.
 */
public class _14_Longest_Common_Prefix_ {

  public static void main(String[] args) {

    // дано
    String[] strs = {"flower", "flow", "flight"};

    Solution14 solution14 = new Solution14();
    String longestCommonPrefix = solution14.longestCommonPrefix(strs);
    System.out.println(longestCommonPrefix);

  }

  static class Solution14 {

    // это есть метод поиска самого длинного общего префикса из массива строк
    public String longestCommonPrefix(String[] strs) {
      // традиционно вводим переменную подсчета для общего количества строк в массиве,
      // гда метод length () — возвращает длину строки в Java
      int numberOfStrings = strs.length;
      // задействуя цикл, перебираем каждый символ первой строки
      for (int index = 0; index < strs[0].length(); ++index) {
        // и сравниваем символ с такой же позицией в остальных строках,
        // т. е. еще один цикл
        for (int stringIndex = 1; stringIndex < numberOfStrings; ++stringIndex) {
          // тут проверяем два условия:
          // 1. Если текущая строка короче текущего символьного индекса, или (||) же
          // 2. Если текущий символ не совпадает с символом в первой строке, где charAt(index) -
          // это получаем текущий символ библиотечным методом, strs[0].charAt(index) - символ в первой строке.
          // в любом случае это означает, что нашли конец общего префикса
          if (strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)) {
            // и тут следовательно, возвращаем подстроку от начала к текущему индексу из первой строки,
            // где substring - это библиотечный метод в Java,
            // который извлекает последовательность символов из строки и возвращает её как новый объект
            return strs[0].substring(0, index);
          }
        }
      }
      // и если нам удастся проверить все символы первой строки, не обнаружив несоответствия,
      // то это означает, что вся первая строка является общим префиксом.
      return strs[0];
    }
  }
}

/*
Временная сложность кода равна O(n * m), где n— количество строк в заданном списке и mпредставляет собой длину самой короткой строки в списке.
Каждый символ самой короткой строки повторяется nнесколько раз, чтобы проверить, является ли он общим префиксом для всех строк.
 */

