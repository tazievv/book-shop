<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${customer.firstName}</title>
</head>
<body>
    <h3>${customer.lastName}</h3>
    <h3>${customer.firstName}</h3>
<br>
<form method="post" action="/customers/${customer.id}/update">
    <label>
        Имя: <input name="firstName" value="${customer.firstName}">
    </label>
    <label>
        Фамилия: <input name="lastName" value="${customer.lastName}">
    </label>
    <label>
        Email: <input name="email" value="${customer.email}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
    <h1>
        <a href="/catalog_of_books/${customer.id}">Каталог</a>
    </h1>

</body>
</html>