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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<my:navBar active="signup"></my:navBar>

<div class="container-md">
    <div class="row">
        <div class="col">
            <h1>회원가입</h1>
            <form action="" method="post">

                <div class="mb-3">
                    <label for="" class="form-label">
                        아이디
                    </label>

                    <div class="input-group">
                        <input id="userIdInput1" class="form-control" type="text" name="id">
                        <button id="userIdExistButton1" class="btn btn-outline-secondary" type="button">중복확인</button>
                    </div>
                    <div id="userIdText1" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">
                        비밀번호
                    </label>
                    <input id="passwordInput1" class="form-control" type="password" name="password">
                    <div id="passwordText1" class="form-text"></div>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">
                        비밀번호 확인
                    </label>
                    <input id="passwordInput2" class="form-control" type="password">  <%-- 확인용이라 실제 값이 넘어갈 일이 없기 때문에 name 생략 --%>
                </div>

                <div class="mb-3">
                    <label for="" class="form-label">
                        이메일
                    </label>
                    <div class="input-group">
                        <input id="userEmailInput1" class="form-control" type="email" name="email">
                        <button id="userEmailExistButton1" class="btn btn-outline-secondary" type="button">중복확인</button>
                    </div>

                    <div id="userEmailText1" class="form-text"></div>
                </div>

                <input id="submitButton1" disabled class="btn btn-primary" type="submit" value="가입">
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<script>
    // 아이디 중복확인
    const ctx = "${pageContext.request.contextPath}";

    document.querySelector("#userIdExistButton1").addEventListener("click", function () {
        availableId = false;
        // 입력된 userId를
        const userId = document.querySelector("#userIdInput1").value;

        // fetch 요청으로 보내고
        fetch(ctx + "/member/existId/" + userId)
            .then(res => res.json())
            .then(data => {
                // 응답 받아서
                document.querySelector("#userIdText1").innerText = data.message;

                if (data.status == "not exist") {
                    availableId = true;
                    enableSubmitButton();
                }
            });
    });

    // 패스워드 일치하는지 확인
    const passwordInput1 = document.querySelector("#passwordInput1");
    const passwordInput2 = document.querySelector("#passwordInput2");
    const passwordText1 = document.querySelector("#passwordText1");

    function matchPassword() {
        availablePassword = false;

        const value1 = passwordInput1.value;
        const value2 = passwordInput2.value;

        if (value1 == value2) {
            passwordText1.innerText = "패스워드가 일치합니다"
            availablePassword = true;
        } else {
            passwordText1.innerText = "패스워드가 일치하지 않습니다"
        }

        enableSubmitButton();
    }
    document.querySelector("#passwordInput1").addEventListener("keyup", matchPassword)
    document.querySelector("#passwordInput2").addEventListener("keyup", matchPassword)



    // 이메일 중복확인
    document.querySelector("#userEmailExistButton1").addEventListener("click", function () {
        availableEmail = false;
        // 입력된 userEmail를
        const userEmail = document.querySelector("#userEmailInput1").value;

        // fetch 요청으로 보내고
        fetch(ctx + "/member/existEmail", {
            method : "POST",
            headers : {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({userEmail})
        })
            .then(res => res.json())
            .then(data => {
                // 응답 받아서
                document.querySelector("#userEmailText1").innerText = data.message;

                if (data.status == "not exist") {
                    availableEmail = true;
                    enableSubmitButton();
                }
            });
    });

    // 아이디 사용 가능
    let availableId = false;
    // 이메일 사용 가능
    let availableEmail = false;
    // 패스워드 사용 가능
    let availablePassword = false;

    function enableSubmitButton() {
        const button = document.querySelector("#submitButton1");
        if (availableId && availableEmail && availablePassword) {
            button.removeAttribute("disabled")
        } else {
            button.setAttribute("disabled", "");
        }
    }

    // 아이디 input 변경 시 submit 버튼 비활성화
    document.querySelector("#userIdInput1").addEventListener("keyup", function () {
        availableId = false;
        enableSubmitButton();
    })

    // 이메일 input 변경 시 submit 버튼 비활성화
    document.querySelector("#userEmailInput1").addEventListener("keyup", function () {
        availableEmail = false;
        enableSubmitButton();
    })
</script>
</body>
</html>