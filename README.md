# clevertec
Приложение можно запустить через 2 runner класса:RunnerWriteInFile и RunnerWriteInConsol

RunnerWriteInFile - передача данных происходит через консоль. Например клиент набирает:3-1 2-5 5-1 card-1234,
где card-1234 - это номер скидочной карты, а цифры это передаёт id товара и количество единиц. И чек записывается в файл
 check.txt.
 
RunnerWriteInConsol - отличается от RunnerWriteInFile тем, что вывод чека идёт в консоль и тем, что имя файла передаётся
в аргументах public static void main, как один из элементов массива args.

Rounding - создан чтобы можно умножать условный рубль(byn) на double(например на процент) и возможность округлить 
полученный результат к "потолку" или "полу". 