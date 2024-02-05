Для возможности удаленной отладки при запуске с помощью Maven 
нужно в папке проекта создать каталог .mvn и добавить в него файл
конфигурации jvm.config (<проект>/.mvn/jvm.config) со следующим значением:

-Xdebug -Xrunjdwp:transport=dt_sock

### Пользователи для входа на сайт

|  login  | password |
|:-------:|:--------:|
|  admin  |    1     |
| client1 |    1     |
| client2 |    1     |

### Запуск

```cmd
mvn jetty:run
```
