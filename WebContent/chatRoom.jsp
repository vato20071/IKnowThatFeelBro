<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="core.Message"%>
<%@page import="java.util.List"%>
<%@page import="core.Room"%>
<%@page import="core.Account"%>
<%@page import="core.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html
	class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<!--<![endif]-->
<head>
<script src="js/jquery.min.js"></script>
<script async="" type="text/javascript" src="https://www.googletagservices.com/tag/js/check_359604.js"></script><iframe src="https://tpc.googlesyndication.com/safeframe/1-0-2/html/container.html" style="visibility: hidden; display: none;"></iframe>
<meta http-equiv="pragma" content="no-cache">
<meta charset="utf-8">
<%	Category cat = (Category) session.getAttribute("category");
	Account acc = (Account) session.getAttribute("account");
	Room room = (Room) session.getAttribute("room");
	if(session.getAttribute("spectAccountID") != null){
		if(room == null){
			response.sendRedirect("index.jsp");
		}
	}
	if (room==null) {
		response.sendRedirect("index.jsp");
	} else {
	%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><%= room.getRoomName() %></title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
<meta name="HandheldFriendly" content="true">

<!-- CSS -->
<link rel="stylesheet"
	href="https://dl.dropbox.com/s/tz7tk6d1l13wa6m/chatroom.css">

<!-- Keywords -->
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="title" content="IKnowThatFeelBro Chat room">
<meta name="description"
	content="Secure / Private / Beautiful Online Group Chat">
<meta name="Keywords"
	content="secure, chat, chatstep, step, private, privacy, encryption, encrypted, group, room, drag, drop, image, share">



<link rel="manifest" href="/manifest.json">


<script async="" type="text/javascript"
	src="https://www.googletagservices.com/tag/js/gpt.js"></script>
<script async="" src="//www.google-analytics.com/analytics.js"></script>
<script>
		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		ga('create', 'UA-59501707-1', 'auto');
		ga('send', 'pageview');

		window.onerror = function(message, url, lineNumber) {  
			ga('send', 'event', 'js_err', message + " _IN_ " + url + " _AT_ " + lineNumber + " _UA_ " + navigator.userAgent);
			return false;
		};
	</script>
<script type="text/javascript">
	  var googletag = googletag || {};
	  googletag.cmd = googletag.cmd || [];
	  (function() {
	    var gads = document.createElement('script');
	    gads.async = true;
	    gads.type = 'text/javascript';
	    var useSSL = 'https:' == document.location.protocol;
	    gads.src = (useSSL ? 'https:' : 'http:') +
	      '//www.googletagservices.com/tag/js/gpt.js';
	    var node = document.getElementsByTagName('script')[0];
	    node.parentNode.insertBefore(gads, node);
	  })();
	</script>
<body style="overflow: hidden;">
	<!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<div id="front"></div>



	<div id="chatroom" style="display: inline-flex;">
		<div id="sidebar">
			<div class="title">
				<img src="images/106-chat_logo.png">
			</div>
			<div class="room_title">Members</div>
			<div id="room_list">
				<%	for (int i=0; i<room.getMemberList().size(); i++) {
						Account member = room.getMemberList().get(i);
						%>
						<div class="member" color="rgba(255,190,50,1)" member="<%= member.getNickName() %>">
						<a href="MemberPage?memberID=<%=member.getUserName()%>" target="_blank"><span class="member_text" onclick="console.log('<%=member.getNickName()%>')"><%= member.getNickName() %></span></a>
							<input type="hidden" id="username" name="username" value=<%=member.getUserName()%>>
						<span
								class="typing_indicator"><span class="dotNoAnim"
								style="background-color: rgba(255, 190, 50, 1)"></span><span
								class="dot" style="background-color: rgba(255, 190, 50, 1)"></span></span>
						</div>
				<%
					}
				%>
			</div>
			<div class="footer">
				<span class="footer_button settings_button"> <img
					alt="Settings" class="footer_icon"
					src="https://s3.amazonaws.com/chatstep.com/settings.png"> <span
					class="settings_text"> Leave Room </span>
				</span> 
				<% if (session.getAttribute("spectAccountID") == null) { %>
				<span class="footer_button report_button"> <img
					title="Report" class="footer_icon"
					src="https://s3.amazonaws.com/chatstep.com/report.png"> <span
					class="report_text">Report</span>		
				<% } %>
				</span> <span class="footer_button"> <img title="Contact"
					class="footer_icon" style="padding-bottom: 2px;"
					src="https://s3.amazonaws.com/chatstep.com/contact.png"> <span
					class="contact_text" onclick="javascript: alert('To contact us send email at WeKnowThatFeelBro@gmail.com')">Contact Us</span>
				</span>
			</div>
		</div>
		<div id="rows">
				<div class="row action_row">
					<span class="action msg" style="color: undefined">You joined
						the room <%= room.getRoomName()%></span>
				</div>
				
				<%		List<Message> chat = room.getMessageList();
						for (int i=0; i<chat.size(); i++) { %>
							<div class="row action_row">
								<span class="msg" style="color: rgba(180, 225, 34, 1)"><%=chat.get(i).getAuthor() + ": " + chat.get(i).getMessage() %></span>
							</div>
					<%	}%>
		</div>
		<div id="send_message">
			<%if(acc != null){ %>
				<input id="mess" placeholder="Send Message" type="text" onkeyup="start();"/>
			<% }%>
		</div>
		
	</div>

	        <div class="modal" style="display: none;">
		<div class="modal_contents">
			<div class="modal_title">
				<img alt="Share" class="modal_icon share"
					src="https://s3.amazonaws.com/chatstep.com/share.png">Share
			</div>
		</div>
		<div class="dismiss noselect">Cancel</div>
	</div>

	<% if (session.getAttribute("spectAccountID") == null) { %>
	<div class="report" style="display: none;">
		<div class="report_title">
			<img alt="Report" class="report_icon"
				data-echo="https://s3.amazonaws.com/chatstep.com/report.png">Report Person
		</div>
		<div class="report_contents">
			If someone is harrasing you, you can report them by ticking next to their names and clicking submit.
			<form action="reportServlet" method=get>
				<% for (int i=0; i<room.getMemberList().size(); i++) {
					Account member = room.getMemberList().get(i);%>
 				<input type="checkbox" name=<%=member.getUserName()%> value=<%=member.getNickName()%>> <%=member.getNickName()%><br>
 				<% } %>
 				<input type="submit" value="Submit">
</form>
			 <br> <br>
		</div>
		<div class="dismiss noselect">Ok</div>
	</div>
		<% } %>

	<div class="settings" style="display: none;">
		<div class="settings_title">
			<img alt="Settings" class="settings_icon"
				data-echo="https://s3.amazonaws.com/chatstep.com/settings.png">Leaving already?
		</div>
		<div class="settings_contents">
			<span class="footer_button download"> <img
				title="Download Transcript" class="footer_icon"
				data-echo="https://s3.amazonaws.com/chatstep.com/download.png">
				<span class="download_transcript_text" onclick="window.location.href = 'DownloadChat'">Download Transcript</span>
			</span> <span class="footer_button picture"> 
				<img title="Picture"
				class="footer_icon picture_icon"
				data-echo="https://s3.amazonaws.com/chatstep.com/left_my_bubbles.png">
				<span class="LeaveRoom" onclick="window.location.href = 'LeaveRoom';">Leave Room</span>
			</span> 
		</div>
		<div class="dismiss">Cancel</div>
	</div>

	<div id="right_sidebar" style="top: 0px;">
	<body leftMargin=&quot;0&quot; topMargin=&quot;0&quot;
			marginwidth=&quot;0&quot; marginheight=&quot;0&quot;
			rightMargin="300px"
			style="background: transparent&amp;amp; ">
			<div style="color: black"> 
				<h3> Friends </h3>
			</div>
			<div style="color: blue">
			<%	if (session.getAttribute("spectAccountID") == null) {
					HashMap<String, List<String> > map = acc.getFriendMap();
					Iterator<String> it = map.keySet().iterator();
					List<String> togetherID = (List<String>) session.getAttribute("togetherID");
					List<String> togetherName = (List<String>) session.getAttribute("togetherName");
					while(it.hasNext()) {
						togetherID.addAll(map.get(it.next()));
					}
					for (int i=0; i<togetherID.size(); i++) {
						out.println("<h4><a href=Invite?friendname=" + togetherID.get(i) 
								+ "&category=" + cat.getName() + "&number=" + room.getRoomID() + ">" + togetherName.get(i) + "</a><br></h4>");
					}
				}
				%>
			</div>
			<script src="https://dl.dropbox.com/s/neulgirkp14f8hi/myscript.js"></script>
			<script async="" type="text/javascript"
				src="https://www.googletagservices.com/tag/js/check_359604.js"></script>
			<iframe
				src="https://tpc.googlesyndication.com/safeframe/1-0-2/html/container.html"
				style="visibility: hidden; display: none;"></iframe>
			<iframe id="google_osd_static_frame_2432490973733"
				name="google_osd_static_frame"
				style="display: none; width: 0px; height: 0px;"></iframe>
		</body>
		</div>
	
	<script type="text/javascript">
    var webSocket = 
      new WebSocket('ws://localhost:8080/IKnowThatFeelBro/ChatServer');

    webSocket.onerror = function(event) {
      onError(event)
    };

    webSocket.onopen = function(event) {
      onOpen(event)
    };

    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
		var parsed = JSON.parse(event.data);
		if (parsed.type === "system") {
			document.getElementById('rows').innerHTML += '<div class="row action_row">' + 
				'<span class="action msg" style="color: rgba(180, 225, 34, 1)">System: ' + parsed.Message + 
					'</span></div>';
			if (parsed.left == null) {
				document.getElementById('room_list').innerHTML += '<div class="member" color="rgba(255,190,50,1)" member="member">'
					+ '<span class="member_text" onclick="console.log(' + parsed.name + ')">' + parsed.name 
					+ '</span><span class="typing_indicator"><span class="dotNoAnim" style="background-color: rgba(255, 190, 50, 1)">'
					+ '</span><span class="dot" style="background-color: rgba(255, 190, 50, 1)"></span></span> </div>';
			} else {
				document.getElementById('room_list').innerHTML = '';
				<% 	for (int i=0; i<room.getMemberList().size(); i++) { %>
					document.getElementById('room_list').innerHTML += '<div class="member" color="rgba(255,190,50,1)" member="member">'
						+ '<span class="member_text" onclick="console.log(MemberPage?memberID='+<%="\'" + room.getMemberList().get(i).getUserName() + "\'"%> +  ')">' + <%="\'" +  room.getMemberList().get(i).getNickName() + "\'"%>
						+ '</span><span class="typing_indicator"><span class="dotNoAnim" style="background-color: rgba(255, 190, 50, 1)">'
						+ '</span><span class="dot" style="background-color: rgba(255, 190, 50, 1)"></span></span> </div>';
				<% } %>
			}
		} else {
			document.getElementById('rows').innerHTML += '<div class="row action_row">' + 
			'<span class="msg" style="color: rgba(180, 225, 34, 1)">'+ parsed.name + ': ' + parsed.message + 
				'</span></div>'
		}
		$("#rows").animate({ scrollTop: $('#rows')[0].scrollHeight}, 1000);
    }

    function onOpen(event) {
    }

    function onError(event) {
      alert(event.data);
    }
	
    $("#rows").load(function() {
    	$("#rows").animate({ scrollTop: $('#rows')[0].scrollHeight}, 1000);
    });
    function start() {
      if(event.keyCode == 13){
    	  	webSocket.send($('#mess').val());
			$('#mess').val('');
      }
      return false;
    }
    
  </script>
</body>
</html>
<% }%>