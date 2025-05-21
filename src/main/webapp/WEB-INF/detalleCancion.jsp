<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Detalle canción</title>
		<link href="/css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="titulo">
				<h1>Detalle canción</h1>
			</div>
			<div class="detalle">
				<div class="tarjeta-cancion">
					<h3>${cancion.titulo}</h3>
					<p><strong>Autor: </strong>${cancion.artista}</p>
					<p><strong>Album: </strong>${cancion.album}</p>
					<p><strong>Género: </strong>${cancion.genero}</p>
					<p><strong>Idioma: </strong>${cancion.idioma}</p>
					<p><a href="/canciones">Volver a lista de canciones</a></p>
				</div>
			</div>
		</div>
		
	</body>
</html>