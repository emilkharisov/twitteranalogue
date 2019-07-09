<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Пользователи</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2-heading">
    Моё приложение
</div>
<form method="post" action="filter" class="form-style-2">
    <label class="form-style-2-heading">Фильтр по имени</label>
    <input class="input-field" type="text" name="firstname" placeholder="First Name" />
    <input type="submit" value="Искать"/>
</form>
<#list users as user>
    ${user.getLogin()}
    ${user.getFirstname()}
    ${user.getLastname()}
    <a href="/edit/${user.getId()}">Edit User</a>
    <br/>
</#list>

<a href="/logout">Exit</a>

</body>
</html>