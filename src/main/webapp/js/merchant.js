$(function() {
	$("#editMerchantSearchBoxId").autocomplete(
			{
				source : function(request, response) {
					$.getJSON( "merchantNameAutocomplete", jQuery("#editMerchantFormId").serialize(), function(data) {
						response($.map(data, function(item) {
						    var merchant = item.split(":");
						    return {
							   label : merchant[1], value : merchant[1], merchantId : merchant[0] 
						    }
					   }));
				    });
				},
				minLength : 1,
				select : function(event, ui) {
					if(ui.item.merchantId != 0) {
						jQuery("#editMerchantDetilas").load("landingEditMerchantAction?merchantId="+ui.item.merchantId);
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

function ceateNewMerchant(){
	jQuery('body').load('createMerchantAction', jQuery('#merchantFormId').serialize(), function(responseText, textStatus, XMLHttpRequest){
		if(XMLHttpRequest.status == 200){
			alert("Merchant Created Successfully");
		} else {
			alert("Error Occurred");
		}
	});
}

function updateMerchant(){
	jQuery('#editMerchantDetilas').load('editMerchantAction', jQuery('#editMerchantFormId').serialize(), function(responseText, textStatus, XMLHttpRequest){
		if(XMLHttpRequest.status == 200){
			alert("Merchant Updated Successfully");
		} else {
			alert("Error Occurred");
		}
	});
}