package com.vashajava.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс _20_Valid_Parentheses_ - валидация .
 *
 * @author Anton Shatkovskiy
 * @created 05.06.2024 г.
 */

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

ПЕРЕВОД: 20. Значных парентезов.
Учитывая строку s, содержащую только символы '(', ')', '{', '}', '[' и ']', определите, допустима ли входная строка.

Входная строка допустима, если:

Открытые скобки должны быть заключены в скобки того же типа.
Открытые скобки должны закрываться в правильном порядке.
Каждой закрывающей скобке соответствует открытая скобка того же типа.

Пример 1:

Ввод: s = "()"
Вывод: true
Пример 2:

Ввод: s = "()[]{}"
Вывод: true
Пример 3:

Ввод: s = "(]"
Вывод: false

Ограничения:

1 <= сек.длина <= 104
сек. состоит только из круглых скобок '()[]{}'.
 */

  /*
  Используем общую структуру данных,
  известную как стек, которая работает по принципу "последним пришел, первым вышел" (LIFO).
   */

  public class _20_Valid_Parentheses_ {

  public static void main(String[] args) {

     String s = "()";
    String s1 = "()[]{}";

    Solution20 solution20 = new Solution20();
    boolean isValid = solution20.isValid(s);
    boolean isValid1 = solution20.isValid(s1);
    System.out.println(isValid);
    System.out.println(isValid1);
   }

  static class Solution20 {

    // метод определения того, содержит ли входная строка допустимые круглые скобки
    public boolean isValid(String s) {
      // создаем и инициализируем структуру данных стек
      // используем deque в качестве стека, чтобы отслеживать открывающие скобки
      // спольхуем Character
      Deque<Character> stack = new ArrayDeque<>();

      // выполняем итерацию по каждому символу во входной строке
      // исп. форич + oCharArray () представляет собой встроенную функцию Java,
      // которая позволяет преобразовать строку в массив символов, и каждый символ строки в элемент массива.
      for(char c : s.toCharArray()) {
        // если текущий символ является открывающей скобкой, помещаем его в стопку, т. е. в стек
        if(c == '(' || c == '{' || c == '[') {
          stack.push(c);
         } else {
          // если же стек пуст или текущая закрывающая скобка не совпадает
          // последняя открывающая скобка, строка недопустима
          // match () – реализация метода ниже
          if(stack.isEmpty() || !match(stack.pop(), c)) {
            return false;
          }
        }
      }
      // если стек пуст, значит, все скобки были подобраны правильно
      return stack.isEmpty();

    }
    // Вспомогательный метод для определения того, являются ли две скобки совпадающей парой
    public boolean match(char leftBracket, char rightBracket) {
      // Возвращает true, если пары скобок совпадают, в противном случае - false
      return (leftBracket == '(' && rightBracket == ')') ||
          (leftBracket == '[' && rightBracket == ']') ||
          (leftBracket == '{' && rightBracket == '}');
    }
  }
}

/*
Сложность во времени и пространстве
Временная сложность данного кода равна O(n), где n - длина входной строки.
Это связано с тем, что алгоритм перебирает каждый символ во входной строке ровно один раз.

Сложность кода с пробелами также заключается в том, что O(n) как и в худшем случае
(когда все символы во входной строке являются открывающими скобками), стек stk будет содержать все символы во входной строке.

Временная сложность:
Наилучший вариант: Когда строка пуста или состоит из одной пары квадратных скобок, возникает временная сложность,
O(1) поскольку на это требуется постоянное количество времени.
Средний случай: Для типичной строки с сочетанием открывающих и закрывающих скобок временная сложность сохраняется
O(n) потому что каждый символ обрабатывается один раз.
Наихудший случай: В наихудшем сценарии, когда есть n символы и строка правильно вложена до самого глубокого уровня,
каждый символ все равно обрабатывается ровно один раз, что дает нам временную сложность O(n).

Сложность пространства:
Сложность пробела - это O(n) который возникает, когда все символы являются открывающими скобками и,
следовательно, все они помещаются в стек. Это представляет собой максимальное пространство, используемое алгоритмом.
Поскольку стек увеличивается с каждой открывающей скобкой и уменьшается с каждой закрывающей скобкой,
фактическое используемое пространство зависит от количества не совпадающих открывающих скобок в любой точке алгоритма.
Таким образом, использование пробела может варьироваться от O(1) (для пустой строки или строки только с одной парой скобок)
до O(n) (когда все символы заключены в открывающие скобки).
 */
