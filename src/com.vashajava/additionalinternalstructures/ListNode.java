package com.vashajava.additionalinternalstructures;

/**
 * Клаас ListNode - вспомогательный класс в виде образца для использования в качестве внутренней структуры
 * для определения узлов односвязного списка, для linked list.
 *
 * @author Anton Shatkovskiy
 * @created 16.07.2024 г.
 */
public class ListNode {

  // это значение узла
  int val;
  // это ссылка на следующий элемент, сылка конечного элемента равна null
  ListNode next;

  // конструкторы, или же методы инициализации
  // по умолчанию, дефольный, пустой
  ListNode() {
  }

  // для инициализации значениями
  ListNode(int val) {
    this.val = val;
  }

  // общий конструктор для инициализации значений элементов и ссылки на следующий узел
  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
   }
}
