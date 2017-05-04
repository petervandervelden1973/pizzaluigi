<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<!doctype html>
<html lang='nl'>
	<head>
		<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value='Pizza Luigi'/> 
		</c:import>
	</head>
	<body>
		<h1>Pizza Luigi</h1>
		<img src='images/pizza.jpg' alt='pizza' class='fullwidth'>
		<h2>${begroeting}</h2>
		<h2>De zaakvoerder</h2>
		<dl>
		<dt>Naam</dt><dd>${zaakvoerder.naam}</dd>
		<dt>Aantal kinderen</dt><dd>${zaakvoerder.aantalKinderen}</dd>
		<dt>Gehuwd</dt><dd>${zaakvoerder.gehuwd ? 'Ja' : 'Nee'}</dd>
		<dt>Adres</dt>
		<dd>${zaakvoerder.adres.straat} ${zaakvoerder.adres.huisnr}<br>
			${zaakvoerder.adres.postcode} ${zaakvoerder.adres.gemeente}</dd>
		</dl>
		
	</body>
</html>