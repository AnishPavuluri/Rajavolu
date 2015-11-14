$(function() {
	$("#editAgentSearchBoxId").autocomplete(
			{
				source : function(request, response) {
					$.getJSON( "agentNameAutocomplete", jQuery("#editAgentFormId").serialize(), function(data) {
						response($.map(data, function(item) {
						    var agnt = item.split(":");
						    return {
							   label : agnt[1], value : agnt[1], agentId : agnt[0] 
						    }
					   }));
				    });
				},
				minLength : 1,
				select : function(event, ui) {
					if(ui.item.agentId != 0){
						jQuery("#editAgentDetilas").load("landingEditAgentAction?agentId="+ui.item.agentId);
					} else {
						ui.item.label = '';
						ui.item.value = '';
					}
				},
				open : function() {
					$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
				},
				close : function() {
					$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
				}
			});
});


function ceateNewAgent(){
	jQuery('body').load('createAgentAction', jQuery('#agentFormId').serialize(), function(responseText, textStatus, XMLHttpRequest){
		if(XMLHttpRequest.status == 200){
			alert("Agent Added Successfully");
		} else {
			alert("Error Occurred");
		}
	});
}

function updateAgent(){
	jQuery('#editAgentDetilas').load('editAgentAction', jQuery('#editAgentFormId').serialize(), function(responseText, textStatus, XMLHttpRequest){
		if(XMLHttpRequest.status == 200){
			alert("Agent Edited Successfully");
		} else {
			alert("Error Occurred");
		}
	});
}