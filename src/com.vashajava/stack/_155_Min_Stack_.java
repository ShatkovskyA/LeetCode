package com.vashajava.stack;

/**
 * _155_Min_Stack_.
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

  }

  class MinStack {

    public MinStack() {

    }

    public void push(int val) {

    }

    public void pop() {

    }

    public int top() {
      return 0;

    }

    public int getMin() {

      return 0;

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

 */
