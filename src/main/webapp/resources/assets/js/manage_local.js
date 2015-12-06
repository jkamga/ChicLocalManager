$(document).ready(function(){
	
	$("#LocaldTextId").removeClass('hidden');
	$("#selecteableLocaldId").addClass('hidden');
	
	
	 $( ".updateLocal" ).bind( "click", function( event ) {
		 
		 $("#selecteableLocaldId").removeClass('hidden');
		 $("#LocaldTextId").addClass('hidden');
		 
		 $("#localIdSelectorForInput").bind("change", function(e){
			var selectedtId = $(this).val();
			if(selectedtId != null && selectedtId != ""){

				for(var j=0;j<localsList.length;j++)
		           {
					if(selectedtId.localeCompare(localsList[j]._id) == 0){
						local = localsList[j];
					}
		       }
			}
			if(local != null){
				$("#capacity").val(local.capacite);
			    $("#floor").val(local.etage);
			    $("#buildingID").val(local.idBatiment[0]._id);
			    $("#description").val(local.description);
			    $("#status").val(local.statut);
			    $("#Equipment").val(local.equipement);
			    $("#localForm").attr("action","updateLocal");
			    $("myModalLabel").html("Update Local");
			}
		 });
		
	});
});


$.ajax({
    type: "POST",
    url: "/getLocals",
    // The key needs to match your method's input parameter (case-sensitive).
    data: null,
    contentType: "application/json; charset=utf-8",
    dataType: "json",
    success: function(data){
                var trimData = $.trim(JSON.stringify(data));
                var obj      = $.parseJSON(trimData);
                if(obj.success == 'true'){ 
                	alert("local id" +obj);
                }
    },
    failure: function(errMsg) {
        alert(errMsg);
    }
});
