<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add</title>
    <link rel="stylesheet" href="css/add.css">
</head>

<body>
    <div class="wrap">
        <h1 class="header">할일 등록</h1>
        <form action="./ToAddServlet" method="post">
            어떤 일인가요?
            <input type="text" name="title" placeholder="swift 공부하기(24자까지)"  maxlength="24" class="input" size="40" tabindex="1" required>
            <br>누가 할일인가요?<br>
            <input type="text" name="name" placeholder="홍길동" class="input" size="25" tabindex="2" required>
            <br> 우선순위를 선택하세요
            <br>
            <div class="radio_btn">
                <input type="radio" name="priority" value="1" id="first" required><label for="1">1순위</label>
                <input type="radio" name="priority" value="2" id="second" required><label for="2">2순위</label>
                <input type="radio" name="priority" valuye="3" id="third" required><label for="3">3순위</label>
            </div>
            <br>
            <div class="btn">
                <input type="button" class="back_btn" value="이전" onclick="location.href='./MainServlet'">
                <input type="submit" class="submit_btn" value="제출">
                <input type="reset" class="erase_btn" value="내용지우기">
            </div>
        </form>

    </div>

</body>

</html>
