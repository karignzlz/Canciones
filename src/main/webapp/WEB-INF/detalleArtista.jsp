<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle artista</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h1>Detalle artista</h1>
			</div>
			<div class="detalle">
				<div class="tarjeta">
					<h3>${artista.nombre} ${artista.apellido}</h3>
					<p><strong>Biografía: </strong> ${artista.biografia} </p>
					<p><strong>Canciones: </strong>
					<div>	
						<ul>
							<c:forEach var="cancion" items="${artista.canciones}">
								<li> ${cancion.titulo} </li>
							</c:forEach>
						</ul>
					</div>
					<p><a href="/artistas">Volver a lista de artistas</a></p>
				</div>
			</div>
		</div>
		
	</body>
</html>
