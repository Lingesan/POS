define([ "dojo/request/xhr" ], function(xhr) {
	
	posXhr = new Object();
	
	posXhr.post = function(url,data,callback)
	{
		xhr.post(url,data).then(callback);
	}
});