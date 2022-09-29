<%-- 
    Document   : editnote
    Created on : 28-Sep-2022, 8:59:13 PM
    Author     : meeye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            title: <input type="text" name="title"  value="${note.title}"><br>
            Contents: <textarea name="contents" rows="6" cols="25" name="contents">${note.contents}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
