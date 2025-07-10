package com.vashajava.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс _155_Min_Stack_ - минимальный стек. (реализация стека).
 *
 * @author Anton Shatkovskiy
 * @created 16.09.2024 г.
 */

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

ПЕРЕВОД: 144. Мнииальный стек. (реализация стека)
Разработайте стек, который поддерживает операции push, pop, top и получение минимального элемента за постоянное время.

Реализуйте класс minStack:

Функция minStack() инициализирует объект stack.
функция void push(int val) помещает элемент val в стек.
функция void pop() удаляет элемент, находящийся на вершине стека.
функция int top() возвращает верхний элемент стека.
Функция int getMin() извлекает минимальный элемент в стеке.
Необходимо реализовать решение, требующее O(1) временной сложности для каждой функции.

Пример 1:

Ввод
["minStack","push", "нажимать", "нажимать", "getMin", "pop", "top", "getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Выход
[нуль, нуль, нуль, нуль,-3, нуль,0,-2]

Объяснение
minStack minStack = новый minStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // возвращает -3
minStack.pop();
minStack.top(); // возвращает 0
minStack.getMin(); // возвращает -2

Ограничения:

-231 <= val <= 231 - 1
Операции методов pop, top и getMin всегда будут вызываться для непустых стеков.
Для push, pop, top и getMin будет выполнено не более 3 * 104 вызовов.
 */
public class _155_Min_Stack_ {

  public static void main(String[] args) {

    // операции и их параметры:
    String[] operations = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
    int[][] params = { {}, {-2}, {0}, {-3}, {}, {}, {}, {} };

    // создаем объект результата для хранения выходных данных
    Object[] results = new Object[operations.length];

    // Переменная для MyQueue
    // MinStack obj = null;
//    MinStack obj = new MinStack();
//    obj.push(val);
//    obj.pop();
//    int param_3 = obj.top();
//    int param_4 = obj.getMin();

    MinStack minStack = new MinStack();
//    System.out.println(minStack.push(-2));
//    System.out.println(minStack.push(0));
//    System.out.println(minStack.push(-3));
//    System.out.println(minStack.getMin()); // return -3
//    System.out.println(minStack.pop());
//    System.out.println(minStack.top());    // return 0
//    System.out.println(minStack.getMin()); // return -2
//
//    minStack.push(val);
//    minStack.pop();
//    int param_3 = minStack.top();
//    int param_4 = minStack.getMin();

    // далее пробегаемся циклом для обработки всех операция + цикл switch-case
    for (int i = 0; i < operations.length; i++) {
      switch (operations[i]) {
        case "MyQueue":
//          obj = new MinStack();
          results[i] = null;
          break;
        case "push":
          int x = params[i][0];
          minStack.push(x);
          results[i] = null;
          break;
        case "getMin":
          results[i] = minStack.getMin();
          break;
        case "pop":
          minStack.pop();
          results[i] = null;
          break;
        case "top":
          results[i] = minStack.top();
          break;
      }
    }

    // вывод на печать результатов
    for (Object result : results) {
      // System.out.println(result);
      if (result != null) {
        System.out.print(result + " ");
      } else {
        System.out.print("null ");
      }
    }

  }

  static class MinStack {

    // 1 ИНИЦИАЛИЗИРУЕМ ДВА ПУСТЫХ СТЕКА
    // основной стек stk1 отслеживает все элементы в стеке - сюда все кладется
    private Deque<Integer> stk1 = new ArrayDeque<>();
    // вспомогательный стек minValuesStack для минимальных значений отслеживает минимальные значения в каждом состоянии стека
    private Deque<Integer> minValuesStack = new ArrayDeque<>();

    // традиционно - конструктор для инициализации minValuesStack максимальным значением, которое может содержать целое число,
    // с приминением метода push()
    public MinStack() {
     minValuesStack.push(Integer.MAX_VALUE);
    }

    // метод, который позволяет поместить элемент в стек и также обновляет минимальное значение
    public void push(int val) {
      // помещаем значение в стек
      stk1.push(val);
      // перемещаем меньшее значение между текущим значением и текущим минимумом в minValuesStack
      // для получения Math.min() применяем "заводской" стандартный библиотечный метод +
      // peek() используется для возврата копии первого (головного) элемента объекта, не вызывает исключений
      minValuesStack.push(Math.min(val, minValuesStack.peek()));
    }

    // метод, который позволяет удалить верхнеий элемент из стека и также обновляет минимальное значение
        public void pop() {
          // тут - удаляем верхний элемент стека
          stk1.pop();
          // и тут также удаляем верхний элемент minValuesStack, который соответствует минимуму в этом состоянии
          minValuesStack.pop();
    }

    // метод, который позволяет извлечь верхний элемент стека без его удаления
    public int top() {
      // посмотрим в верхний элемент стека, опять же,
      // используем peek() для возврата копии первого (головного) элемента объекта, не вызывает исключений
      return stk1.peek();
    }

    // метод, который позволяет получить текущее минимальное значения в стеке
    public int getMin() {
      // смотрим верхний элемент minValuesStack, который является текущим минимумом. и снова,
      // используем peek() для возврата копии первого (головного) элемента объекта, не вызывает исключений
      return minValuesStack.peek();
    }
  }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
/*
В целом, все операции MinStack класса выполняются за постоянное время,
поэтому у нас есть O(1) временные сложности для методов push, pop, top и getMin.
 */
