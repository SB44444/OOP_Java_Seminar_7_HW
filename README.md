**Семинар 5. ООП Java**
*Урок 5. От простого к практике*
*Задача:*
1. **Доработать справочник пользователей, для удаления. Поработать над проектом.(не обязательно, желательно для java-разработчиков)
Сделать сохранение в другом формате, например, не через запятую, а через точку с запятой, и разделителем - пустой строкой. Предусмотреть сохранение в старом формате. На ваше усмотрение (по вкусу), но что - то изменить надо.
Попробуйте создать систему логирования.
ИЛИ ВНЕСИТЕ СВОИ ИЗМЕНЕНИЯ В ПРОЕКТ, КОТОРЫЕ КАЖУТЬСЯ ЛОГИЧНЫМИ ВАМ.
2. ****Создать калькулятор для работы с рациональными и комплексными числами, организовать меню, добавив в него систему логирования

**  Комментарии к работе: **
  Переделана структура проекта в схеме: Model - Controller - View. Перенесены классы в пакеты, соответствующие их 
назначениям. Реализован метод удаления контакта по id

**Семинар 6. ООП Java**
*Урок 6. ООП Дизайн и Solid*
1. Подумать и исправить те принципы SOLID которые нарушены в пакете homework.
   Рефакторинг и\или оптимизация проекта предыдущего дз с учетом теоретических основ SOLID’а
2. Необязательные: ** По желанию сделать Figure из srp1 абстрактным классом и продумать его структуру, 
                   ** Saver из srp2 параметризовать, чтобы работал с любыми объектами

**Комментарии к работе:**
  В проекте Нарушены принцип одной задачи для одного класса или метода. В Main запускались методы и конструкторы.
Для этой задачи создан вспомогательный класс AvtoRun в который переданы функции запуска. Добавлен астрактный класс 
и класс enum для возможности работы с раными типами данных

**Семинар 7. ООП Java**
*Урок 7. ООП Дизайн и Solid*
1. Дописать проект, "Записная книжка", содержащий работу с записками из консоли (можно прочитать все записки, создать одну записку, отредактировать записку, удалить, и прочитать одну записку по ID), записка содержит в себе как минимум 3 поля Id, заголовок и текст, можно добавить дату. Хранение по вашему выбору, можно в текстовом файле (или каждая записка в одном файле, как вам удобнее). Можно сделать по аналогии с программой из 5 урока. Если вы сделали записки к этому уроку, то добавить логирование. Продумать, какие паттерны можно использовать в вашем проекте.

**  Комментарии к работе: **
   Cтруктура проекта сохранена в схеме: Model - Controller - View.
 В соответствии с принципами SOLID разделены задачи для классов: - один класс - одна зона ответственности. Классы наследники не меняют повдение классов родителей. Для этого созданы абстрактные классы. Данная структура подволяет добавлять функционал проекта не изменяя поведенее ранее созданных классов и методов


