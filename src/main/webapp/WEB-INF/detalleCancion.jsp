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
					<p><strong>Autor: </strong>${cancion.artista.nombre} ${cancion.artista.apellido}</p>
					<p><strong>Álbum: </strong>${cancion.album}</p>
					<p><strong>Género: </strong>${cancion.genero}</p>
					<p><strong>Idioma: </strong>${cancion.idioma}</p>
					<div class="botones">
						<form action="/canciones/formulario/editar/${cancion.id}" method="GET">
							<button class="boton"><strong>Editar</strong></button>
						</form>
						<form action="/canciones/eliminar/${cancion.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<button class="btn-eliminar"><strong>Eliminar</strong></button>
						</form>
					</div>
					<p><a href="/canciones">Volver a lista de canciones</a></p>
				</div>
			</div>
		</div>
		
	</body>
</html>