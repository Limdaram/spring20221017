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
<h1>json 응답 처리</h1>
1 : <button id="btn1">/ex47/sub01 json 응답</button>
<br>
2 : <button id="btn2">/ex47/sub01 json 응답</button>
<br>
3 : <button id="btn3">/ex47/sub03 json 응답</button>
<br>
4 : <button id="btn4">/ex47/sub04 30 customer json 응답</button>
<br>
5 : <button id="btn5">/ex47/sub05 10 supplier json 응답</button>
<br>
<hr>
<input type="number" placeholder="고객번호" id="customerIdInput1" value="1"> <br>
6 : <button id="btn6">/ex47/sub06 customerId, customer json 응답</button>
<hr>
<input type="number" placeholder="직원번호" id="supplierIdInput1" value="1"> <br>
7 : <button id="btn7">/ex47/sub07 supplierId, supplier json 응답</button>
<hr>
<input type="number" placeholder="고객번호" id="customerIdInput8" value="1"> <br>
8 : <button id="btn8">/ex47/sub06 customerId, customer json 응답</button>
<div id="customerInfoDiv">
    id : <span class="id"></span> <br>
    name : <span class="name"></span> <br>
    city : <span class="city"></span> <br>
    country : <span class="country"></span> <br>
</div>
<div id="messageDiv"></div>

<hr>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script>
  const ctx = "${pageContext.request.contextPath}";
  document.querySelector("#btn1").addEventListener("click", function () {
    fetch(ctx + "/ex47/sub01")
            .then((res) => res.json())
            .then((data) => console.log(data));
  });
  document.querySelector("#btn2").addEventListener("click", function () {
    fetch(ctx + "/ex47/sub01")
            .then((res) => res.json())
            .then((data) => {
              console.log(data.name);
              console.log(data.job);
              console.log(data.address)
            }); // 객체로 return 가능

  });
  document.querySelector("#btn3").addEventListener("click", function () {
    fetch(ctx + "/ex47/sub03")
            .then((res) => res.json())
            .then((data) => {
              console.log(data.color[0]); // blue
              console.log(data.color[1]); // red
              console.log(data.model); // 5
              console.log(data.location); // USA
            });

  });
  document.querySelector("#btn4").addEventListener("click", function () {
      fetch(ctx + "/ex47/sub04")
          .then(res => res.json())
          .then(cus => {
              console.log("id", cus.id);
              console.log("name", cus.name);
              console.log("contactName", cus.contactName);
              console.log("address", cus.address);
              console.log("city", cus.city);
              console.log("postalCode", cus.postalCode);
              console.log("country", cus.country);
          })
  })
  document.querySelector("#btn5").addEventListener("click", function () {
      fetch(ctx + "/ex47/sub05")
          .then(res => res.json())
          .then(sup => {
                console.log("id", sup.id);
                console.log("supplierName", sup.supplierName);
                console.log("contactName", sup.contactName);
                console.log("address", sup.address);
                console.log("city", sup.city);
                console.log("postalCode", sup.postalCode);
                console.log("country", sup.country);
                console.log("phone", sup.phone);
          })
  })
  document.querySelector("#btn6").addEventListener("click", function () {
      const customerId = document.querySelector("#customerIdInput1").value;
      fetch(ctx + "/ex47/sub06/" + customerId)
          .then(res => res.json())
          .then(cus => {
              console.log("id", cus.id);
              console.log("name", cus.name);
              console.log("contactName", cus.contactName);
              console.log("address", cus.address);
              console.log("city", cus.city);
              console.log("postalCode", cus.postalCode);
              console.log("country", cus.country);
          })
  })
  document.querySelector("#btn7").addEventListener("click", function () {
      const supplierId = document.querySelector("#supplierIdInput1").value;
      fetch(ctx + "/ex47/sub07/" + supplierId)
          .then(res => res.json())
          .then(sup => {
              console.log("id", sup.id);
              console.log("supplierName", sup.supplierName);
              console.log("contactName", sup.contactName);
              console.log("address", sup.address);
              console.log("city", sup.city);
              console.log("postalCode", sup.postalCode);
              console.log("country", sup.country);
              console.log("phone", sup.phone);
          })
  })
  document.querySelector("#btn8").addEventListener("click", function () {
      // 텍스트 초기화
      document.querySelector("#messageDiv").innerText = "";
      document.querySelector("#customerInfoDiv .id").innerText = "";
      document.querySelector("#customerInfoDiv .name").innerText = "";
      document.querySelector("#customerInfoDiv .city").innerText = "";
      document.querySelector("#customerInfoDiv .country").innerText = "";

      const customerId = document.querySelector("#customerIdInput8").value;
      fetch(ctx + "/ex47/sub08/" + customerId)
          .then(res => res.json())
          .then(data => {
                // html 출력
              document.querySelector("#messageDiv").innerText = data.message;
              document.querySelector("#customerInfoDiv .id").innerText = data.customer.id;
              document.querySelector("#customerInfoDiv .name").innerText = data.customer.name;
              document.querySelector("#customerInfoDiv .city").innerText = data.customer.city;
              document.querySelector("#customerInfoDiv .country").innerText = data.customer.country;
          })
  })

</script>
</body>
</html>