# Задача 4*
[Repl.It](https://repl.it/@ArthurKhazbs/WinterJavaTask-4X)

В текстах программ на Java могут использоваться многострочные (/\* ... \*/) и однострочные (// ...) комментарии. Реализовать программу, вырезающую из файла с исходным текстом все комментарии и печатающую результат на экран. Путь к файлу задается первым аргументом командной строки (args\[0\]).

Пример:

\[in\]
/\*
 \* My first ever program in Java!
 \*/
class Hello { // class body starts here 
  
  /\* main method \*/
  public static void main(String[] args/\* we put command line arguments here\*/) {
    // this line prints my first greeting to the screen
    System.out.println("Hi!"); // :)
  }
} // the end
// to be continued...

\[out\]

class Hello {  
  
  
  public static void main(String[] args) {
    
    System.out.println("Hi!"); 
  }
} 

