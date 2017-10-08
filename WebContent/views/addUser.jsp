<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add New User</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/dojoRoot/dijit/themes/claro/claro.css" />
<script>
	dojoConfig = {
		parseOnLoad : true,
		baseUrl : "${pageContext.request.contextPath}/js/dojoRoot/",
		packages : [ {
			name : "dojo",
			location : "dojo/"
		}, {
			name : "dijit",
			location : "dijit/"
		}, {
			name : "dojox",
			location : "dojox/"
		}, {
			name : 'pos',
			location : 'pos/'
		} ]
	}
</script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dojoRoot/dojo/dojo.js"></script>
</head>
<body class="claro">
	<form data-dojo-type="dijit/form/Form" id="loginForm">
		<input type="text" data-dojo-type="dijit/form/TextBox" id="username" /><br>
		<input type="password" data-dojo-type="dijit/form/TextBox"
			id="password" /><br>
		<button data-dojo-type="dijit/form/Button" id="submit">Submit</button>
	</form>
	<script>
		var submitUrl = "${pageContext.request.contextPath}/users/addUser.do";
		require([ "dojo/on", "pos/Dialog", "pos/AjaxPost", "dojo/ready" ],
				function(on, dialog, ajax, ready) {
					ready(function() {
						on(submit, 'click', function() {
							data = {
								'name' : username.value,
								'pswd' : password.value
							};
							ajax.post(submitUrl, data, function(response) {
								message = dojo.fromjson(response);
								dialog.showDialog(message.status,message.content);
							});
						});
					});
				})
	</script>
</body>
</html>