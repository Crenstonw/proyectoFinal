
function alerting() {
	return alert("me he cargado");
}
let nom = document.getElementById('nombre');
document.getElementById('fotoTrabajador').addEventListener('focus', function() {
	if(this.value == '') {
	  this.value = 'http://robohash.org/';
	}

	if(nom.value != '' && this.value == '' || this.value == 'http://robohash.org/') {
		this.value = 'http://robohash.org/' + nom;
	}
  });