<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Canciones</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h1>Lista de canciones</h1>
			</div>
			<div class="lista">
				<c:forEach var="cancion" items="${listaCanciones}">
					<div class="tarjeta-cancion">
						<h3> ${cancion.titulo} </h3>
						<p><strong>Autor: </strong> ${cancion.artista}</p>
						<p><a href="/canciones/detalle/${cancion.id}"> Detalle </a></p>
					</div>
				</c:forEach>
			</div>
		</div>
		
	</body>
</html>