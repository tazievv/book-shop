<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Список покупателей</title>
</head>
<body>
<h4>Добавление пользователей</h4>
<form method="post" action="/customers/add">
    <label>Имя:
        <input name="firstName" placeholder="имя">
    </label>
    <label>Фамилия:
        <input name="lastName" placeholder="фамилия">
    </label>
    <input type="submit" value="Добавить">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>
    <#list customers as customer>
        <tr>
            <td>${customer.id}</td>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>
                <form method="post" action="/customers/${customer.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/customers/${customer.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>