
## qa_guru_at_final_project

![Intelij_IDEA](/img/icons/Intelij_IDEA.png)![Java](/img/icons/Java.png)![Selenide](/img/icons/Selenide.png)![Selenoid](/img/icons/Selenoid.png)![Gradle](/img/icons/Gradle.png)![JUnit5](/img/icons/JUnit5.png)![Allure Report](/img/icons/Allure_Report.png)![AllureTestOps](/img/icons/AllureTestOps.png)![Github](/img/icons/Github.png)![Jenkins](/img/icons/Jenkins.png)![Rest-Assured](/img/icons/Rest-Assured.png)![Telegram](/img/icons/Telegram.png)![Jira](/img/icons/Jira.png)

Реализованы проверки:

## UI Автотесты на https://vprok.ru/

UI

    Отображение 'Товар недели' на главной странице
    Отображение 'Суперцены недели' на главной странице
    Проверка ссылки 'Упаковкой дешевле'
    Проверка что в заголовках блока зоотовары есть подзаголовок 'лакомства для кошек'
    Проверка подзаголовка в категории 'Зоотовары'
    Проверка поиска по продукту 'молоко'
    Проверка отправки смс кода при регистрации нового клиента
    Проверка фильтрации в категории  'Чай, кофе, сахар'
    Положить товар в козину



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
![JENKINS_PARAMS](/img/Jenkins_params.PNG)

### Статистика запусков:

![JENKINS_LAUNCH](/img/JENKINS_LAUNCH.PNG)

### Отчёт в Allure Report
![Allure](/img/allure_report.PNG)

### Интеграция [Allure Test Ops](https://allure.autotests.cloud/project/627/dashboards) с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-250)  :

![JIRA](/img/jira_integration.PNG)

### Хранение тест-кейсов в Allure TestOps
Дашборд

![Allure](/img/main_dashboard.PNG)
Дашборд по видам тестов

![Allure](/img/personal_dashboards.PNG)
Запуски

![Allure](/img/launches.PNG)
Результат запуска

![Allure](/img/launch_results.PNG)
Тест-кейсы

![Allure](/img/tests.PNG)

### Видео о прохождении тестов
![Selenoid](/img/381ea424ae9fd94501a1efc8ceff696b(1).gif)

### Уведомления о завершении прогона автотестов в Telegram
![Telegram](img/tgbot.PNG)