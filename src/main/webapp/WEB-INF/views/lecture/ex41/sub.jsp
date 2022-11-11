<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<h1>fetch 요청 header 조작</h1>
<button id="btn1">/ex41/sub01 get, 해더 추가 (MyHeader)</button>
<br>
<button id="btn2">/ex41/sub02 get, 해더 추가 (YourHeader)</button>
<br>
<button id="btn3">/ex41/sub03 해더 추가 ("-")</button>
<br>
<button id="btn4">/ex41/sub04 해더 추가 (Accept)</button>
<br>
<button id="btn5">/ex41/sub05 해더 추가 (Accept-Language)</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script>
    const ctx = "${pageContext.request.contextPath}";

    document.querySelector("#btn1").addEventListener("click", function () {
        fetch(ctx + "/ex41/sub01", {
            method : "get",
            headers : {MyHeader : "My Header Value"}
        });
    });

    document.querySelector("#btn2").addEventListener("click", function () {
        fetch(ctx + "/ex41/sub02", {
            method : "get",
            headers : {
                YourHeader : "Your Header Value",
                MyHeader : "My Value"}
        });
    });

    document.querySelector("#btn3").addEventListener("click", function () {
        fetch(ctx + "/ex41/sub03", {
            method : "get",
            headers : {
                "Your-Header" : "Your Header Value",
                "My-Header" : "My Header Value"
            }
        });
    });

    document.querySelector("#btn4").addEventListener("click", function () {
        fetch(ctx + "/ex41/sub04", {
            method : "get",
            headers : {
                "My-Header" : "My Value",
                "Accept" : "text/plain"
            }
        });
    });

    document.querySelector("#btn5").addEventListener("click", function () {
        fetch(ctx + "/ex41/sub05", {
            headers : {
                "Accept-Language" : "*"
            }
        });
    });
    // 변경이 안되는 headers도 있다
    // 그중 하나가 Accept-Encoding
</script>
</body>
</html>