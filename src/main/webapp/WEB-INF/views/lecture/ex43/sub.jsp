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
<h1>서버로 데이터 전송</h1>
<button id="btn1">/ex43/sub01 get 요청</button>
<br>
<button id="btn2">/ex43/sub02 get 요청</button>
<br>
<hr>
<form action="" id="form1">
    name <input type="text" name="name"> <br>
    email <input type="text" name="email">
</form>
<br>
<button id="btn3">/ex43/sub03 get 요청</button>
<hr>
<form action="" id="form2">
    address <input type="text" name="address"> <br>
    age <input type="text" name="age">
</form>
<br>
<button id="btn4">/ex43/sub04 get 요청</button>
<hr>
<button id="btn5">/ex43/sub05 post 요청</button>
<br>
<button id="btn6">/ex43/sub06 post 요청</button>
<br>
<button id="btn7">/ex43/sub07 post 요청 form1</button>
<br>
<button id="btn8">/ex43/sub08 post 요청 form2</button>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script>
  const ctx = "${pageContext.request.contextPath}";
  document.querySelector("#btn1").addEventListener("click", function() {
    fetch(ctx + "/ex43/sub01?name=daram&address=seoul");
  });
  document.querySelector("#btn2").addEventListener("click", function() {
    fetch(ctx + "/ex43/sub02?email=daram@gmail.com&age=26");
  })
  document.querySelector("#btn3").addEventListener("click", function() {
      const form1 = document.forms.form1;
      const formData = new FormData(form1);
      const data = new URLSearchParams(formData);
      // const form1 = document.querySelector("#form1")
      fetch(ctx + "/ex43/sub03?" + data);
  })
  document.querySelector("#btn4").addEventListener("click", function() {
      const form2 = document.forms.form2;
      const formData = new FormData(form2);
      const data = new URLSearchParams(formData);
      // const data = new URLSearchParams(new FormData(document.forms.form2));

      fetch(ctx + "/ex43/sub04?" + data)
  })
  document.querySelector("#btn5").addEventListener("click", function() {
      fetch(ctx + "/ex43/sub05", {
          method : "post",
          headers : {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          body : "address=seoul&age=26"
      });
  });
  document.querySelector("#btn6").addEventListener("click", function() {
      fetch(ctx + "/ex43/sub06", {
          method : "post",
          headers : {
              "Content-Type" : "application/x-www-form-urlencoded"
          },
          body : "name=daram&email=daram@gmail.com"
      });
  });
  document.querySelector("#btn7").addEventListener("click", function() {
      const data = new URLSearchParams(new FormData(document.forms.form1));
      fetch(ctx+"/ex43/sub07", {
          method : "post",
          body : data
      });
  });
  document.querySelector("#btn8").addEventListener("click", function() {
      const data = new URLSearchParams(new FormData(document.forms.form2));
      fetch(ctx + "/ex43/sub08", {
          method : "post",
          body : data
      });
  });

</script>
</body>
</html>