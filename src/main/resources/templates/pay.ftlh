<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<#list books as book>
<tr>
    <td>${book.id}</td>
    <td>${book.name}</td>
    <td>${book.authorName}</td>
    <td>${book.cost}</td>
</tr>
</#list>

</body>
</html>