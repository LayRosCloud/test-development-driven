# Test Development Driven 
Разработка через тестирование

### Что гласит данный подход?

Данный подход говорит, о том, что необходимо сначало написать тест о коде, который ты как-либо себе представляешь, а 
потом уже реализовать сам код. Преимущества данного подхода:
- Уверенность в собственном коде
- Разработка чистых методов, ибо их постоянно надо тестировать
- "Регулировка скорости разработки" - пока не совсем понятно, что это значит
- Другим программистом становится более ясно, как использовать наш код

Из явных недостатков стоит отметить:

- Не совсем ясно, когда стоит остановиться тестировать, ибо тестировать те же конструкторы не совсем хорошая мысль.
- Не совсем ясно, как правильно тестировать некоторые интерфейсы, через такую методику и как тестировать REST API.
### Методика изучается по книге Кента Бека "Экстремальное программирование"
> Чистый код, который работает (с. Рон Джеффриз)

Автор так же говорит, что TDD состоит из нескольких шагов:
1. Написать тест
2. Запустить все тесты и убедиться, что все тесты компилируются
3. Внести небольшие изменения
4. Снова запустить все тесты и убедиться, что все они успешно выполняются
5. Устранить дублирование с помощью рефакторинга (именно на этом шаге достигается красивый и чистый код без всякого дублирования)

Проект содержит в себе конвертор валют.

