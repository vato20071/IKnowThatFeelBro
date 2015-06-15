/**
 * 
 */

function swapIt() {
	console.log('wtf');
	if (document.getElementById('send_updates').checked) {
		$('#reg_pass').removeAttr('type');
		$('#reg_pass').prop('type', 'text');
	} else {
		$('#reg_pass').removeAttr('type');
		$('#reg_pass').prop('type', 'password');		
	}
}