# hw-11
Задание 1

Напишите программу, которая каждую секунду отображает на экране данные о времени, прошедшем от начала сессии (запуска программы). 
Другой ее поток выводит каждые 5 секунд сообщение  "Прошло 5 секунд". Предусмотрите возможность ежесекундного оповещения потока, воспроизводящего сообщение, потоком, отсчитывающим время. 

Задание 2
Напишите программу, которая выводит в консоль строку, состоящую из чисел от  1 до n, но с заменой некоторых значений:
если число делится на 3 - вывести "fizz"
если число делится на 5 - вывести "buzz"
если число делится на 3 и на 5 - вывести "fizzbuzz"
Например, для n = 15, ожидаемый результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
Программа должна быть многопоточной, работать с 4 потоками:
Поток A вызывает fizz() чтобы проверить делимость на 3 и вывести fizz.
Поток B вызываетbuzz() чтобы проверить делимость на 5 и вывестиbuzz.
Поток C вызываетfizzbuzz() чтобы проверить делимость на 3 и 5 и вывести fizzbuzz.
Поток D вызывает number() чтобы вывести число.
