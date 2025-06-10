package com.vashajava.math;

/**
 * Класс _67_Add_Binary_ - двоичный файл.
 *
 * @author Anton Shatkovskiy
 * @created 28.05.2024 г.
 */

/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

ПЕРЕВОД: 67. Двоичный файл.
Учитывая две двоичные строки a и b, верните их сумму в виде двоичной строки.

Пример 1:

Входные данные: a = "11", b = "1"
Выходные данные: "100"
Пример 2:

Входные данные: a = "1010", b = "1011"
Выходные данные: "10101"

Ограничения:

1 <= a.длина, b.длина <= 104
a и b состоят только из символов '0' или '1'.
Каждая строка не содержит начальных нулей, за исключением самого нуля.
 */

public class _67_Add_Binary_ {

  public static void main(String[] args) {

    String a = "11";
    String b = "1";

    Solution67 solution67 = new Solution67();
    System.out.println(solution67.addBinary(a, b));

  }

  static class Solution67 {
    public String addBinary(String a, String b) {
      // используем StringBuilder для хранения результата двоичной суммы
      StringBuilder result = new StringBuilder();

      // вводим индексы для перебора строк от конца к началу
      int indexA = a.length() - 1;
      int indexB = b.length() - 1;

      // перенос будет использоваться для сложения, если сумма двух битов больше 1
      int carry = 0;

      // испльзуем цикл до тех пор,
      // пока не будут обработаны все символы или не останется переносимых символов
      while (indexA >= 0 || indexB >= 0 || carry > 0) {
        // если все еще находится в пределах строки a, добавьте числовое значение бита для переноса
        if(indexA >= 0) {
          // исп. charAt - библиотечный метод
          carry += a.charAt(indexA) - '0';
          // уменьшаем индекс для строки a
          indexA--;
        }
        // если все еще находится в пределах строки b, добавьте числовое значение бита для переноса
        if(indexB >= 0) {
          // исп. charAt - библиотечный метод
          carry += b.charAt(indexB) - '0';
          // уменьшаем индекс для строки b
          indexB--;
        }
        // добавляем к результату остаток от деления переноса на 2 (либо 0, либо 1)
        // исп. библиотечная функция append(), который обновляет значение объекта
        result.append(carry % 2);
        // перенос обновляется до частного от деления переноса на 2 (либо 0, либо 1)
        carry /= 2;
      }
      // т. к. биты были добавлены справа налево,
      // результат должен быть изменен на противоположный, чтобы он соответствовал правильному порядку,
      // исп. библиотечные функции
      return result.reverse().toString();
    }
  }
}
