package com.vashajava.string;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * _981_Time_Based_KeyValue_Store_.
 *
 * @author Anton Shatkovskiy
 * @created 09.10.2024 г.
 */

/*
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

Constraints:

1 <= key.length, value.length <= 100
key and value consist of lowercase English letters and digits.
1 <= timestamp <= 107
All the timestamps timestamp of set are strictly increasing.
At most 2 * 105 calls will be made to set and get.

ПЕРЕВОД: 981. Хранилище ключей-значений на основе времени.
Разработайте структуру данных ключ-значение, основанную на времени,
которая может хранить несколько значений для одного и того же ключа в разные моменты времени и извлекать значение ключа в определенный момент времени.

Реализуйте класс TimeMap:

Функция TimeMap() инициализирует объект структуры данных.
void set(String key, String value, int timestamp) Хранит ключ key со значением value на данный момент времени timestamp.
String get(String key, int timestamp) Возвращает значение, такое, что set вызывался ранее, с timestamp_prev <= временная метка.
Если таких значений несколько, возвращается значение, связанное с наибольшим timestamp_prev. Если значений нет, то возвращается "".

Пример 1:

Ввод
["Временная карта", "установить", "получить", "получить", "установить", "получить", "получить"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Выход
[null, null, "столбец", "столбец", null, "столбец2", "столбец2"]

Объяснение
Временная карта timeMap = новая временная карта();
timeMap.set("foo", "bar", 1); // сохраняем ключ "foo" и значение "bar" вместе с меткой времени = 1.
timeMap.get("foo", 1); // возвращаем "bar".
timeMap.get("foo", 3); // возвращает "bar", поскольку нет значения, соответствующего foo на отметке времени 3 и отметке времени 2, то единственным значением на отметке времени 1 является "bar".
timeMap.set("foo", "bar2", 4); // сохраняем ключ "foo" и значение "bar2" вместе с меткой времени = 4.
timeMap.get("foo", 4); // возвращает "столбец 2"
timeMap.get("foo", 5); // возвращает "столбец 2"

Ограничения:

1 <= ключ.длина, значение.длина <= 100
ключ и значение состоят из строчных английских букв и цифр.
1 <= временная метка <= 107
Все временные метки в set строго возрастают.
Для установки и получения будет выполнено не более 2 * 105 вызовов.
 */
public class _981_Time_Based_KeyValue_Store_ {

  public static void main(String[] args) {

    String[] operations = {"TimeMap", "set", "get", "get", "set", "get", "get"};
    // тут разные типы данных, поэтому приводим к Object
    Object[][] operations1 = {{}, {"foo", "bar", 1}, {"foo", 1}, {"foo", 3}, {"foo", "bar2", 4}, {"foo", 4}, {"foo", 5}};

    // создаем объект результата для хранения выходных данных
    Object[] results = new Object[operations.length];

    // Ввводим переменную
    TimeMap timeMap = null;

    // далее пробегаемся циклом для обработки всех операция + цикл switch-case
    for (int i = 0; i < operations.length; i++) {
      switch (operations[i]) {
        case "TimeMap":
          timeMap = new TimeMap();
          results[i] = null;
          break;
        case "set":
          // "принудительное" правильное приведение и анализ входных данных - метод из TimeMap
          timeMap.set((String) operations1[i][0], (String) operations1[i][1], (int) operations1[i][2]);
          results[i] = null;
          break;
        case "get":
          // используем "принудительное" правильное приведение типов - метод из TimeMap
          results[i] = timeMap.get((String) operations1[i][0], (int) operations1[i][1]);
          break;
      }
    }

    // вывод на печать результатов
    System.out.print("[");
    for (Object result : results) {
      // System.out.println(result);
    if (result != null) {
        System.out.print(result + " ");
      } else {
        System.out.print("null ");
      }
    }
    System.out.println("]");

//    TimeMap timeMap = new TimeMap();
//    timeMap.set("foo", "bar", 1);
//    System.out.println(timeMap.get("foo", 1)); // Output: "bar"
//    System.out.println(timeMap.get("foo", 3)); // Output: "bar"
//    timeMap.set("foo", "bar2", 4);
//    System.out.println(timeMap.get("foo", 4)); // Output: "bar2"
//    System.out.println(timeMap.get("foo", 5)); // Output: "bar2"

//    TimeMap timeMap = new TimeMap();
//    // сохраняем ключ "foo" и значение "bar" вместе с меткой времени = 1
//    timeMap.set("foo", "bar", 1);
//    // возвращаем "bar"
//    timeMap.get("foo", 1);
//    // возвращает "bar", поскольку нет значения, соответствующего foo на отметке времени 3 и отметке времени 2, то единственным значением на отметке времени 1 является "bar"
//    timeMap.get("foo", 3);
//    // сохраняем ключ "foo" и значение "bar2" вместе с меткой времени = 4
//    timeMap.set("foo", "bar2", 4);
//    // возвращает "столбец 2"
//    timeMap.get("foo", 4);
//    // возвращает "столбец 2"
//    timeMap.get("foo", 5);

//    TimeMap obj = new TimeMap();
//    obj.set(key,value,timestamp);
//    String param_2 = obj.get(key,timestamp);

  }

  static class TimeMap {
    // вводим и используем карту, где каждый ключ представляет собой строку, а его значение - древовидную карту, которая связывает временные метки со значениями
    private Map<String, TreeMap<Integer, String>> keyTimeValueMap = new HashMap<>();

    /**
     * Инициализируем объект временной карты
     */
    public TimeMap() {
      // конструктору не нужно ничего инициализировать, так как хэш-карта уже инициализирована выше - т. е. тут пустой конструктор
    }

    /**
     * Метод для сохранения ключа со значением вместе с заданной временной меткой
     *
     * @param key - ключ для хранения
     * @param value - значение, связанное с ключом
     * @param timestamp - временная метка, на которую устанавливается значение для ключа
     */
    public void set(String key, String value, int timestamp) {
      // Computeifabsent вставит новую древовидную карту, если ключ еще не присутствует
      // и затем он помещает заданную временную метку и значение в древовидную карту для данного ключа,
      // где omputeIfAbsent - служит для вычисления и добавления нового значения в Map-коллекцию в том случае, если такого значения ещё нет,
      // метод работает лишь при необходимости, облегчая и эффективно заменяя использование get.
     keyTimeValueMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    /**
     * Метод для извлечения - получения значение для ключа в заданную временную метку или последнее значение, установленное перед временной меткой
     *
     * @param key - ключ для извлечения значения для
     * @param timestamp - временная метка для извлечения значения в
     * @return closestTimestamp - значение, установленное для ключа на заданную временную метку или ближайшую предыдущую временную метку
     */
    public String get(String key, int timestamp) {
      // итоак, первое условие - если ключ не существует, верните пустую строку - т. е. "",
      // где containsKey() — проверяет, существует ли указанный ключ в карте (например, HashMap или TreeMap)
      // и если ключ найден, метод возвращает true, в противном случае — false
      if (!keyTimeValueMap.containsKey(key)) {
        return "";
      }
      // тут извлекаем древовидную карту для данного ключа
      TreeMap<Integer, String> timeValueMap = keyTimeValueMap.get(key);
      // ищем далее наибольшую временную метку(ключ), меньшую или равную заданной временной метке,
      // где floorKey(K obj) возвращает самый большой ключ k, который меньше или равен ключу obj. Если такого ключа нет, возвращает null
      Integer closesTimestamp = timeValueMap.floorKey(timestamp);
      // и далее, если нет временной метки(closesTimestamp), которая была бы меньше или равна указанной временной метке, верните пустую строку
      // В противном случае верните соответствующее значение
      return closesTimestamp == null ? "" : timeValueMap.get(closesTimestamp);
    }
  }

/**
 * Your TimeMap object will be instantiated and called as such:
 * Объект TimeMap будет создан и вызван как таковой:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

}
/*
set Метод имеет временную сложность O(1) для каждой операции, поскольку он добавляет (timestamp, value) кортеж в список, соответствующий ключу в defaultdict.

Временная сложность get метода составляет O(log N) для каждой операции, где N - количество записей, связанных с конкретным ключом.
Это связано с тем, что он выполняет двоичный поиск (bisect_right), чтобы найти позицию,
в которой данное значение timestamp поместилось бы в отсортированном порядке сохраненных временных меток.

 */

