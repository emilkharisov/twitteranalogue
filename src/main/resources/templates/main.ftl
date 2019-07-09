<!DOCTYPE HTML>
<html lang="ru" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Чат</title>
    <meta name="description" content="Описание страницы" />
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2-heading">${user.getFirstname()}</div>
<div class="form-style-2-heading">${user.getLastname()}</div>
<#if error??>
    <label class="form-style-2">Error , Field(s) is\are empty</label>
</#if>
<form action="/" method="post" enctype="multipart/form-data" class="form-style-2">
    <label for="login">Сообщения
        <input class="input-field" type="text" id="text" name="text">
    </label>
    <input type="file" name="file">
    <br>
    <input type="submit" Добавить сообщение>
</form>
<#list message as mess>
    ${mess.getId()}
    ${mess.getText()}
    <strong>${mess.getAuthor().getLogin()}</strong>
    <#if mess.filename??>
        <br>
        <img src="/img/${mess.filename}">
    </#if>
    <br>
</#list>

<a href="/logout">Выйти</a>
</body>
</html>