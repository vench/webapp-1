Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 3

### Работа со строками. Массивы.
  - Блоки инициализации
  - InstanceOf. valueOf
  - <a href="http://easy-code.ru/lesson/java-string">Строки в Java</a>. Кодировка.
  - <a href="http://easy-code.ru/lesson/manipulating-characters-string-java">Управление строками, функции для работы со строками в Java.</a> StringBuilder vs StringBuffer
  - <a href="http://java67.blogspot.ru/2014/08/difference-between-string-literal-and-new-String-object-Java.html">String literal pool</a>
  - <a href="http://habrahabr.ru/post/132241/">Маленькие хитрости Java. </a>
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27121">Массивы.</a>
  - DAO. Интерфейс для хранения резюме.

### ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW03
Реализовать IStorage на основе массива (ArrayStorage в проекте)
В реализации проверять корректность опрерации: при load/delete/update резюме должно присутствовать в массиве, при save- отсутствовать.

### Optional: оценить <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNEJWRFJkVDA3TkU">Time complexity</a> реализации.
Сделать реализацию ArrayStorage с time complexity: O(log N)
