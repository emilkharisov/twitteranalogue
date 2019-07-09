<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2-heading">
    Моё приложение
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Зарегистрируйтесь!
    </div>
    <#if error??>
        <label class="form-style-2">Error , Field(s) is\are empty</label>
    </#if>
    <form method="post" action="/signUp">
        <label for="login" >Логин
            <input  class="input-field" style="margin-left: 40px" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" style="margin-left: 30px" type="password" id="password" name="password">
        </label>
        <br>
        <label for="first-name">Имя
            <input class="input-field" style="margin-left: 50px" id="first-name" name="firstName">
        </label>
        <br>
        <label for="last-name">Фамилия
            <input class="input-field" style="margin-left: 20px"  id="last-name" name="lastName">
        </label>
        <br>
        <label for="telephone1">Телефон
            <input class="input-field" style="margin-left: 20px"  id="telephone1" name="telephone">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
        </label>
        <input type="submit" value="SignUp">
        <br>
    </form>
</div>
</body>
</html>