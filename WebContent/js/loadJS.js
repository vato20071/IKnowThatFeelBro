/**
 * 
 */

function swapIt() {
	if (document.getElementById('checkBox').checked) {
		$('#reg_pass').removeAttr('type');
		$('#reg_pass').prop('type', 'text');
	} else {
		$('#reg_pass').removeAttr('type');
		$('#reg_pass').prop('type', 'password');
	}
}