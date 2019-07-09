<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2-heading">
    Login
</div>
<#if error??>
    <label>Error</label>
</#if>
<form method="post" action="/login" class="form-style-2">
    <label for="login">Логин
        <input class="input-field" type="text" id="login" name="login">
    </label>
    <br>
    <label for="password">Пароль
        <input class="input-field" type="password" id="password" name="password">
    </label>
    <br>
    <label for="remember-me">
        <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
    <input type="submit" value="Login">
</form>

</body>
</html>