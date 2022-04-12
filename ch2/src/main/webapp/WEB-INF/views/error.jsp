<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>error.jsp</title>
</head>  
<body>    <!-- isErrirPage="true" 사용시 예외를 모델로 view로 예외객체를 전달하지 않아도 쓸 수 있음. 기본객체 exception사용 가능하다. -->
<h1>예외가 발생했습니다.</h1>  
발생한 예외 : ${pageContext.exception}<br>
예외 메시지 : ${pageContext.exception.message}<br>
<ol>
<c:forEach items="${pageContext.exception.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>


