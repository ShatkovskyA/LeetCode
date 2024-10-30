package com.vashajava.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * _139_Word_Break_.
 *
 * @author Anton Shatkovskiy
 * @created 30.10.2024 г.
 */

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

ПЕРЕВОД: 139. Разрыв слов.
Если задана строка s и словарь строк wordDict, верните значение true,
если s можно разделить на разделенную пробелами последовательность из одного или нескольких словарных словарей.

Обратите внимание, что одно и то же слово в словаре может быть повторно использовано при сегментации несколько раз.

Пример 1:
Ввод: s = "leetcode", wordDict = ["leet","code"]
Вывод: true
Пояснение: Верните значение true, потому что "leetcode" может быть сегментирован как "leetcode".

Пример 2:
Ввод: s = "apple pen apple", wordDict = ["apple","ручка"]
Вывод: true
Пояснение: Верните значение true, потому что "apple pen apple" может быть сегментировано как "apple pen apple".
Обратите внимание, что вы можете повторно использовать слово из словаря.

Пример 3:
Ввод: s = "кошки и собаки", wordDict = ["кошки","собака", "песок","и","кот"]
Вывод: false

Ограничения:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].длина <= 20
с и wordDict[i] состоят только из строчных английских букв.
Все строки wordDict уникальны.
 */

  // используем динамическое программирование (DP),
// которое представляет собой метод решения сложных задач путем разбиения их на более простые подзадачи
public class _139_Word_Break_ {

  public static void main(String[] args) {

    String s = "leetcode";
    // List.of(): это статический метод List, который создает неизменяемый список из переданных аргументов
    // new String[]{"leet", "code"}: это массив строк
    List<String> wordDict = List.of(new String[]{"leet", "code"});

    Solution139 solution139 = new Solution139();
    boolean wordBreak = solution139.wordBreak(s, wordDict);
    System.out.println(wordBreak);
  }

  static class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
      // преобразуем список слов в хэш-набор для эффективного поиска
     Set<String> wordSet = new HashSet<>(wordDict);

     // далее вводим переменную для возврата длины строки 's'
      int strLenght = s.length();

      // затем инициализируем логический массив, чтобы отслеживать возможные разрывы слов
      // значение f[i] равно true, если первые i символов строки можно разделить на слова из словаря
      boolean[] wordBreakTrecker = new boolean[strLenght + 1];

      // тут пустая строка - это допустимо для декомпозиции, задаем изначальное значение
      wordBreakTrecker[0] = true;

      // и теперь, с помощью цикла проверяем каждую подстроку, начиная с длины от 1 до strLength
      for(int i = 0; i <= strLenght; ++i) {
        // пробуем разные точки останова
        for(int j = 0; j < i; ++j) {
          // традиционно условие, если строку до j можно разбить на допустимые слова, а подстрока от j до i есть в словаре
          // тогда отмечаем позицию i как true в wordBreakTracker,
          // где contains() - метод класса String, который проверяет, является ли определённый набор символов частью данной строки или нет,
          // а substring() - возвращает новую строку, которая является подстрокой данной строки
          if(wordBreakTrecker[j] && wordSet.contains(s.substring(j, i))) {
            wordBreakTrecker[i] = true;
            // и дальше выходим из цикла, так как допустимая точка останова - найдена
            break;
          }
        }
      }
      // последняя строка в wordBreakTracker указывает, можно ли сегментировать всю строку целиком или нет
      return wordBreakTrecker[strLenght];
    }
  }
}

/*
Чтобы рассчитать временную сложность, нам нужно учитывать операции, выполняемые внутри цикла:

Мы перебираем длину строки, s что дает нам значение, O(n) гдеn - длина входной строки.
Внутри каждой итерации вызывается функция any(), которая в худшем случае будет выполнять итерацию по i элементам.
Для каждого из этих элементов мы проверяем, является ли f[j]
Истинным (постоянное время), и s[j:i] in words что O(i-j) является наихудшим случаем,
поскольку поиск в наборе - это O(1) но нарезка строки - это O(i-j).
Наихудшая временная сложность - это когда s[j:i] является словом для всех j и i, поэтому мы должны проверять каждую возможную подстроку.
Таким образом, временная сложность возрастает, O(n^2 * k) где k - максимальная длина слова,
потому что для каждого слова i мы выполняем i проверки, и каждая проверка может занять до k времени из-за нарезки строки.
 */
