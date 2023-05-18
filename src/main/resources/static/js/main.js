
function alerting() {
	return alert("me he cargado");
}
let nom = document.getElementById('nombre').value;
document.getElementById('fotoTrabajador').addEventListener('focus', function() {
	if(this.value == '') {
	  this.value = 'http://robohash.org/';
	} else {
		this.value = 'http://robohash.org/' + nom;
	}
	
	/*if(nom.value != '' && this.value == '' || this.value == 'http://robohash.org/') {
		this.value = 'http://robohash.org/' + nom;
	}*/
  });
  
  let cosa = document.getElementById('tipoVehiculo').value;
  
  function cositas(cosa) {
	  if(cosa == document.getElementsByName('option').value) {
		  
	  }
  }