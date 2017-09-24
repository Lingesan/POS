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
	<form data-dojo-type="dijit/form/Form">
		<input type="text" data-dojo-type="dijit/form/TextBox" id="username" /><br>
		<input type="password" data-dojo-type="dijit/form/TextBox"
			id="password" /><br>
		<button data-dojo-type="dijit/form/Button" id="submit">Submit</button>
	</form>
	<script>
		require([ "dojo/on", "pos/Dialog", "dojo/ready" ],
				function(on, dialog,ready) {
					ready(function(){
						on(submit,'click',function(){
							dialog.show();
						});
					});
				})
	</script>
</body>
</html>