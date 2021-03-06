/**
 * 
 */

(function ( $ ) {
	var introduced = $('#introduced');
	var discontinued = $('#discontinued');
	var btnSubmit = $("#btnSubmit");
	
	$('#computerName').prop("required", true);
	
	if(introduced.val() == "") discontinued.prop("disabled", true);	
	
	introduced.change(function(){
		if($("#dateWarning").length > 0) $("#dateWarning").remove();
		if(introduced.val() == "") discontinued.prop("disabled", true);	
		
		var introSplit = introduced.val().split('-');
		var discSplit = discontinued.val().split('-');
		
		var introDate = new Date(introSplit[0], introSplit[1] - 1, introSplit[2]);
		var discDate = new Date(discSplit[0], discSplit[1] - 1, discSplit[2]);

		if(introDate.getTime() > discDate.getTime()) {
			introduced.css("border","1px solid #FF0000").parent().append("<p id='dateWarning' style='color:#FF0000'>Invalid date. Introduced date must have before discontinued date</p>");
			btnSubmit.prop("disabled", true);
		}else {
			introduced.css("border","1px solid #ccc");
			discontinued.css("border","1px solid #ccc");
			discontinued.prop('disabled', false);
			btnSubmit.prop("disabled", false);
		}
	});

	discontinued.change(function(){
		if($("#dateWarning").length > 0) $("#dateWarning").remove();
		
		var introSplit = introduced.val().split('-');
		var discSplit = discontinued.val().split('-');

		var introDate = new Date(introSplit[0], introSplit[1] - 1, introSplit[2]);
		var discDate = new Date(discSplit[0], discSplit[1] - 1, discSplit[2]);

		if(introDate.getTime() > discDate.getTime()) {
			discontinued.css("border","1px solid #FF0000").parent().append("<p id='dateWarning' style='color:#FF0000'>Invalid date. Discontinued date must have after introduced date</p>");
			btnSubmit.prop("disabled", true);
		}else {
			introduced.css("border","1px solid #ccc");
			discontinued.css("border","1px solid #ccc");
			btnSubmit.prop("disabled", false);
		}
	});
}( jQuery ));
