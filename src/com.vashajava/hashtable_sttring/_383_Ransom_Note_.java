package hashtable_sttring;

/**
 * _383_Ransom_Note_.
 *
 * @author Anton Shatkovskiy
 * @created 25.06.2024 г.
 */

/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

ПЕРЕВОД: 383. Записка о выкупе.
Учитывая две строки ransomnote и magazine,
верните значение true, если ransomNote может быть создан с использованием букв из magazine, и значение false в противном случае.

Каждая буква в magazine может быть использована в ransomNote только один раз.

Пример 1:

Ввод: ransomNote = "a", magazine = "b".
Вывод: false
Пример 2:

Ввод: ransomNote = "aa", журнал = "ab"
Вывод: false
Пример 3:

Ввод: ransomNote = "aa", журнал = "aab"
Вывод: true

Ограничения:

1 <= Купюра-выкуп.длина, журнал.длина <= 105
Купюра-выкуп и журнал состоят из строчных английских букв.
 */
public class _383_Ransom_Note_ {

  public static void main(String[] args) {

    String ransomNote = "a";
    String magazine = "b";

    Solution383 solution383 = new Solution383();
    boolean canConstruct = solution383.canConstruct(ransomNote, magazine);
    System.out.println(canConstruct);

  }

  static class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
      // создаем массив для подсчета встречаемости каждой буквы в журнале,
      // где 26 - это количество букв в англ. алфавите
      int[] letterCounts = new int[26];

      // далее заполняем массив letterCounts количеством символов в журнале (magazine),
      // применяя для этого цикл for
      for (int i = 0; i < magazine.length(); i++) {
        // увеличвая при этом количество текущего символа,
        // применяя библиотечный метод charAt(i) - возвращает значение char по указанному индексу,
        // где индекс колеблется от 0 до length()-1, поэтому и - 'a'
        letterCounts[magazine.charAt(i) - 'a']++;
      }
      // далее проверка, можно ли составить записку с требованием выкупа, используя буквы в журнале
      // проверка опять для цикла
      for(int i = 0; i < ransomNote.length(); i++) {
        // уменьшаем количество текущего символа, так как оно используется в сообщении о выкупе
        // и если какой-либо буквы в сообщении о выкупе не хватает, верните значение false
        // опять же, применяя библиотечный метод charAt(i) - возвращает значение char по указанному индексу,
        // где индекс колеблется от 0 до length()-1, поэтому и - 'a'
        if (--letterCounts[ransomNote.charAt(i) - 'a'] < 0) {
          return false;
        }
      }
      // а если все буквы учтены, то возвращаем значение true
      return true;
    }
  }
}

/*
Каждую букву в magazineможно использовать только один раз.
Порядок букв в . ransomNoteне обязательно должен совпадать с порядком в magazine.
Если все буквы в ransomNoteможно сопоставить с буквами в magazine,
принимая во внимание частоту появления каждой буквы, то результат должен быть true.
И наоборот, если есть какие-либо буквы в, ransomNoteкоторые встречаются больше раз, чем в magazine, или если есть какие-либо буквы в,
ransomNoteкоторые вообще не появляются в magazine, вывод должен быть false.

Временная сложность функции canConstructравна O(m + n), где m– длина строки ransomNote, n– длина строки magazine. Это связано с тем,
что функция сначала подсчитывает вхождения каждого символа в строке журнала,
что требует O(n)времени, а затем перебирает каждый символ в записке о выкупе, что требует O(m)времени.
Каждое уменьшение и сравнение символов представляет собой O(1)операцию, поэтому общее время цикла составляет 0,000 O(m).
В совокупности это приводит к O(m + n)усложнению времени.
 */
