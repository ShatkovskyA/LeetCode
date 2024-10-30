package com.vashajava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * _721_Accounts_Merge_.
 *
 * @author Anton Shatkovskiy
 * @created 10.10.2024 г.
 */

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts.
Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name,
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
Example 2:

Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

Constraints:

1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j].length <= 30
accounts[i][0] consists of English letters.
accounts[i][j] (for j > 0) is a valid email.

ПЕРЕВОД: 721. Слияние учетных записей.
Дан список учетных записей, где каждый элемент accounts[i] представляет собой список строк,
где первый элемент accounts[i][0] - это имя, а остальные элементы - это электронные письма, представляющие электронные письма учетной записи.

Теперь мы хотели бы объединить эти учетные записи. Два аккаунта определенно принадлежат одному и тому же человеку,
если у обоих аккаунтов есть общий адрес электронной почты.
Обратите внимание, что даже если два аккаунта имеют одинаковое имя, они могут принадлежать разным людям, поскольку у людей могут быть одинаковые имена.
Изначально у человека может быть любое количество учетных записей, но все их учетные записи определенно имеют одно и то же имя.

После объединения учетных записей верните учетные записи в следующем формате: первым элементом каждой учетной записи является имя,
а остальные элементы - электронные письма в отсортированном порядке. Сами учетные записи могут быть возвращены в любом порядке.

Пример 1:

Входные данные: счета = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Результат: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Объяснение:
Первый и второй Джон - одно и то же лицо, поскольку у них общий адрес электронной почты "johnsmith@mail.com".
Третий Джон и Мэри - разные люди, поскольку ни один из их адресов электронной почты не используется другими учетными записями.
Мы могли бы вернуть эти списки в любом порядке, например, все равно был бы принят ответ [["Мэри", "mary@mail.com"], ["Джон", "johnnybravo@mail.com"],
["Джон", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"].
Пример 2:

Ввод: учетные записи = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Ханзо","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Ферн","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
Выходные данные: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Папоротник","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

Ограничения:

1 <= учетные записи.длина <= 1000
2 <= учетные записи[i].длина <= 10
1 <= учетные записи[i][j].длина <= 30
учетных записей[i][0] состоит из букв английского алфавита.
учетные записи[i][j] (если j > 0) - это действительный адрес электронной почты.
 */
public class _721_Accounts_Merge_ {

  public static void main(String[] args) {

    List<List<String>> accounts1 = new ArrayList<>();
    accounts1.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    accounts1.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    accounts1.add(Arrays.asList("Mary", "mary@mail.com"));
    accounts1.add(Arrays.asList("John", "johnnybravo@mail.com"));

    Solution721 solution721 = new Solution721();

    List<List<String>> merged1 = solution721.accountsMerge(accounts1);
    for (List<String> account : merged1) {
      System.out.println(account);
    }
  }

  // объединение непересекающихся множеств (DSU), который представляет собой структуру данных,
  // отслеживающую набор элементов, разделенных на несколько непересекающихся подмножеств
  static class Solution721 {
    // создаем и инициализируем родительский массив для хранения родительского индекса каждого непересекающегося набора (объединение-поиск)
    private int[] parent;

    // тут создаем функцию / метод для поиска непересекающегося родительского элемента узла
    private int find(int x) {
      // если родительский корневой узел x не равен узлу x, то
      if (parent[x] != x) {
        // сжатие пути - прямое присоединение узла x к его корневому родительскому узлу
        parent[x] = find(parent[x]);
      }
      // возвращаем родительский узел x
      return parent[x];
    }

    // основной метод / способ объединения учетных записей
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      // сначала заданем необходимые локальные перменные
      // переменная для подсчета количества элементов,
      // где size() - это стандартный "заводской" библиотечный метод для подсчета количества элементов в массиве
      int n = accounts.size();
      // к родительскому массиву это количество элементов
      parent = new int[n];

      // инициализируем родительский массив, в котором каждый узел является его собственным родительским элементом
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }

      // следующий этап - создаем и инициализируем карту для хранения индекса учетной записи для уникального электронного письма
      Map<String, Integer> emailToIndex = new HashMap<>();
      // пробегаемся по учетным записям, для того, чтобы найти и объединить электронные письма
      for(int i = 0; i < n; i++) {
        // тут получаем аккаунт
        List<String> currentAccount = accounts.get(i);
        for(int j = 1; j < currentAccount.size(); j++) {
          // тут находим емайл
          String email = currentAccount.get(j);
          // где containsKey() — определяет, существует ли определённый ключ в карте, а emailToIndex - объект HashMap
          // итак, если email принадлежит или же объект emailToIndex, то
          if(emailToIndex.containsKey(email)) {
            // выполняем операцию объединения, установив родительский параметр
            // т. е. текущий узел опять же находим в родительском массив и приравниваем его к индексу учетный записи, где по нему получаем емайл
            parent[find(i)] = find(emailToIndex.get(email));
          } else {
            // а если электронное письмо уникально, сопоставьте его с индексом текущего аккаунта, т. е. заносим в emailToIndex - объект HashMap
            emailToIndex.put(email, i);
          }
        }
      }

      // теперь создаем карту для объединения электронных писем, принадлежащих одному владельцу
      Map<Integer, Set<String>> mergedAccounts = new HashMap<>();
      // опять пробегаемся циклами
      for(int i = 0; i < n; i++ ) {
        for(int j = 1; j < accounts.get(i).size(); j++) {
          String email = accounts.get(i).get(j);
          // находим корень набора и добавляем адрес электронной почты - создаем новую переменную root + метод поиска
          int root = find(i);
          // и опять, если root не mergedAccounts,
          if(!mergedAccounts.containsKey(root)) {
            // то добавляем в mergedAccounts, с созданием нового дерева
            mergedAccounts.put(root, new TreeSet<String>());
          }
          // тут получаем корень и добавляем емайл
          mergedAccounts.get(root).add(email);
        }
      }
      // преобразуем наборы электронных писем обратно в требуемый выходной формат - создаем для этого переменну юresult
      List<List<String>> result = new ArrayList();
      // опять пробегаемся упрощенным циклом,
      // где keySet() - возвращает заданное представление всех ключей, присутствующих в mergedAccounts
      for(Integer i : mergedAccounts.keySet()) {
        // задаем перемнную для аккаунтов
        List<String> account = new ArrayList<>();
        // добавляем имя учетной записи
        account.add(accounts.get(i).get(0));
        // добавляем все объединенные электронные письма
        account.addAll(mergedAccounts.get(i));
        // и далее все добавляем в окончательный результат
        result.add(account);
      }
      // возвращаем окончательный результат
      return result;
    }
  }
}

/*
Временная сложность кода в первую очередь определяется следующими факторами:

Итерация для каждой учетной записи и электронного письма для построения email_id сопоставления и выполнения операций объединения: это O(N * K),
где N - количество учетных записей, а K - среднее количество электронных писем на учетную запись.

Сжатие пути в find функции помогает поддерживать операции поиска объединения практически постоянными по времени,
в худшем случае с амортизированной сложностью O(α(N)), где α - обратная функция Аккермана, которая растет очень медленно.

Повторный перебор каждой учетной записи и выполнение операций поиска для каждого электронного письма для построения mp сопоставления:
это также требует O(N * K) времени, поскольку мы выполняем операции с постоянным временем для каждого электронного письма.

Сортировка списков электронной почты: В худшем случае, если все электронные письма попадают в один набор,
временные трудности будут равны O(E log E), где E - общее количество электронных писем во всех учетных записях.

Объединение имен с отсортированными электронными письмами: это можно рассматривать,
O(E) поскольку оно линейно зависит от количества электронных писем.

Таким образом, общая временная сложность будет O(N * K + E log E).
 */
