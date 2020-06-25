# language: ru
@pastebin_advanced
Функция: Создание нового поста на Pastebin посложнее
  Должен создаться сниппет кода с переданными значениями

  Предыстория:
    Допустим пользователь открывает страницу браузера и открывает сайт Pastebin
    И страница успешно открылась

  @success
  Структура сценария: Успешное создание сниппета
    Если ввести код <code>
    И выбрать синтаксис <syntax>
    И ввести время существования сниппета кода
    И ввести название сниппета кода <title>
    И нажать кнопку создать
    То название страницы сответствует <title> синтаксис соответствует <syntax> и код соответствует <code>
    Примеры:
    |code|syntax|title|
    |"git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force"|"Bash"|"how to gain dominance among developers"|
