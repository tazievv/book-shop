<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Каталог</title>
</head>
<body>
    <tr>
        <th>${customer.firstName}</th>
        <th>${customer.lastName}</th>
    </tr>
    <table>
        <tr>
            <th>Название книги</th>
            <th>Автор</th>
            <th>Цена</th>
        </tr>
        <h3>Корзина</h3>
        <#list booksOnCustomer as book>
            <tr>
                <td>${book.name}</td>
                <td>${book.authorName}</td>
                <td>${book.cost}</td>
                <td></td>
            </tr>
        </#list>
    </table>
    <h1>---------------------------------------------------------</h1>
<table>
    <tr>
        <th>Номер</th>
        <th>Название книги</th>
        <th>Автор</th>
        <th>Цена</th>
    </tr>
    <h3>Каталог книг</h3>
    <#list books as book>
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.authorName}</td>
            <td>${book.cost}</td>
            <td></td>
            <td>
                <form method="post" action="/catalog_of_books/addBook/{customer-Id}">
                    <input name="bookId" type="hidden" value="${book.id}">
                    <input type="submit" value=Добавить">
                </form>
            </td>
        </tr>
    </#list>
</table>
<h3>
    <a href="/pay/${customer.id}">Перейти к оплате</a>
</h3>

</body>
</html>