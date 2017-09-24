define(["dijit/Dialog"],function(dialog){
	
	options ={
			title:'POS',
			content:"Nothing to display",
			style:"width:500px"
	}
	posDialog = new dialog(options);
	posDialog.showDialog = function()
	{
		length = arguments.length;
		switch(length)
		{
		case 1:	posDialog.set('content',arguments[0]);
				break;
		case 2:	posDialog.set('content',arguments[1]);
				posDialog.set('title',arguments[0]);
				break;
		case 3:	posDialog.set('content',arguments[1]);
				posDialog.set('title',arguments[0]);
				posDialog.set('style',arguments[2]);
				break;
			
		}
		posDialog.show();
		return this;
		
	}
	return posDialog;
})