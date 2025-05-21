<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar canción</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h2> Agregar canción </h2>
			</div>
			<div>
			<form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion" class="formulario">
				<div class="datos">
					<form:label path="titulo">
						Título:
					</form:label>
					<form:input path="titulo" />
					<form:errors path="titulo" />
				</div>
				<div class="datos">
					<form:label path="artista">
						Autor:
					</form:label>
					<form:input path="artista" />
					<form:errors path="artista" />
				</div>
				<div class="datos">
					<form:label path="album">
						Álbum:
					</form:label>
					<form:input path="album" />
					<form:errors path="album" />
				</div>
				<div class="datos">
					<form:label path="genero">
						Género:
					</form:label>
					<form:input path="genero" />
					<form:errors path="genero" />
				</div>
				<div class="datos">
					<form:label path="idioma">
						Idioma:
					</form:label>
					<form:input path="idioma" />
					<form:errors path="idioma" />
				</div>
				<button class="boton">
					<strong> Agregar </strong>
				</button>
			</form:form>
			<p><a href="/canciones"> Volver a lista canciones</a></p>
		</div>
	</body>
</html>