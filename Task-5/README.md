# Задача 5
**Решение содержит ненормативную лексику в демонстрационных целях**

[Repl.It](https://repl.it/@ArthurKhazbs/WinterJavaTask-5)

В текстовом файле слова могут быть разделены одним или несколькими пробелами или символами перевода строки. Необходимо реализовать программу, считающую количество слов в файле и выводящую результат на экран. Путь к файлу задается первым аргументом командной строки (args[0]).

Пример:

```text
Небольшой стартап разрабатывает социальный сервис, в котором пользователи могут оставлять комментарии. Со временем в комментариях появился спам и разработчики решили бороться с ним с помощью "черных списков" запрещенных слов. Они составили такие списки и поручили вам написать функцию, удаляющую из всех накопленных комментариев нежелательные.

Они предоставили вам интерфейс, который внедрили в свой продукт, и попросили написать его реализацию:

import java.util.List;
import java.util.Set;

public interface BlackListFilter {

  /**
   * From the given list of comments removes ones 
   * that contain words from the black list.
   * 
   * @param comments list of comments; every comment 
   *                 is a sequence of words, separated 
   *                 by spaces or line breaks   
   * @param blackList list of words that should not 
   *                  be present in a comment
   */
  void filterComments(List<String> comments, Set<String> blackList);
}

Реализуйте интерфейс BlackListFilter.
```
