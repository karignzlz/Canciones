<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Agregar artista</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h2> Agregar artista </h2>
			</div>
			<div>
			<form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista" class="formulario">
				<div class="datos">
					<form:label path="nombre">
						Nombre:
					</form:label>
					<form:input path="nombre" />
					<form:errors path="nombre" />
				</div>
				<div class="datos">
					<form:label path="apellido">
						Apellido:
					</form:label>
					<form:input path="apellido" />
					<form:errors path="apellido" />
				</div>
				<div class="datos">
					<form:label path="biografia">
						Biografía:
					</form:label>
					<form:input path="biografia" />
					<form:errors path="biografia" />
				</div>
				<button class="boton">
					<strong> Agregar </strong>
				</button>
			</form:form>
			<p><a href="/canciones"> Volver a lista canciones</a></p>
		</div>
	</body>
</html>
