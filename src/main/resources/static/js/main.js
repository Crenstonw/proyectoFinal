
/*let nom = document.getElementById('nombre').value;
document.getElementById('fotoTrabajador').addEventListener('focus', function () {
	if (this.value == '') {
		this.value = 'http://robohash.org/';
	} else {
		this.value = 'http://robohash.org/' + nom;
	}
});*/

let form = document.getElementById('form');
let dni = document.getElementById('dni');
let nombre = document.getElementById('nombre');
let apellidos = document.getElementById('apellidos');
let telefono = document.getElementById('telefono');
let email = document.getElementById('email');
let message = 'default';



form.addEventListener('submit', e => {
	e.preventDefault();

	validateImputs();
});

function setError(element, message) {
	let inputControl = element.parentElement;
	let errorDisplay = inputControl.querySelector('.error');

	errorDisplay.innerText = message;
	inputControl.classList.add('error');
	inputControl.classList.remove('success');
}

function setSuccess(element) {
	let inputControl = element.parentElement;
	let errorDisplay = inputControl.querySelector('.error');

	errorDisplay.innerText = '';
	inputControl.classList.add('success');
	inputControl.classList.remove('error');
}

function dniValido(dni) {
	let re = /^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]{1}$/i;
	return re.test(String(dni).toUpperCase());
}

function emailValido(email) {
	let re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return re.test(String(email).toLowerCase());
}

function validateImputs() {
	let dniValue = dni.value.trim();
	let nombreValue = nombre.value.trim();
	let apellidosValue = apellidos.value.trim();
	let telefonoValue = telefono.value.trim();
	let emailValue = email.value.trim();

	if (nombreValue === '') {
		setError(nombre, 'El nombre es obligatorio');
	} else {
		setSuccess(nombre);
	}

	if (apellidosValue === '') {
		setError(apellidos, 'Los apellidos son obligatorios');
	} else {
		setSuccess(apellidos);
	}

	if (dniValue === '') {
		setError(dni, 'El dni es obligatorio');
	} else if (!dniValido(dniValue)) {
		setError(dni, 'este dni no es válido')
	} else {
		setSuccess(dni);
	}

	if (telefonoValue === '') {
		setError(telefono, 'El teléfono es obligatorio')
	} else if (telefonoValue.length > 10) {
		setError(telefono, 'Este teléfono no es válido')
	} else {
		setSuccess(telefono)
	}

	if (emailValue === '') {
		setError(email, 'El email es obligatorio');
	} else if (!emailValido(emailValue)) {
		setError(email, 'El email introducido no es válido');
	} else {
		setSuccess(email);
	}

}