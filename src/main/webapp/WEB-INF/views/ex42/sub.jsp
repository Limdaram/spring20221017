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
<h1>Accept 요청 헤더를 처리하는 controller 메소드</h1>
<button id="btn1">/ex42/sub01 plain 요청</button>
<br>
<button id="btn2">/ex42/sub01 html 요청</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script>
  const ctx = "${pageContext.request.contextPath}";

  document.querySelector("#btn1").addEventListener("click", function () {
    fetch(ctx + "/ex42/sub01", {
      headers : {
        "Accept" : "text/plain"
      }
    });
  });

  // Accept header의 이름과 ("text/plain")
  // controller method의 produces 이름이 같을때만 일을 한다 (produces = "text/plain")
  // 요청을 줄여서 일하게 할 수 있다

  // client 입장에서는 accept 이니까
  // server 입장에서는 produces

  document.querySelector("#btn2").addEventListener("click", function () {
    fetch(ctx + "/ex42/sub01", {
      headers : {
        "Accept" : "text/html"
      }
    });
  });

</script>
</body>
</html>