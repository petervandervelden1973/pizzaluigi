<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<!doctype html>
<html lang='nl'>
	<head>
		<title>Pizza's</title>
		<link rel='icon' href='images/favicon.ico'>
		<meta name='viewport' content='width=device-width,initial-scale=1'>
		<link rel='stylesheet' href='styles/default.css'>
	</head>
	<body>
		<h1>Pizza's</h1>
		<ul class='zebra'>
		<c:forEach var='pizza' items='${pizzas}'> 
			<li>${pizza.naam} ${pizza.prijs}&euro;</li>
		</c:forEach> 
		</ul>
	</body>
</html>