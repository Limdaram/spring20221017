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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<my:navBar></my:navBar>
<div class="container-md">
    <div class="row">
        <div class="col">

            <h1>${board.id}번 게시물</h1>
            <div class="mb-3">
                <label class="form-label">
                    제목
                </label>
                <input class="form-control" type="text" value="${board.title}" readonly>
            </div>

            <div class="mb-3">
                <label class="form-label">
                    본문
                </label>
                <textarea class="form-control" readonly>${board.content}</textarea>
            </div>

            <div class="mb-3">
                <label class="form-label">
                    작성자
                </label>
                <input class="form-control" type="text" value="${board.writer}" readonly>
            </div>

            <div class="mb-3">
                <label class="form-label">
                    작성일시
                </label>
                <input class="form-control" type="datetime-local" value="${board.inserted}" readonly>
            </div>

            <br>
            <c:url value="/board/modify" var="modifyLink">
                <c:param name="id" value="${board.id}"></c:param>
            </c:url>
            <a class = "btn btn-warning" href="${modifyLink}">수정하기</a>

            <c:url value="/board/remove" var="removeLink">
                <c:param name="id" value="${board.id}"></c:param>
            </c:url>

            <form id="removeForm" action="${removeLink }" method="post">
                <input type="hidden" name="id" value="${board.id }">
            </form>
                <input class="btn btn-warning" type="submit" value="삭제하기" data-bs-toggle="modal" data-bs-target="#removeModal">
            <%--<a class = "btn btn-warning" href="${removeLink}">삭제하기</a>--%>

            <!-- Modal -->
            <div class="modal fade" id="removeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="exampleModalLabel">삭제 확인</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            삭제하시겠습니까?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                            <button id="removeConfirmButton" type="button" class="btn btn-danger">확인</button>
                        </div>
                    </div>
                </div>
            </div>

            <div id="replyMessage1">
            </div>

            <div class="container-md">
                <div class="row">
                    <div class="col">
                        <input type="hidden" id="boardId" value="${board.id}">
                        <input type="text" id="replyInput1">
                        <button id="replySendButton1">댓글쓰기</button>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div id="replyListContainer">

                    </div>
                </div>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
                    crossorigin="anonymous"></script>
            <script>
                const ctx = "${pageContext.request.contextPath}";

                listReply();
                function listReply() {
                    const boardId = document.querySelector("#boardId").value;
                    fetch(`\${ctx}/reply/list/\${boardId}`)
                        .then(res => res.json())
                        .then(list => {
                            const replyListContainer = document.querySelector("#replyListContainer");
                            replyListContainer.innerHTML = "";

                            for (const item of list) {
                                // console.log(item.id);
                                const replyDiv = `<div>\${item.content} : \${item.inserted}</div>`;
                                document.querySelector("#replyListContainer").insertAdjacentHTML("beforeend", replyDiv);
                            }
                        });
                }
                document.querySelector("#removeConfirmButton").addEventListener("click", function() {
                    document.querySelector("#removeForm").submit();
                })

                document.querySelector("#replySendButton1").addEventListener("click", function () {
                    const boardId = document.querySelector("#boardId").value;
                    const content = document.querySelector("#replyInput1").value;

                    const data = {
                        boardId,
                        content
                    };
                    fetch(`\${ctx}/reply/add`, {
                        method : "POST",
                        headers : {
                            "Content-Type": "application/json"
                        },
                        body : JSON.stringify(data)
                    })
                        .then(res => res.json())
                        .then(data => {
                            document.querySelector("#replyInput1").value = "";
                            document.querySelector("#replyMessage1").innerText = data.message;
                        })
                        .then(() => listReply())
                });
            </script>
        </div>
    </div>
</div>
</body>
</html>