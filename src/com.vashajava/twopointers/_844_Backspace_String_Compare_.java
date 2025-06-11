package com.vashajava.twopointers;

/**
 * Класс _844_Backspace_String_Compare_ - сравнение строк Backspace.
 *
 * @author Anton Shatkovskiy
 * @created 04.07.2024 г.
 */

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors.
'#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.

Follow up: Can you solve it in O(n) time and O(1) space?

ПЕРЕВОД. 844. Сравнение строк Backspace.
Если заданы две строки s и t, верните значение true, если они равны, если обе используются в текстовых редакторах типа int empty.
"#" означает символ обратного пробела.

Обратите внимание, что после обратного пробела в пустом тексте текст останется пустым.

Пример 1:

Ввод: s = "ab#c", t = "ad#c"
Вывод: true
Пояснение: и s, и t становятся "ac".
Пример 2:

Ввод: s = "ab##", t = "c#d#"
Вывод: true
Пояснение: и s, и t становятся "".
Пример 3:

Входные данные: s = "a#c", t = "b"
Выходные данные: false
Пояснение: s становится "c", а t становится "b".

Ограничения:

1 <= общая длина, т.е.длина <= 200
буквы s и t состоят только из строчных букв и символов "#".

Продолжение: Можете ли вы решить задачу за O (n) времени и O (1) интервала?

 */
public class _844_Backspace_String_Compare_ {

  public static void main(String[] args) {

    String s = "ab#c";
    String t = "ad#c";

    Solution844 solution844 = new Solution844();
    boolean backspaceCompare = solution844.backspaceCompare(s, t);
    System.out.println(backspaceCompare);
  }

  static class Solution844 {

    public boolean backspaceCompare(String s, String t) {
      // инициализируем два указателя для выполнения итерации по строкам в обратном порядке
      int pointerS = s.length() - 1;
      int pointerT = t.length() - 1;
      // тут - переменные для отслеживания количества найденных обратных пространств
      int skipS = 0;
      int skipT = 0;
      // а теперь сравниваем символы до тех пор,
      // пока оба указателя не выйдут за пределы начала строки - цикл while
      while (pointerS >= 0 || pointerT >= 0) {
        // тут еще один цикл для обработки обратных пробелов в строке s
        while (pointerS >= 0) {
          // если нашли символ обратного пробела
          if (s.charAt(pointerS) == '#') {
            // тут переменную для отслеживания итеррируем на 1
            skipS++;
            // и тогда перемещаем один символ назад
            pointerS--;
          } else if (skipS > 0) {
            // тут уменьшаем количество пробелов
            skipS--;
            // и пропускаем этот символ
            pointerS--;
          } else {
            // нашли персонажа для сравнения
            break;
          }
        }
        // и теперь аналогичный процесс - обработка обратных пробелов в строке t
        while (pointerT >= 0) {
          // опять, если нашли для t символ обратного пробела
          if (t.charAt(pointerT) == '#') {
            // тут переменную для отслеживания итеррируем на 1
            skipT++;
            // а соответствующий указатель перемещаем назад
            pointerT--;
          } else if (skipT > 0) {
            // тут уменьшаем количество пробелов
            skipT--;
            // и пропускаем этот символ
            pointerT--;
          } else {
            // нашли персонажа для сравнения
            break;
          }
        }
        // а теперь сравниваем символы обеих строк
        if (pointerS >= 0 && pointerT >= 0) {
          // если символы не совпадают, то возвращаем значение false
          if (s.charAt(pointerS) != t.charAt(pointerT)) {
            return false;
          }
        } else if (pointerS >= 0 || pointerT >= 0) {
          // а если один указатель достиг начала, а другой - нет, они не совпадаю
          return false;
        }
        // переходим к следующему символу для сравнения, т. к. движемся в обратную сторону, то --
        pointerS--;
        pointerT--;
      }
      // и вот тут символы совпадают, учитывая символы обратного пробела, поэтому возвращаем
      return true;
  }
}
}

/*
Временная сложность данного кода равна O(N + M), где N– длина строки s, M– длина строки t.
Это связано с тем, что в худшем случае алгоритму, возможно, придется один раз перебрать все символы в обеих строках.
Обработка символа возврата ( #) увеличивает только количество итераций в постоянный коэффициент, но не общую сложность.
 */
