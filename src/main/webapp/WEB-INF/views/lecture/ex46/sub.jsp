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
<h1>응답 처리</h1>
1 : <button id="bt1">/ex46/sub01</button>
<br>
2: <button id="bt2">/ex46/sub01</button>
<br>
3 : <button id="bt3">/ex46/sub01</button>
<br>
4 : <button id="bt4">/ex46/sub01</button>
<br>
5 : <button id="bt5">/ex46/sub01</button>
<br>
6 : <button id="bt6">/ex46/sub01</button>
<br>
7 : <button id="bt7">/ex46/sub01</button>
<br>
8 : <button id="bt8">/ex46/sub01</button>
<br>
9 : <button id="bt9">/ex46/sub01 응답 출력</button>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script>
  const ctx = "${pageContext.request.contextPath}";
  document.querySelector("#bt1").addEventListener("click", function () {
    console.log("1 statement"); // 1번
    fetch(ctx + "/ex46/sub01").then(function () {
      console.log("응답 후 실행해야하는 코드") // 3번
    });
    console.log("응답과 상관없이 계속 실행하는 코드"); // 2번
  })
  // 첫 번째 then 메소드에 들어간 함수 다음에 순서대로 두 번째 then 메소드에 들어간 함수가 실행된다
  document.querySelector("#bt2").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(function () {
          console.log("응답 후 실행해야하는 코드1")
          console.log("응답 후 실행해야하는 코드2")

      })
          .then(function () {
          console.log("응답 후 실행3")
          console.log("응답 후 실행4")

      });
  });
  // 직전 then 메소드 함수가 return한 값을 두번째 then 메소드 함수가 파라미터로 사용할 수 있다
  document.querySelector("#bt3").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(function () {
              console.log(("첫번째 then 함수"));
              return "abc";

          })
          .then(function (data) {
              console.log("두번째 then 함수");
              console.log("첫번째 then 함수가 리턴한 값 : ", data);
          });
  });
  document.querySelector("#bt4").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(function () {

                return "a";
          })
          .then(function (v) {
                return v + "b";
          })
          .then(function (v) {
              console.log(v); // ab
          });
  });
  document.querySelector("#bt5").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(() => {

              return "a";
          })
          .then((v) => {
              return v + "b";
          })
          .then((v) => {
              console.log(v); // ab
          });
  });
  document.querySelector("#bt6").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(() => "a")
          .then(v => v + "b")
          .then(v => console.log(v));
  });
  document.querySelector("#bt7").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(() => 3)
          .then(a => a * 2) // 6
          .then(b => b * 2) // 12
          .then(c => console.log(c)); // 12
  });
  document.querySelector("#bt8").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then(() => 3)
          .then(a => console.log(a * 2)) // 6
          .then(b => console.log(b * 2)) // console.log(a*2) 자체를 return 한것이기 때문에 12가 나오지 않는다
          .then(c => console.log(c)); // console.log(b*2)
  });
  document.querySelector("#bt9").addEventListener("click", function () {
      fetch(ctx + "/ex46/sub01")
          .then((response) => response.text())
          .then((data) => console.log(data)); // /ex46/sub01의 return인 hello daram을 받아 응답
          // hello daram
  });
</script>
</body>
</html>