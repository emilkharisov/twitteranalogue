<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Изменение пользователя</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2-heading">
    Изменение пользователя
</div>
<form method="post" action="/edit" class="form-style-2">
    <input type="hidden" name="userId" value="${user.getId()}">
    <input type="text" name="login" value="${user.getLogin()}">
    <#list roles as role>
        <label><input type="checkbox" name="${role}" <#if role==user.role>checked <#else>""</#if>>${role}</label>
        <br>
    </#list>
    <input type="submit" Изменить>
</form>
</body>
</html>