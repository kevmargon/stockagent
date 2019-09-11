//Funcion para mostrar y ocultar el elemento de notificación en la parte de arriba de las tablas
function showNot() {
	div = document.getElementById('oculto');
	divCS = window.getComputedStyle(div);
	if(divCS.display == "none"){
		div.style.display = "block";
		document.getElementById('p1').innerHTML = "<p><strong>Eventos JavaScript <br></strong><br>Haz click de nuevo para ocultar.</p>";
	}else{
		div.style.display = "none";
		document.getElementById('p1').innerHTML = "<p><strong>Eventos JavaScript <br></strong><br>Haz click de nuevo para mostrar.</p>";
	}
	
}