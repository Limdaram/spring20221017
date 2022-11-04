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
<div id="messageDiv"></div>
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
<input type="number" placeholder="공급자번호" id="supplierIdInput1" value="1"> <br>
7 : <button id="btn7">/ex47/sub07 supplierId, supplier json 응답</button>
<hr>
<input type="number" placeholder="고객번호" id="customerIdInput8" value="1"> <br>
8 : <button id="btn8">/ex47/sub08 customerId, customer json 응답</button>
<div id="customerInfoDiv">
    id : <span class="id"></span> <br>
    name : <span class="name"></span> <br>
    city : <span class="city"></span> <br>
    country : <span class="country"></span> <br>
</div>
<hr>
<input type="number" placeholder="공급자번호" id="supplierIdInput9" value="1"> <br>
9 : <button id="btn9">/ex47/sub09 supplierId, supplier json 응답</button>
<div id="supplierInfoDiv">
    id : <span class="id"></span> <br>
    name : <span class="supplierName"></span> <br>
    city : <span class="city"></span> <br>
    country : <span class="country"></span> <br>
</div>
<hr>
10 : <button id="btn10">/ex47/sub10 put요청 : 고객정보</button>
<hr>
<form action="">
    id : <input type="text" name="id" id="supplierIdInput11"> <br>
    supplierName : <input type="text" name="supplierName" id="supplierNameInput11"> <br>
    contactName : <input type="text" name="contactName" id="supplierContactNameInput11"> <br>
    address : <input type="text" name="address" id="supplierAddressInput11"> <br>
    city : <input type="text" name="city" id="supplierCityInput11"> <br>
    postalCode : <input type="text" name="postalCode" id="supplierPostalCodeInput11"> <br>
    country : <input type="text" name="country" id="supplierCountryInput11"> <br>
</form>
11 : <button id="btn11">/ex47/sub11 입력받은 값 put요청 : 공급자정보</button>
<hr>
<form action="">
    name : <input type="text" name="name" id="customerNameInput12"> <br>
    contactName : <input type="text" name="contactName" id="customerContactNameInput12"> <br>
    address : <input type="text" name="address" id="customerAddressInput12"> <br>
    city : <input type="text" name="city" id="customerCityInput12"> <br>
    postalCode : <input type="text" name="postalCode" id="customerPostalCodeInput12"> <br>
    country : <input type="text" name="country" id="customerCountryInput12"> <br>
</form>
12 : <button id="btn12">/ex47/sub12 입력받은 값 post요청 : 고객정보</button>
<hr>
<form action="">
    supplierName : <input type="text" name="supplierName" id="supplierNameInput13"> <br>
    contactName : <input type="text" name="contactName" id="supplierContactNameInput13"> <br>
    address : <input type="text" name="address" id="supplierAddressInput13"> <br>
    city : <input type="text" name="city" id="supplierCityInput13"> <br>
    postalCode : <input type="text" name="postalCode" id="supplierPostalCodeInput13"> <br>
    country : <input type="text" name="country" id="supplierCountryInput13"> <br>
</form>
13 : <button id="btn13">/ex47/sub13 입력받은 값 post요청 : 공급자정보</button>
<hr>
14 : <button id="btn14">/ex47/sub14 delete요청 : 공급자정보</button>
<hr>
<form action="">
    id : <input type="text" name="id" id="customerIdInput15"> <br>
</form>
15 : <button id="btn15">/ex47/sub14 입력받은 delete요청 : 공급자정보</button>



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
  document.querySelector("#btn9").addEventListener("click", function () {
      // 텍스트 초기화
      document.querySelector("#messageDiv").innerText = "";
      document.querySelector("#supplierInfoDiv .id").innerText = "";
      document.querySelector("#supplierInfoDiv .supplierName").innerText = "";
      document.querySelector("#supplierInfoDiv .city").innerText = "";
      document.querySelector("#supplierInfoDiv .country").innerText = "";

      const customerId = document.querySelector("#supplierIdInput9").value;
      fetch(ctx + "/ex47/sub09/" + customerId)
          .then(res => res.json())
          .then(data => {
              // html 출력
              document.querySelector("#messageDiv").innerText = data.message;
              document.querySelector("#supplierInfoDiv .id").innerText = data.supplier.id;
              document.querySelector("#supplierInfoDiv .supplierName").innerText = data.supplier.supplierName;
              document.querySelector("#supplierInfoDiv .city").innerText = data.supplier.city;
              document.querySelector("#supplierInfoDiv .country").innerText = data.supplier.country;
          })
  })
  document.querySelector("#btn10").addEventListener("click", function () {
      const data = {
          id : 1,
          name : "limdaraming",
          contactName : "LDR",
          address : "seoul",
          city : "seoul",
          postalCode : "1234",
          country : "korea"

      };
      fetch(ctx + "/ex47/sub10", {
          method : "put",
          headers : {
              "Content-Type" : "application/json"
          },
          body : JSON.stringify(data)
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          })
  })
  document.querySelector("#btn11").addEventListener("click", function () {
      const id = document.querySelector("#supplierIdInput11").value;
      const supplierName = document.querySelector("#supplierNameInput11").value;
      const contactName = document.querySelector("#supplierContactNameInput11").value;
      const address = document.querySelector("#supplierAddressInput11").value;
      const city = document.querySelector("#supplierCityInput11").value;
      const postalCode = document.querySelector("#supplierPostalCodeInput11").value;
      const country = document.querySelector("#supplierCountryInput11").value;

      const data = {
          id : id,
          supplierName : supplierName,
          contactName : contactName,
          address : address,
          city : city,
          postalCode : postalCode,
          country : country
      };
      fetch(ctx + "/ex47/sub11", {
          method : "put",
          headers : {
              "Content-Type" : "application/json"
          },
          body : JSON.stringify(data)
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          });
  });
  document.querySelector("#btn12").addEventListener("click", function () {
      const name = document.querySelector("#customerNameInput12").value;
      const contactName = document.querySelector("#customerContactNameInput12").value;
      const address = document.querySelector("#customerAddressInput12").value;
      const city = document.querySelector("#customerCityInput12").value;
      const postalCode = document.querySelector("#customerPostalCodeInput12").value;
      const country = document.querySelector("#customerCountryInput12").value;

      const data = {
          name : name,
          contactName : contactName,
          address : address,
          city : city,
          postalCode : postalCode,
          country : country
      };
      fetch(ctx + "/ex47/sub12", {
          method : "post",
          headers : {
              "Content-Type" : "application/json"
          },
          body : JSON.stringify(data)
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          });
  });
  document.querySelector("#btn13").addEventListener("click", function () {
      const supplierName = document.querySelector("#supplierNameInput13").value;
      const contactName = document.querySelector("#supplierContactNameInput13").value;
      const address = document.querySelector("#supplierAddressInput13").value;
      const city = document.querySelector("#supplierCityInput13").value;
      const postalCode = document.querySelector("#supplierPostalCodeInput13").value;
      const country = document.querySelector("#supplierCountryInput13").value;

      const data = {
          supplierName : supplierName,
          contactName : contactName,
          address : address,
          city : city,
          postalCode : postalCode,
          country : country
      };
      fetch(ctx + "/ex47/sub13", {
          method : "post",
          headers : {
              "Content-Type" : "application/json"
          },
          body : JSON.stringify(data)
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          });
  });
  document.querySelector("#btn14").addEventListener("click", function() {
      fetch(ctx + "/ex47/sub14/90", {
          method : "delete"
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          });
  });
  document.querySelector("#btn15").addEventListener("click", function() {
      const id = document.querySelector("#customerIdInput15").value;

      fetch(ctx + "/ex47/sub15/" + id, {
          method : "delete"
      })
          .then(res => res.json())
          .then(data => {
              document.querySelector("#messageDiv").innerText = data.message;
          });

  });


</script>
</body>
</html>