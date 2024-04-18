package simulation;

/**
 * _1275_Find_Winner_on_a_Tic_Tac_Toe_Game_.
 *
 * @author Anton Shatkovskiy
 * @created 18.04.2024 г.
 */

/*

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli].
return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.

Constraints:

1 <= moves.length <= 9
moves[i].length == 2
0 <= rowi, coli <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.

ПЕРЕВОД: 1275. Найдите победителя в игре в крестики-нолики.
В крестики-нолики играют два игрока А и В на сетке размером 3 х 3. Правила игры в крестики-нолики таковы::

Игроки по очереди расставляют символы на пустые квадраты.
Первый игрок A всегда ставит символы "X", в то время как второй игрок B всегда ставит символы "O".
Символы "X" и "O" всегда ставятся на пустые квадраты, но никогда на заполненные.
Игра заканчивается, когда три одинаковых (непустых) символа заполняют любую строку, столбец или диагональ.
Игра также заканчивается, если все клетки не пусты.
По окончании игры больше ходов быть не может.
Задан двумерный целочисленный массив ходов, где ходы[i] = [rowi, coli] указывают на то, что i-й ход будет сыгран по сетке[rowi][coli].
верните победителя игры, если он существует (A или B). В случае, если игра закончится вничью, верните "Ничья". Если в игре еще есть ходы, верните "В ожидании".

Вы можете предположить, что ходы допустимы (то есть соответствуют правилам игры в крестики-нолики), сетка изначально пуста, и A сыграет первым.

Пример 1:

Ввод: ходы = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Вывод: "А"
Пояснение: А выигрывает, он всегда играет первым.

Пример 2:

Ввод: ходы = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Вывод: "В"
Пояснение: В выигрывает.

Пример 3:

Ввод: ходы = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Вывод: "Ничья"
Пояснение: Игра заканчивается вничью, так как больше не нужно делать ходов.

Ограничения:

1 <= ходов.длина <= 9
ходов[i].длина == 2
0 <= rowi, coli <= 2
В ходах нет повторяющихся элементов.
ходы выполняются по правилам игры в крестики-нолики.

 */

public class _1275_Find_Winner_on_a_Tic_Tac_Toe_Game_ {

  public static void main(String[] args) {

//    String[][] moves = {[0, 0], [2, 0], [1, 1], [2, 1], [2, 2]};
//
//    Solution1275 solution1275 = new Solution1275();
//    System.out.println(solution1275.tictactoe(moves));


  }

  static class Solution1275 {
    public String tictactoe(int[][] moves) {

      return null;

    }
  }



}
