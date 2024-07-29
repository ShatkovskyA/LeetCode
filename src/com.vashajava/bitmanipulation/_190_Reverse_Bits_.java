package com.vashajava.bitmanipulation;

/**
 * _190_Reverse_Bits_.
 *
 * @author Anton Shatkovskiy
 * @created 24.07.2024 г.
 */

/*
Reverse bits of a given 32 bits unsigned integer.

Note:

Note that in some languages, such as Java, there is no unsigned integer type.
In this case, both input and output will be given as a signed integer type.
They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation.
Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.

Example 1:

Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
so return 3221225471 which its binary representation is 10111111111111111111111111111111.

Constraints:

The input must be a binary string of length 32

Follow up: If this function is called many times, how would you optimize it?

ПЕРЕВОД: 190. Реверс битов.
Обратные биты заданного 32-битного целого числа без знака.

Примечание:

Обратите внимание, что в некоторых языках, таких как Java, нет целочисленного типа без знака.
В этом случае как входные, так и выходные данные будут представлены в виде целого типа со знаком.
Они не должны влиять на вашу реализацию, поскольку внутреннее двоичное представление целого числа одинаково,
независимо от того, является ли оно знаковым или беззнаковым.
В Java компилятор представляет целые числа со знаком, используя дополнительную нотацию 2.
Таким образом, в примере 2, приведенном выше, входные данные представляют целое число со знаком -3,
а выходные данные представляют целое число со знаком -1073741825.

Пример 1:

Ввод: n = 00000010100101000001111010011100
Выходные данные: 964176192 (0011100101111100000101001000000)
Пояснение: Входная двоичная строка 000000101001010000011110100011100 представляет собой целое число без знака 43261596,
поэтому возвращаем значение 964176192, которое в двоичном формате равно 001110010111100000101001000000.
Пример 2:

Ввод: n = 11111111111111111111111111111111101
Выходные данные: 3221225471 (10111111111111111111111111111111111)
Объяснение: входной двоичной строкой 11111111111111111111111111111101 представляет собой целое число без знака 4294967293,
чтобы вернуть 3221225471 что его двоичное представление 10111111111111111111111111111111.

Ограничения:

Входные данные должны представлять собой двоичную строку длиной 32

Продолжение: Если эта функция вызывается много раз, как бы вы ее оптимизировали?
 */
public class _190_Reverse_Bits_ {

  public static void main(String[] args) {

    int n = 00000010100101000001111010011100;

    Solution190 solution190 = new Solution190();
    int  reverseBits = solution190.reverseBits(n);
    System.out.println(reverseBits);
  }

  static public class Solution190 {
    // нужно рассматривать n как значение без знака
    public int reverseBits(int n) {

      return 0;

    }
  }

}
