
## qa_guru_at_final_project

![Intelij_IDEA](src/test/resources/img/icons/Intelij_IDEA.png)![Java](src/test/resources/img/icons/Java.png)![Selenide](src/test/resources/img/icons/Selenide.png)![Selenoid](src/test/resources/img/icons/Selenoid.png)![Gradle](src/test/resources/img/icons/Gradle.png)![JUnit5](src/test/resources/img/icons/JUnit5.png)![Allure Report](src/test/resources/img/icons/Allure_Report.png)![AllureTestOps](src/test/resources/img/icons/AllureTestOps.png)![Github](src/test/resources/img/icons/Github.png)![Jenkins](src/test/resources/img/icons/Jenkins.png)![Rest-Assured](src/test/resources/img/icons/Rest-Assured.png)![Telegram](src/test/resources/img/icons/Telegram.png)![Jira](src/test/resources/img/icons/Jira.png)

Реализованы проверки:

## UI Автотесты на https://vprok.ru/

UI

    "Отображение 'Товар недели' на главной странице"
    "Отображение 'Суперцены недели' на главной странице"
    "Проверка ссылки 'Упаковкой дешевле'"
    "Проверка что в заголовках блока зоотовары есть корма для животных"
    "Проверка подзаголовка в категории 'Зоотовары'"
    "Проверка поиска по продукту 'молоко'"
    "Проверка отправки смс кода при регистрации нового клиетна"



## API  Автотесты на https://reqres.in/

API

    "Создание нового пользователя"
    "Запрос пользовательских данных"
    "Проверка ответа в блоке support.Url"
    "Неуспешное создание нового пользователя(негативный)"
    "Успешное создание нового пользователя(негативный)"

### Запуск тестов

Локальный запуск:

    gradle clean test

Локальный запуск с количественным параметром запускаемых потоков:

    gradle clean test -Dthreads=5

Удаленный запуск тестов:

    gradle clean test -Ddriver=remote


Запуск тестов через джобу в [Jenkins](https://jenkins.autotests.cloud/job/24_subu_vprok/build?delay=0sec)

### Параметры используемые при запуске тестов:
![JENKINS_PARAMS](src/test/resources/img/Jenkins_params.PNG)

### Статистика запусков:

![JENKINS_LAUNCH](src/test/resources/img/JENKINS_LAUNCH.PNG)

### Отчёт в Allure Report
![Allure](src/test/resources/img/allure_report.PNG)

### Интеграция [Allure Test Ops](https://allure.autotests.cloud/project/627/dashboards) с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-250)  :

![JIRA](src/test/resources/img/jira_integration.PNG)

### Хранение тест-кейсов в Allure TestOps
Дашборд
![Allure](src/test/resources/img/main_dashboard.PNG)
Дашборд по видам тестов
![Allure](src/test/resources/img/personal_dashboards.PNG)
Запуски
![Allure](src/test/resources/img/launches.PNG)
Результат запуска 
![Allure](src/test/resources/img/launch_results.PNG)
Тест-кейсы
![Allure](src/test/resources/img/tests.PNG)


### Уведомления о завершении прогона автоетстов в Telegram
![Telegram](src/test/resources/img/tgbot.PNG)