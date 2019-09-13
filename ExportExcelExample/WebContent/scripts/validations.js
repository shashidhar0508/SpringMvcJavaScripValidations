/*$(function() 
		{
			$('#eName').focus();
			$('#eName').blur(function() {
				if ($("#eName").val() != "") 
				{
					var namevalue = $("#eName").val();
					if (namevalue.length <= 2) 
					{
						alert("Please Enter Valid First Name.");
						$("#eName").val("");
						$('#eName').focus();
						return false;
					}
				}
			});
});		


$('#save-submit').click(function(e) {

	if ($('#eName').val() == "") 
	{

		alert("Please Enter First Name.");
		$('#eName').val("");
		$('#eName').focus();
		return false;
	}
});*/

function eNameValidation(eName1,enameErr) 
{
	var eName=$('#'+eName1).val();
	
	var illegalChars = /\W/; 
    if (eName == "") 
    {
    	$('#'+enameErr).html("User id is mandatory.");
    	$('#'+eName1).focus();
        return false;   
    }
    else if (illegalChars.test(eName))
    {
    	$('#'+enameErr).html("Illegal characters are not allowed.");
    	$('#'+eName1).val("");
    	$('#'+eName1).focus();
        return false; 
    } 
    else
    {
    	$('#'+enameErr).html("");
    	return true;
    }
}

function empGenderValidation(eGender,eGenderErr)
{
	var eGender=$('#'+eGender).val();
	if(eGender=="")
	{
		$('#'+eGenderErr).html("Select gender.");
		//alert("Select Gender.");
	}
	else
	{
		$('#'+eGenderErr).html("");
	}
}


function empAgeValidation(empAge)
{
	var eAge=$('#'+empAge).val();
	alert(eAge);
}

function empPhnoValidation(ephno,ephnoerr)
{
	var ePhno=$('#'+empphno).val();
	alert(ePhno);
}

$(document).ready(function()
	{
		$('#submit').click(function(event)
		{
			alert("ajax");
			var eName=$('#empNameId').val();
			var eGender=$('#empGenderId').val();
			var ePassword=$('#empPassId').val();
			var eCnfPassword=$('#empCfPassId').val();
			var ePhoneNo=$('#empPhnoId').val();
			var emAge=$('#empAgeId').val();
			var eAddress=$('#empAddrId').val();
			alert(eName+" "+eGender+" "+ePassword+" "+eCnfPassword+" "+ePhoneNo+" "+emAge+" "+eAddress);
			if(!eName=="" && !eGender=="" && !ePassword=="" && !eCnfPassword=="" &&
					!empPhoneNo=="" && !emAge=="" && !eAddress=="" )
			{
				
				alert("submit function");
			}
			else
			{
				//alert("Empty fields are not allowed");
				$('#emptyErr').html("No empty fields are allowed");
			}
			
		});	
});






/*function ajaxCallFunction()
{
	$.ajax({
		type:"POST",
		url:"loginController",
		cache: false,
		data:'eName=' +$("#eName").val()+ "&emppword=" +$("#emppword").val(),
		dataType: 'json',
		success:function(response)
		
			
		{
			$('#result').html("");
			alert(response[0].eName);
			alert(typeof(response));
			alert(JSON.stringify(response));
			
			alert(typeof(JSON.stringify(response)));
			var abcd=JSON.stringify(response);
			alert(abcd[0]);
			console.log(response[0].eName);
			console.log(JSON.stringify(response));
			console.log(JSON.parse(JSON.stringify(response)));
			$('#result').html("Employee Name:- " + response[0].eName +"</br>Employee Password:- " +  response[0].empPassword);
			
			//$('#result').html("");
			//var obj=JSON.parse(response);
			//$('#result').html(obj.eName);
		}
	});
}*/


















/*function eNameValidation(eNames)
{
	var eName=$('#'+eNames).val();
	alert(eName);
}
*/





/*$(function()
	{
		$('#submit').click(function()
		{
			alert("sfd");	
		});
	
});*/