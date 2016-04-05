Практика Java. Разработка Web приложения.
===============================

## Проект: https://github.com/JavaWebinar/webapp

## Урок 3

### Работа со строками. Массивы.
  - <a href="http://easy-code.ru/lesson/java-string">Строки в Java</a>. Кодировка.
  - <a href="http://easy-code.ru/lesson/manipulating-characters-string-java">Управление строками, функции для работы со строками в Java.</a>
  - <a href="http://java67.blogspot.ru/2014/08/difference-between-string-literal-and-new-String-object-Java.html">String literal pool</a>
  - <a href="http://habrahabr.ru/post/132241/">Маленькие хитрости Java</a>: valueOf, StringBuilder vs StringBuffer
  - <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27121">Массивы.</a>
  -  <a href="https://ru.wikipedia.org/wiki/Data_Access_Object">Data Access Object</a>. Интерфейс для хранения резюме.

### ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW03
  - Добавить в резюме `OrganizationSection` (в `MainArrayStorage`)
  - Реализовать `Storage` на основе массива (`ArrayStorageImpl` в проекте)
  - Сделать несколько вызовов `Storage` из `MainArrayStorage`

### Optional: оценить <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNEJWRFJkVDA3TkU">Time complexity</a> реализации.
  - Сделать реализацию `SortedArrayStorageImpl` с time complexity: O(log N)
    -  <a href="https://drive.google.com/file/d/0B9Ye2auQ_NsFNEJWRFJkVDA3TkU/view">Time complexity</a>
    -  <a href="https://ru.wikipedia.org/wiki/Временная_сложность_алгоритма">Временная сложность алгоритма</a>
    -  <a href="https://ru.wikipedia.org/wiki/Вычислительная_сложность">Вычислительная сложность</a>

  - Попробовать выделить общую часть `ArrayStorageImpl` и `SortedArrayStorageImpl` в `AbstractArrayStorageImpl`
    - <a href="https://ru.wikipedia.org/wiki/Шаблонный_метод_(шаблон_проектирования)">Шаблонный метод (шаблон проектирования)</a>
    - <a href="http://pro-prof.com/archives/1108">Паттерн шаблонный метод (template method)</a>
