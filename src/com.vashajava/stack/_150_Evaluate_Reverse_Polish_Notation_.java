package com.vashajava.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * Класс _150_Evaluate_Reverse_Polish_Notation_ - вычислить обратную польскую нотацию.
 *
 * @author Anton Shatkovskiy
 * @created 06.09.2024 г.
 */

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].

ПЕРЕВОД: 150. Вычислить обратную польскую нотацию. (обратная польская нотация (RPN) это 34+ = 3+4 и только два последних операнда в массиве!!!)
Вам предоставлен массив токенов strings, представляющий арифметическое выражение в обратной польской записи.

Вычислите выражение. Верните целое число, представляющее значение выражения.

Обратите внимание, что:

Допустимыми операторами являются '+', '-', '*', и '/'.
Каждый операнд может быть целым числом или другим выражением.
Деление между двумя целыми числами всегда приводит к нулю.
Никакого деления на ноль не будет.
Входные данные представляют собой допустимое арифметическое выражение в обратной польской записи.
Ответ и все промежуточные вычисления могут быть представлены в виде 32-разрядного целого числа.

Пример 1:

Ввод: токены = ["2","1","+","3","*"]
Вывод: 9
Пояснение: ((2 + 1) * 3) = 9
Пример 2:

Входные данные: токены = ["4","13","5","/","+"]
Выходные данные: 6
Пояснение: (4 + (13 / 5)) = 6
Пример 3:

Ввод: токены = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Выход: 22
Объяснение: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

Ограничения:

1 <= токены.длина <= 104
токена[i] - это либо оператор: "+", "-", "*",, либо "/", либо целое число в диапазоне [-200, 200].
 */
public class _150_Evaluate_Reverse_Polish_Notation_ {

  public static void main(String[] args) {

    String[] tokens = {"2", "1", "+", "3", "*"};

    Solution150 solution150 = new Solution150();
    int evalRPN = solution150.evalRPN(tokens);
    System.out.println(evalRPN);

  }

  static class Solution150 {
    public int evalRPN(String[] tokens) {
      // Создаем и инициализируем стек для хранения целочисленных значений
      Deque<Integer> stack = new ArrayDeque<>();

      // Теперь применяем цикл foreach для итераций по каждому токену во входном массиве tokens
      for(String token : tokens) {
             // Поверка, является ли токен числом (однозначным или многозначным),
        // т. е. если массив больше нуля логическое или,
        // где Character.isDigit () – определяет, является ли указанное значение типа char цифрой,
        // а charAt() - тардиционный "заводской" библиотечный метод, возвращает символ в определённой позиции индекса в строке.
        if(token.length() > 1 || Character.isDigit(token.charAt(0))) {
          // помещаем номер в стопку-стек,
          // где parseInt() — это статический метод, который возвращает примитивное значение типа int,
          // а push() тардиционный "заводской" библиотечный метод - для включения в стопку
          stack.push(Integer.parseInt(token));
        } else {
          // тут выбираем два верхних элемента для оператора,
          // а pop() тардиционный "заводской" библиотечный метод - чтобы забрать элемент bp стека
          int secondOperand = stack.pop();
          int firstOperand = stack.pop();

          // теперь применяем оператор к двум операндам на основе токена, с приминением цикла switch-case
          switch (token) {
            // тут исп. классические оператры математический функций
            // складываем и передаем результат операции
            case "+":
              stack.push(firstOperand + secondOperand);
              break;
            // вычитаем и передаем результат операции
            case "-":
              stack.push(firstOperand - secondOperand);
              break;
            // умножаем и передаем результат операции
            case "*":
              stack.push(firstOperand * secondOperand);
              break;
            // делим и передаем результат операции
            case "/":
              stack.push(firstOperand / secondOperand);
              break;
          }
        }
      }
      // возвращаем конечный результат - это единственный оставшийся элемент в стеке, которое получается после выполнения операций RPN
      return stack.pop();
    }
  }
}

/*
Временная сложность этой функции составляет O(n), где n - количество токенов во входном списке tokens.
Это потому, что функция выполняет итерацию по каждому токену ровно один раз.
Можно считать, что каждая операция в цикле, включая арифметические операции и операции стека (добавление и pop), имеет постоянную временную сложность, O(1).
 */
