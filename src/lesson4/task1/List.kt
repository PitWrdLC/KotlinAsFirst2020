@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
    when {
        y < 0 -> listOf()
        y == 0.0 -> listOf(0.0)
        else -> {
            val root = sqrt(y)
            // Результат!
            listOf(-root, root)
        }
    }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 */
fun times(a: List<Int>, b: List<Int>): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int = TODO()

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
2 */
fun accumulate(list: MutableList<Int>): MutableList<Int> = TODO()

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String = TODO()

/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int = TODO()

/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var k = n
    var time = 10
    var number = ""
    val m = "M"
    val cm = "CM"
    val d = "D"
    val cd = "CD"
    val c = "C"
    val xc = "XC"
    val l = "L"
    val xl = "XL"
    val x = "X"
    val ix = "IX"
    val v = "V"
    val iv = "IV"
    val i = "I"
    do {
        println(k)
        do {
            if (k - 1000 >= 0) {
                k = k - 1000
                number += m
                break
            }
            if (k - 900 >= 0) {
                k = k - 900
                number += cm
                break
            }
            if (k - 500 >= 0) {
                k = k - 500
                number += d
                break
            }
            if (k - 400 >= 0) {
                k = k - 400
                number += cd
                break
            }
            if (k - 100 >= 0) {
                k = k - 100
                number += c
                break
            }
            if (k - 90 >= 0) {
                k = k - 90
                number += xc
                break
            }
            if (k - 50 >= 0) {
                k = k - 50
                number += l
                break
            }
            if (k - 40 >= 0) {
                k = k - 40
                number += xl
                break
            }
            if (k - 10 >= 0) {
                k = k - 10
                number += x
                break
            }
            if (k - 9 >= 0) {
                k = k - 9
                number += ix
                break
            }
            if (k - 5 >= 0) {
                k = k - 5
                number += v
                break
            }
            if (k - 4 >= 0) {
                k = k - 4
                number += iv
                break
            }
            if (k - 1 >= 0) {
                k = k - 1
                number += i
                break
            }
            if (k == 0) {
                break
            }

        } while (k > 0)

    } while (k > 0)
    println("$number FINALY")
    return number
}
/*  // padEnd это привелегия char?

*/

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String { // интегрирую числа 10-19 и готово( ну и пробел подумаю как настроить нормально)
    var number: String = ""
    var k = n
    var tisacha = 1
    var ost = 0
    println(" this is $k")
if (n>999) {
    ost = 9000
}
    if (n > 999) tisacha = 1000

    repeat(2){ // хотел через двойной while-do как в прошлом примере но чет не зашло
        if (k / (100 * tisacha) > 0) {
            when (k / (100 * tisacha)) {
                9 -> number += "девятьсот "
                8 -> number += "восемьсот "
                7 -> number += "семьсот "
                6 -> number += "шестьсот "
                5 -> number += "пятьсот "
                4 -> number += "четыреста "
                3 -> number += "триста "
                2 -> number += "двести "
                1 -> number += "сто "
                0 -> number += ""
            }
            k -= (k / (100 * tisacha)) * (100 * tisacha)
        }
        if ((k / (1 * tisacha) >= 10) && (k / (1 * tisacha) < 20)) {
            when (k / (1 * tisacha)) {
                10 -> number += "десять "
                11 -> number += "одиннадцать "
                12 -> number += "двенадцать "
                13 -> number += "тринадцать "
                14 -> number += "четырнадцать "
                15 -> number += "пятнадцать "
                16 -> number += "шестнадцать "
                17 -> number += "семьнадцать "
                18 -> number += "восемьнадцать "
                19 -> number += "девятнадцать "
            }
            k -= (k / (1 * tisacha)) * (1 * tisacha)
            if (n>999) ost = 9000
        }


        if (k / (10 * tisacha) > 1) {
            when (k / (10 * tisacha)) {
                9 -> number += "девяносто "
                8 -> number += "весемьдесят "
                7 -> number += "семьдесят "
                6 -> number += "шестьдесят "
                5 -> number += "пятьдесят "
                4 -> number += "сорок "
                3 -> number += "тридцать "
                2 -> number += "двадцать "
                1 -> number += "десять "
                0 -> number += ""
            }
            k -= (k / (10 * tisacha)) * (10 * tisacha)
        }
        if (k / (1 * tisacha) > 0) {
            if ((k / 1000 == 2) || (k / 1000 == 1)) {
                ost = (k / 1000) * 1000
                println(" 1  $k")
                when (k / 1000) {
                    1 -> number += "одна "
                    2 -> number += "две "
                }
                k -= (k / 1000) * 1000
            } else {
                ost = (k / 1000) * 1000
                when (k / (1 * tisacha)) {
                    9 -> number += "девять "
                    8 -> number += "восемь "
                    7 -> number += "семь "
                    6 -> number += "шесть "
                    5 -> number += "пять "
                    4 -> number += "четыре "
                    3 -> number += "три "
                    2 -> number += "два "
                    1 -> number += "один "
                    0 -> number += ""
                }
                k -= (k / (1 * tisacha)) * (1 * tisacha)
            }
        }
        if (ost > 999) {
            tisacha = 1
            when (ost) {
                1000 -> number += "тысяча "
                2000 -> number += "тысячи "
                3000 -> number += "тысячи "
                4000 -> number += "тысячи "
                5000 -> number += "тысяч "
                6000 -> number += "тысяч "
                7000 -> number += "тысяч "
                8000 -> number += "тысяч "
                9000 -> number += "тысяч "

            }
            ost = 0
        }
        tisacha = 1
    }
println("number $number")

    return number.removeSuffix(" ").removePrefix(" ")
}


