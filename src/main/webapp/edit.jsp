<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit file</title>
</head>
<body>
<h3>Edit file</h3>
<form method="post">
    <input type="hidden" value="${directory.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${directory.name}" /><br><br>
    <label>Price</label><br>
    <input name="src" value="${directory.src}" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>