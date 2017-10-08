define([ "dojo/request/xhr", "pos/Dialog" ], function(xhr, dialog) {

	posXhr = new Object();
	posXhr.post = function(url, data, callback, error) {
		options = {
			handleAs : "json",
			data : data
		};
		switch (arguments.length) {
		case 2:
			xhr.post(url).then(callback, this.defaultErrorMsg);
			break;
		case 3:
			xhr.post(url, options).then(callback,this.defaultErrorMsg);
			break;
		case 4:
			xhr.post(url, options).then(callback, this.defaultErrorMsg);
			break;
		default:
			console.log("Invalid function call");
			posXhr.defaultErrorMsg();
			break;

		}
		return this;

	}
	posXhr.defaultErrorMsg = function(err) {
		dialog.showDialog("The error " + err + " occured");
	}
	return posXhr;
});