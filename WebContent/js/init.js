/*
	Interphase by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
 */

$(function() {
	// Calling Login Form
	$("#login_form").click(function() {
		$(".social_login").hide();
		$(".user_login").show();
		return false;
	});

	// Calling Register Form
	$("#register_form").click(function() {
		$(".social_login").hide();
		$(".user_register").show();
		$(".header_title").text('Register');
		return false;
	});

	// Going back to Social Forms
	$(".back_btn").click(function() {
		$(".user_login").hide();
		$(".user_register").hide();
		$(".social_login").show();
		$(".header_title").text('Login');
		return false;
	});

})

function script() {
	console.log($('#reg_username').value);
	$.post('NormalSignUp', {reg_username: $('#reg_username').value, reg_nickname: $('#reg_nickname').value, reg_pass: $('#reg_pass').value}, function(data) {
	});
}

function signinCallback(authResult) {
	if (authResult['status']['signed_in']) {
		gapi.client.load('plus', 'v1', function() {
			var request = gapi.client.plus.people.get({
				'userId' : 'me'
			});
			request.execute(function(resp) {
				$.post('FaceGoogleAuthentication', {reg_username: "g" + resp.id, reg_nickname: resp.displayName}, function(returnData) {
					window.location.href = "generic.jsp"
				});
			});
		});
	} else {
		// Update the app to reflect a signed out user
		// Possible error values:
		// 'user_signed_out" - User is signed-out
		// "access_denied" - User denied access to your app
		// "immediate_failed" - Could not automatically log in the user
		alert('User canceled login or did not fully authorize the app.');
	}
}




function fbAuth() {
    FB.login(function(response) {
      if (response.authResponse) {
        FB.api('/me', function(me) {
        	$.post('FaceGoogleAuthentication', {reg_username: "f" + me.id, reg_nickname: me.name}, function(returnData) {
        		window.location.href = "generic.jsp"
			});
        });
      } else {
        alert('User canceled login or did not fully authorize the app.');
      }
    });
}

function render() {
	// Additional params including the callback, the rest of the params will
	// come from the page-level configuration.
	var additionalParams = {
		'callback' : signinCallback
	};

	// Attach a click listener to a button to trigger the flow.
	var signinButton = document.getElementById('signinButton');
	signinButton.addEventListener('click', function() {
		gapi.auth.signIn(additionalParams); // Will use page level configuration
	});
}

(function($) {

	skel
			.init({
				reset : 'full',
				breakpoints : {
					global : {
						href : 'css/style.css',
						containers : 1400,
						grid : {
							gutters : [ '2em', 0 ]
						}
					},
					xlarge : {
						media : '(max-width: 1680px)',
						href : 'css/style-xlarge.css',
						containers : 1200
					},
					large : {
						media : '(max-width: 1280px)',
						href : 'css/style-large.css',
						containers : 960,
						grid : {
							gutters : [ '1.5em', 0 ]
						},
						viewport : {
							scalable : false
						}
					},
					medium : {
						media : '(max-width: 980px)',
						href : 'css/style-medium.css',
						containers : '90%'
					},
					small : {
						media : '(max-width: 736px)',
						href : 'css/style-small.css',
						containers : '90%',
						grid : {
							gutters : [ '1.25em', 0 ]
						}
					},
					xsmall : {
						media : '(max-width: 480px)',
						href : 'css/style-xsmall.css',
					}
				},
				plugins : {
					layers : {
						config : {
							mode : 'transform'
						},
						navPanel : {
							animation : 'pushX',
							breakpoints : 'medium',
							clickToHide : true,
							height : '100%',
							hidden : true,
							html : '<div data-action="moveElement" data-args="nav"></div>',
							orientation : 'vertical',
							position : 'top-left',
							side : 'left',
							width : 250
						},
						navButton : {
							breakpoints : 'medium',
							height : '4em',
							html : '<span class="toggle" data-action="toggleLayer" data-args="navPanel"></span>',
							position : 'top-left',
							side : 'top',
							width : '6em'
						}
					}
				}
			});

	$(function() {

		// ...

	});

})(jQuery);