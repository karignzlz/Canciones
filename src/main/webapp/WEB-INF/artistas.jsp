<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Artistas</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h1>Lista de artistas</h1>
			</div>
			<div class="lista">
				<ul>
			        <c:forEach var="artista" items="${listaArtistas}">
			            <li><a href="/artistas/detalle/${artista.id}"> ${artista.nombre} ${artista.apellido} </a></li>
			        </c:forEach>
			    </ul>
			</div>
			<form action="/artistas/formulario/agregar/0" method="GET">
				<button class="boton"><strong> Agregar </strong></button>
			</form>
			<div>
				<p><a href="/canciones"> Ir a canciones </a></p>
			</div>
		</div>
		
	</body>
</html>