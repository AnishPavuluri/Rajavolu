$(function() {
	$("#userNameSearchId").autocomplete(
			{
				source : function(request, response) {
					$.getJSON( "userNameOrPhoneAutoComplete", jQuery("#editUserForm").serialize(), function(data) {
						console.log("data--->"+data);
						response($.map(data, function(item) {
						    var usr = item.split(":");
						    return {
							   label : usr[1], value : usr[1], userId : usr[0] 
						    }
					   }));
				    });
				},
				minLength : 1,
				select : function(event, ui) {
					jQuery("#editUserDetailsDiv").load("edituser?userId="+ui.item.userId);
				},
				open : function() {
					$(this).removeClass("ui-corner-all").addClass("ui-corner-top");
				},
				close : function() {
					$(this).removeClass("ui-corner-top").addClass("ui-corner-all");
				}
			});
});

function getEditUserLandingPage() {
	jQuery("#editUserDetailsDiv").load("landingEditUser");

}

function getUserSearchLandingPage() {
	jQuery("#searchUsersDiv").load("landingSearchUsersPage");

}

function loadUserSearchResult(){
	jQuery("#userSearchResult").load("searchUsersByNameOrMobileNoOrStatus",jQuery("#userSearchFormId").serialize());
}

function getEditUserLandingPageFromSearchResults(number){
	var userId = jQuery('#user'+number).val();
	console.log("user id--->"+userId);
	jQuery("#editUserDetailsDiv").load("edituser?userId="+userId);
}
