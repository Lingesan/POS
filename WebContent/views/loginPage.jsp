<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guduvanchery Batteries</title>
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
	var submitUrl = "${pageContext.request.contextPath}/security/checkCredentials.do";
		require([ "dojo/on", "pos/Dialog","pos/AjaxPost" ,"dojo/ready" ],
				function(on, dialog,ajax,ready) {
					ready(function(){
						on(submit,'click',function(){
							data = {
									user:username.value,
									password:password.value
							};
							ajax.post(submitUrl,data,function(){
								dialog.showDialog("Hi");
							});
						});
					});
				})
	</script>
</body>
</html>