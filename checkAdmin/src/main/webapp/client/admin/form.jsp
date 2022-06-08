<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/client/components/header.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">

    <section class="section error-404 min-vh-100 d-flex flex-column align-items-center justify-content-center">
        <h1>404</h1>
        <h2>The page you are looking for doesn't exist.</h2>
        <img src="client/assets/img/not-found.svg" class="img-fluid py-5" alt="Page Not Found">
    </section>
    <jsp:include page="/client/components/script.jsp"/>
</div>
</body>
</html>
