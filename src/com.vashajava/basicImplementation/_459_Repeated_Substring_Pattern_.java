package basicImplementation;

/**
 * basicImplementation._459_Repeated_Substring_Pattern_.
 *
 * @author Anton Shatkovskiy
 * @created 08.04.2024 г.
 */

/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

ПЕРЕВОД: 459. Повторяющийся подстрочный шаблон.

Получив строку s, проверьте, можно ли ее сконструировать,
взяв из нее подстроку и добавив несколько копий подстроки вместе.

Пример 1:

Ввод: s = "abab"
Вывод: true
Пояснение: это подстрока "ab", повторяющаяся дважды.

Пример 2:

Ввод: s = "aba"
Вывод: false
Пример 3:

Ввод: s = "abcabcabcabc"
Вывод: true
Пояснение: Это подстрока "abc" четыре раза или подстрока "abcabc" два раза.

Ограничения:

1 <= сек.длина <= 104
сек. состоит из строчных английских букв.

 */


public class _459_Repeated_Substring_Pattern_ {

  public static void main(String[] args) {

    String s = "aba";

    Solution459 solution459 = new Solution459();
    System.out.println(solution459.repeatedSubstringPattern(s));


  }

  static class Solution459 {
    public boolean repeatedSubstringPattern(String s) {

      // сначала вводим и получаем длину(размер) строки
      int len = s.length();

      // далее циклом пробегаемся по длине строке, деля ее на 2 и получая подстроки
      // пока не доберемся до минимума, начинаем с int i = len/2, т. е. половине строки
      // т. к. начинаем от большего к меньшему, постепенно уменьшая
      // и если строка делится на 2 то из нее гарантировано можно получить строку
      for (int i = len/2; i >= 1; i-- ) {

        // важно получить после деления фрагменты исходной строки, т. н. подстроки,
        // чтобы сложить их затем до исходной.

        // проверяем, может ли строка делиться или нет на текущее число
        if(len % i == 0) {
          // если строка делима, т. е. четно(равномерно делится), без остатка
          // значит кол-во подстрок равно
          int num_substrings = len / i;
          // далее применяем библиотечный метод
          // substring () - возвращает новую строку, которая является подстрокой данной строки
          // тут - подстрока равна подстроке с точками о 0 до i
          String substring = s.substring(0, i);

          // исп. StringBuilder - создаем объект типа StringBuilder
          StringBuilder sb = new StringBuilder();

          // далее пробегаемся новым циклом по ранее полученной подстроке
          for (int j = 0; j < num_substrings; j++) {
            // append - добавляем подстроку, несколько раз,
            // т. е. в сумме должна получится исходная строка
            sb.append(substring);
          }
          // проверяем на соответствие полученной строки с исхордной
          // т. е. она пвторилась некоторе количество раз и в сумме выдала равно исходной строкен
          if(sb.toString().equals(s)) return true;
        }
      }
      return false;
    }
  }

}


