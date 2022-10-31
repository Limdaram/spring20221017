<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<my:navBar active="register"></my:navBar>
<div class="container-md">
    <div class="row">
        <div class="col">

            <h1>게시물 작성</h1>
            <form action="" method="post">
                <div class="mb-3">
                    <label class="form-label">
                        제목
                    </label>
                    <input class="form-control" type="text" name="title">
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        작성자
                    </label>
                    <input class="form-control" type="text" name="writer">
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        본문
                    </label>
                    <textarea class="form-control" name="content"></textarea>
                </div>

                <input class="btn btn-primary" type="submit" value="등록">
            </form>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
                    crossorigin="anonymous"></script>
        </div>
    </div>
</div>
</body>
</html>