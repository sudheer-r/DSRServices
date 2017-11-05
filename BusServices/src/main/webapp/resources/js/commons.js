function validateForm(formId) {
	var form = document.getElementById(formId);
	for (i = 0; i < form.elements.length; i++) {
		form.elements[i].classList.remove("error");
		if (form.elements[i].tagName == 'SELECT') {
			if (checkDropDown(form.elements[i])) {
				form.elements[i].classList.add("error");
				form.elements[i].focus();
				return false;
			}
		}

	}

	if (validateDate(document.getElementById("date"))) {
		document.getElementById("dateErr").hidden = false;
	} else {
		document.getElementById("dateErr").hidden = true;
	}
}
function checkDropDown(field) {
	return ('select' == field.value);

}
function selectDest() {
	var dest = document.getElementById("dest");
	var source = document.getElementById("source");
	if (source.value == 'select') {
		dest.disabled = true;
	} else {
		dest.disabled = false;
	}
}
function validateDate(dateField) {
	var date = new Date();
	console.log('validate');
	return dateField.value == (date.getFullYear() + '-' + date.getMonth() + '-' + date
			.getDate());
}