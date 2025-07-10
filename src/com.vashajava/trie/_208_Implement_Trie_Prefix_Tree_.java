package com.vashajava.trie;

/**
 * Класс _208_Implement_Trie_Prefix_Tree_ - реализация дерева (Префиксное дерево).
 *
 * @author Anton Shatkovskiy
 * @created 11.09.2024 г.
 */

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

ПЕРЕВОД: 208. Реализация дерева (Префиксное дерево).
Trie (произносится как "пробовать") или префиксное дерево - это древовидная структура данных, используемая для эффективного хранения и извлечения ключей в наборе строк.
Существуют различные приложения этой структуры данных, такие как автозаполнение и проверка орфографии.

Реализован класс Trie:

Trie() Инициализирует объект trie.
void insert(строковое слово) Вставляет строковое слово в trie.
логический поиск (строковое слово) возвращает значение true, если строковое слово находится в файле trie (т.е. было вставлено ранее), и значение false в противном случае.
логическое значение StartsWith(Префикс строки) возвращает значение true, если ранее было вставлено строковое слово, имеющее префикс prefix, и значение false в противном случае.


Пример 1:

Ввод
["Trie", "insert", "search", "поиск", "Начинается с", "insert", "поиск"]
[[], ["apple"], ["яблоко"], ["приложение"], ["приложение"], ["приложение"], ["приложение"]]
Выход
[нуль, нуль, истина, ложь, истина, нуль, истина]

Объяснение
Trie trie = new Trie();
trie.insert("яблоко");
trie.search("яблоко"); // возвращает True
trie.search("приложение"); // возвращает False
trie.StartsWith("приложение"); // возвращает True
trie.insert("приложение");
trie.search("приложение"); // возвращает значение True


Ограничения:

1 <= слово.длина, префикс.длина <= 2000
слово и префикс состоят только из строчных английских букв.
В общей сложности будет сделано не более 3 * 104 вызовов для вставки, поиска и запуска с помощью.

 */
public class _208_Implement_Trie_Prefix_Tree_ {

  public static void main(String[] args) {

    // водим данные
    Trie trie = new Trie();
    trie.insert("apple");
    System.out.print("[ ");
    System.out.print(trie.search("apple"));   // return True
    System.out.print(" ");
    System.out.print(trie.search("app"));     // return False
    System.out.print(" ");
    System.out.print(trie.startsWith("app")); // return True
    System.out.print(" ");
    trie.insert("app");
    System.out.print(trie.search("app"));     // return True
    System.out.println(" ]");
  }

  static class Trie {
    // ОСНОВНЫЕ ЭТАПЫ РЕАЛИЗАЦИИ ДЕРЕВА
    // I. ИНИЦИАЛИЗАЦИЯ
    // каждый узел Trie может иметь не более 26 дочерних элементов для каждой буквы алфавита (по числу букв в алфавите)
    // т. е. это массива дочерних узлов - создаем его
    private Trie[] children;
    // isEndOfWord имеет значение true (по умолчанию), если узел представляет собой конец слова - это переменная необходима, как флаг окончания слова
    // а тут флаг
    private boolean isEndOfWord;

    // традиционно создаем конструктор инициализирует узел Trie пустым массивом для дочерних узлов
    public Trie() {
      // инициализируем что 26 элементов алфавита
      children = new Trie[26];
      // флаг - false
      isEndOfWord = false;
    }

    // II. МЕТОД ВСТАВКИ
    // тут метод для вставки слова в файл trie - передаем в кач-ве аргумента String word
    public void insert(String word) {
      // создаем объект дерева - здесь
      Trie cirrentNode = this;
      // далее цикл облегченный
      // пробегаемся по строке word, с toCharArray() — это "заводской", бебиблиотечный, стандартный метод,
      // который позволяет преобразовать строку в массив символов, превращая каждый символ строки в элемент массива
      for(char letter : word.toCharArray()) {
        // вычисляем индекс, соответствующий букве
        int index = letter - 'a';
        // и если у буквы нет соответствующего узла Trie,
        // т. е. объект.узел по индексу == null - то создаем его
        if (cirrentNode.children[index] == null) {
          cirrentNode.children[index] = new Trie();
        }
        // делее переходим к следующему узлу
        cirrentNode = cirrentNode.children[index];
      }
      // выставляем флаг конца слова, потому что изначально - false
      cirrentNode.isEndOfWord = true;
    }

    // III. МЕТОД ПОИСКА
    // метод для поиска, существует ли это слово в файле trie
    public boolean search(String word) {
      // создаем переменную класса с помощью вспомогательного метода поиска префикса или слова
      Trie node = searchPrefix(word);
      // если значение node не равно null, а (&& - логическое И) значение isEndOfWord равно true, то тогда это слово существует в файле trie
      return node != null && node.isEndOfWord;
    }

    // IV. МЕТОД
    // проверяет, есть ли в файле trie какое-либо слово, начинающееся с заданного префикса - в аргументе String prefix
    public boolean startsWith(String prefix) {
      // создаем переменную класса с помощью вспомогательного метода поиска префикса или слова
      Trie node = searchPrefix(prefix);
      // и далее, если узел не равен null, то есть слово, начинающееся с префикса
      return node != null;
    }

    // V. ВСПОМОГАТЕЛЬНЫЙ МЕТОД ДЛЯ ПОИСКА ПРЕФИКСА ИЛИ ОТДЕЛЬНОГО ЦЕЛОГО СЛОВА
    // Это вспомогательный метод для поиска префикса или целого слова в файле trie и возврата узла, на котором заканчивается поиск
    private Trie searchPrefix(String s) {
      // опять создаем объект дерева здесь
      Trie currentNode = this;
      // и опять пробегаемся по облегеченному циклу for
      // пробегаемся по строке s, с toCharArray() — это "заводской", бебиблиотечный, стандартный метод,
      // который позволяет преобразовать строку в массив символов, превращая каждый символ строки в элемент массива
      for (char letter : s.toCharArray()) {
        // также опять вычисляем индекс, соответствующий букве
        int index = letter - 'a';
        // и если у буквы нет соответствующего узла Trie,
        // т. е. объект.узел по индексу == null
        if (currentNode.children[index] == null) {
          // и если следующий узел не существует, то возвращаем значение null, указывающее на то, что префикс не существует
          return null;
         }
        // снова переходим к следующему узлу Trie
        currentNode = currentNode.children[index];
      }
      // возвращаем узел, на котором завершился поиск, может представлять префикс или целое слово
      return currentNode;
    }
  }

/**
 * Your Trie object will be instantiated and called as such:
 * Ваш объект Trie будет создан и вызван как таковой:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}

/*
insert метод: Временная сложность равна O (n), где n - длина вставляемого слова.
Это потому, что мы перебираем каждый символ слова и выполняем операции с постоянным временем для каждого из них.

search метод: Временная сложность в наихудшем случае также равна O (n),
предполагая, что n - длина слова, которое ищется. Это похоже на insert, поскольку метод проходит по Trie,
что требует времени, пропорционального длине слова.

startsWith метод: Временная сложность в наихудшем случае равна O (m), где m - длина префикса.
Это связано с обходом дерева на глубину, равную длине префикса.

_search_prefix метод (используется как search, так и startsWith): временная сложность здесь равна O (p), где p - длина префикса.
Он выполняется только один раз при каждом вызове метода.
 */
