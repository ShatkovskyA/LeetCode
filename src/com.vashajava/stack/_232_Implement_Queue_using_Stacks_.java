package com.vashajava.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Класс _232_Implement_Queue_using_Stacks_ - имплементация очереди использования стеков.
 *
 * @author Anton Shatkovskiy
 * @created 20.06.2024 г.
 */

/*
Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue)
as long as you use only a stack's standard operations.

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

ПЕРЕВОД: 232. Имплементация очереди использования стеков.
Задача — реализовать очередь по принципу FIFO (first in — first out) с использованием двух стеков

Реализуйте очередь "первый пришел - первый вышел" (FIFO), используя только два стека.
Реализованная очередь должна поддерживать все функции обычной очереди (push, peek, pop и empty).

Реализуйте класс myQueue:

функция void push(int x) Перемещает элемент x в конец очереди.
функция int pop() Удаляет элемент из начала очереди и возвращает его обратно.
Функция int peek() Возвращает элемент в начало очереди.
функция boolean empty() возвращает значение true, если очередь пуста, в противном случае - значение false.
Записи:

Вы должны использовать только стандартные операции со стеком, что означает, что допустимы только операции push to top, peek/pop from top, size и is empty.
В зависимости от вашего языка стек может не поддерживаться изначально. Вы можете имитировать стек, используя список или deque (двустороннюю очередь)
при условии, что вы используете только стандартные операции со стеком.

Пример 1:

Ввод
["Моя очередь", "толчок", "нажимать", "заглядывать", "хлопать", "пусто"]
[[], [1], [2], [], [], []]
Выход
[null, null, null, 1, 1, ложь]

Объяснение
myQueue myQueue = новая очередь();
myQueue.push(1); // очередь такова: [1]
myQueue.push(2); // очередь такая: [1, 2] (крайняя слева - в начале очереди)
myQueue.peek(); // возвращает 1
, myQueue.pop(); // возвращает 1, очередь равна [2]
myQueue.empty(); // возвращает false

Ограничения:

1 <= x <= 9
Для выполнения операций push, pop, peek и empty будет выполнено не более 100 вызовов.
Все вызовы для pop и peek являются действительными.

Уточнение: Можете ли вы реализовать очередь таким образом, чтобы каждая операция была сокращена на (1) временную сложность?
Другими словами, выполнение n операций займет в целом O(n) времени, даже если одна из этих операций может занять больше времени.
 */
public class _232_Implement_Queue_using_Stacks_ {

  public static void main(String[] args) {

    // операции и их параметры:
    String[] operations = {"MyQueue", "push", "push", "peek", "pop", "empty"};
    int[][] params = { {},{1}, {2}, {}, {}, {} };

    // создаем объект результата для хранения выходных данных
    Object[] results = new Object[operations.length];

    // Переменная для MyQueue
    MyQueue obj = null;

    // далее пробегаемся циклом для обработки всех операция + цикл switch-case
    for (int i = 0; i < operations.length; i++) {
      switch (operations[i]) {
        case "MyQueue":
          obj = new MyQueue();
          results[i] = null;
          break;
        case "push":
          int x = params[i][0];
          obj.push(x);
          results[i] = null;
          break;
        case "peek":
          results[i] = obj.peek();
          break;
        case "pop":
          results[i] = obj.pop();
          break;
        case "empty":
          results[i] = obj.empty();
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

//    MyQueue obj = new MyQueue();
//    System.out.println(obj.push(1)); // ожидаемый результат: null
//    System.out.println(obj.push(2)); // ожидаемый результат: null
//    System.out.println(obj.peek()); // ожидаемый результат: 1
//    System.out.println(obj.pop()); // ожидаемый результат: 1
//    System.out.println(obj.empty()); // ожидаемый результат: false

//    MyQueue obj = new MyQueue();
//    obj.push(x);
//    int param_2 = obj.pop();
//    int param_3 = obj.peek();
//    boolean param_4 = obj.empty();
  }

  static class MyQueue {

    // вводим переменные
    // используем два стека для моделирования очереди, согласно условию:
    // strinput используется для операций ввода (push)
    // stkOutput используется для операций вывода (pop и peek)
    private Deque<Integer> stkInput = new ArrayDeque();
    private Deque<Integer> stkOutput = new ArrayDeque();

    // тут конструктор для myQueue. Инициализация не требуется, поскольку
    // переменные-члены уже инициализированы.
    public MyQueue() {
    }

    // это опереация перемещения элемента x в конец очереди,
    // поскольку стек является LIFO (последний вход, первый выход),
    // при перемещении в stkInput порядок будет изменен на обратный при передаче в stkOutput
    public void push(int x) {
      stkInput.push(x);
    }

    // тут операция извлечения-удаления элемента из начала очереди.
    // Если stkOutput пуст, заполняем его, извлекая все элементы
    // из stkInput и помещая их в stkOutput.
    public int pop() {
      // вспомогательный промежуточный метод
      move();
      return stkOutput.pop();

    }
    // тут операция получения элемента front.
    // Аналогично pop, проверяем, что stkOutput содержит элементы, переместив
    // их из stkInput, если необходимо, и затем возвращаем верхний элемент.
    public int peek() {
      // вспомогательный промежуточный метод
      move();
      return stkOutput.peek();
    }
    // тут метод проверки на пустоту - возвращает true, если очередь пуста, то есть когда оба стека пусты
    public boolean empty() {
      return stkInput.isEmpty() && stkOutput.isEmpty();
    }

    // тут вспомогательный промежуточный метод для перемещения элементов из stkInput в stkOutput
    // Он гарантирует, что stkOutput содержит элементы в правильном порядке очереди для просмотра или выскакивания.
    private void move() {
      // если stkOutput пуст, то перемещаем элементы
      if (stkOutput.isEmpty()) {
        // перемещаем все элементы из stkInput в stkOutput - подключаем цикл
        // т. е. тут перемещаем полученные элементы
        while (!stkInput.isEmpty()) {
          stkOutput.push(stkInput.pop());

        }
      }
    }
  }

/**
 * Your MyQueue object will be instantiated and called as such:
 * Ваш объект myQueue будет создан и вызван как таковой:
 *
 * MyQueue obj = new MyQueue(); - // Создает экземпляр myQueue
 * obj.push(x); - // Помещает элемент x в конец очереди
 * int param_2 = obj.pop(); - // Извлекает и удаляет начальный элемент очереди
 * int param_3 = obj.peek(); - // Извлекает, но не удаляет начальный элемент очереди
 * boolean param_4 = obj.empty(); - // Проверяет, пуста ли очередь
 */
}

/*
__init__(): O(1) — Инициализация двух пустых стеков занимает постоянное время.
push(x): O(1) — операция добавления в список (стек) — это амортизированная операция с постоянным временем.
pop(): Амортизированный O(1). В худшем случае эта операция может быть O(n),
где n — количество элементов в stk1, потому что она должна переместить все элементы из stk1в stk2, если stk2пусто.
Однако из-за двухстековой схемы каждый элемент перемещается только один раз,
и для серии операций mэто дает среднюю (или амортизированную) временную сложность O(1).
peek(): Амортизированный O(1) — аналогично pop(), в худшем случае может потребоваться перемещение всех элементов из stk1в stk2,
но из-за амортизированного анализа усреднение происходит до постоянного времени.
empty(): O(1) — проверка пустости двух списков — операция с постоянным временем.
move(): Амортизированный O(1). Хотя в худшем случае при перемещении всех элементов из stk1в он может быть O(n) stk2,
он является частью pop()операций peek()и и способствует их амортизированной временной сложности.
 */
