function eNameValidation(eName1,enameErr) 
{	
	var eName=$('#'+eName1).val();	
    if (eName == "" || eName.length <= 2) 
    {
    	$('#'+enameErr).html("Name is mandatory.");
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
	}
	else
	{
		$('#'+eGenderErr).html("");
	}
}

function empPassValidation(empPassId,empPassErr)
{
	var ePassId=$('#'+empPassId).val();
	if(ePassId=="")
	{
		$('#'+empPassErr).html("Password is mandatory.");
	}
	else
	{
		$('#'+empPassErr).html("");
	}
}

function empCfPassValidation(empCfPassId,empCfPassErr,empPassId)
{
	var ePassId=$('#'+empPassId).val();
	var eCfPassId=$('#'+empCfPassId).val();
	if(eCfPassId=="")
	{
		$('#'+empCfPassErr).html("Confirm Password is mandatory.");
	}
	else if(ePassId !=eCfPassId)
	{
		$('#'+empCfPassErr).html("Passwords doesn't match.");
		$('#'+empCfPassId).focus();
	}
	else
	{
		$('#'+empCfPassErr).html("");
	}
}

function empAgeValidation(empAgeId,empAgeErr)
{
	var eAge=$('#'+empAgeId).val();
	var illegalChars = /\W/; 
    if (eAge == "" || eAge<18 || eAge>60 || eAge.length<2) 
    {
    	$('#'+empAgeErr).html("Enter valid Age");
    	$('#'+empAgeId).focus();
        return false;   
    }
    else
    {
    	$('#'+empAgeErr).html("");
    	return true;
    }
}

function empPhnoValidation(empPhnoId,empPhnoErr)
{
	var ePhno=$('#'+empPhnoId).val();
	var illegalChars = /\W/; 
    if (ePhno == "" || ePhno.length<10) 
    {
    	$('#'+empPhnoErr).html("Enter valid mobile number");
    	$('#'+empPhnoId).focus();
        return false;   
    }
    else
	{
		if (ePhno.length < 10) 
		{
			$("#" + empPhnoErr).html("Please Enter Valid Mobile Number").show();
			$('#'+empPhnoId).focus();
		} 
		else 
		{
			$("#"+ empPhnoErr).html("");
			if (!(ePhno.charAt(0) == "9" || ePhno.charAt(0) == "8"
					|| ePhno.charAt(0) == "7" || ePhno.charAt(0) == "6")) 
			{
				$("#" + empPhnoErr).html("Please Enter Valid Mobile Number").show();				
			} 
			else 
			{
				$("#"+ empPhnoErr).html("");
			}
		}		
	}
}

function funAgeBlure(fieldName, error) 
{
	$("#" + error).html("");
	var ageNo = $('#' + fieldName).val();	
	if (ageNo == '') 
	{
		$("#" + error).html("Age should not be empty").show();	
	} 
	else 
	{
		var str = Array.from(ageNo);
		if (str[0] == 0) 
		{
			$("#" + error).html("Age should not start with 0").show();
		}
		else if (ageNo < 18) 
		{
			$("#" + error).html("Age must be between 18 to 120").show();
		} 
		else if (ageNo > 120) 
		{
			$("#" + error).html("Age must be between 18 to 120").show();
		} 
		else {
			$("#" + error).html("");
		}
	}
}

function empAddrValidation(empAddrId,empAddrErr)
{
	var eAddr=$('#'+empAddrId).val();
	var illegalChars = /\W/; 
    if (eAddr == "" || eAddr.charAt(0)=="#" || eAddr.charAt(0)=="&" || 
    		 eAddr.charAt(0)=="." ||eAddr.charAt(0)=="/") 
    {
    	$('#'+empAddrErr).html("Enter valid address");
    	$('#'+empAddrId).focus();
        return false;   
    }
    else
    {
    	$('#'+empAddrErr).html("");
    	return true;
    }
}

function empDobValidation(empDobId,empDobIdErr)
{
	var eDob=$('#'+empDobId).val();
    if (eDob == "") 
    {
    	$('#'+empDobIdErr).html("Date of birth is mandatory.");
    	$('#'+empDobId).focus();
        return false;   
    }
    else
    {
    	$('#'+empDobIdErr).html("");
    	return true;
    }
}

/*$(function() 
	 	{
	 		$("#empDobId").datepicker(
	 		{
	 			autoclose:true,
	 			changeMonth:true,
	 			changeYear:true,
	 			yearRange: "-30:+30",
	 			daysOfWeekDisabled : [0,6]
	 		});
	 		
	 		$('#submit').click(function(event)
	 		{	
	 			var eId=$('#employeeId').val();
	 			var eName=$('#empNameId').val();
	 			var eDob=$('#empDobId').val();
	 			var eGender=$('#empGenderId').val();
	 			var ePassword=$('#empPassId').val();
	 			var eCnfPassword=$('#empCfPassId').val();
	 			var ePhoneNo=$('#empPhnoId').val();
	 			var emAge=$('#empAgeId').val();
	 			var eAddress=$('#empAddrId').val();
	 			alert(eName+" "+eGender+" "+ePassword+" "+eCnfPassword+" "+ePhoneNo+" "+emAge+" "+eAddress);
	 			if(eName=="" || eGender=="" || ePassword=="" || eCnfPassword=="" ||
	 					empPhoneNo=="" || emAge=="" || eAddress=="" )
	 			{
	 				alert("All fields are mandatory");
	 			}
	 		});
	 	});*/


$(document).ready(function()
	{
		$("#empDobId").datepicker(
		{
	 		autoclose:true,
	 		changeMonth:true,
	 		changeYear:true,
	 		yearRange: "-30:+30",
	 		daysOfWeekDisabled : [0,5]
	 	});
		
		
		$('#empNameId').keyup(function(e)  
		{
			$(this).val($(this).val().toUpperCase());  //All letters to capital
			
			/*$('#empNameId').val($('#empNameId').val().charAt(0).toUpperCase()+$('#empNameId').val().slice(1));   //First letter to upper case.
*/			
			var eName=$("#empNameId").val();
			if (/([a-zA-Z0-9])\1{2,}/.test(eName))       //Three consecutive letters are not allowed.
			{
				$('#empNameId').val("");
				$('#empNameId').focus();				
				return false;
			}
		});
		
		$("#empNameId").keypress(function(e) //allows only small, capital alphabets and space.
				{
					var _keyCode = e.which;
					if (!((_keyCode >= 65 && _keyCode <= 90)|| (_keyCode >= 97 && _keyCode <= 122)
										 || (e.which == 32))) 
					{
						e.preventDefault();
					}
				});
		
		$("#empPhnoId").keypress(function(e) //allows only small, capital alphabets and space.
				{
					var _keyCode = e.which;
					if (!((_keyCode >= 48 && _keyCode <= 57))) 
					{
						e.preventDefault();
					}
				});
		
		$("#empAgeId").keypress(function(e) //allows only small, capital alphabets and space.
				{
					var _keyCode = e.which;
					if (!((_keyCode >= 48 && _keyCode <= 57))) 
					{
						e.preventDefault();
					}
				});
		
		$("#empAddrId").keyup(function(e) 
		{
			
			var eAddr=$("#empAddrId").val();
			$('#empAddrId').val($('#empAddrId').val().toUpperCase()); 
			if (/([a-zA-Z0-9])\1{2,}/.test(eAddr))       //Three consecutive letters are not allowed.
			{
				$('#empAddrId').val("");
				$('#empAddrId').focus();				
				return false;
			}
					var _keyCode = e.which;
					if (!((_keyCode >= 65 && _keyCode <= 90)|| (_keyCode >= 97 && _keyCode <= 122)
							|| (_keyCode >= 48 && _keyCode <= 57)|| (e.which == 32) 
							||(e.which == 47) ||(e.which == 45)||(e.which == 35) ||
							(e.which == 38))) 
					{
						e.preventDefault();
					}
				});
		
		$('#submit').click(function(e)
		{
			var eId=$('#employeeId').val();
			var eName=$('#empNameId').val();
			var eGender=$('#empGenderId').val();
			var ePassword=$('#empPassId').val();
			var eCnfPassword=$('#empCfPassId').val();
			var ePhoneNo=$('#empPhnoId').val();
			var emAge=$('#empAgeId').val();
			var eAddress=$('#empAddrId').val();
			//alert(eName+" "+eGender+" "+ePassword+" "+eCnfPassword+" "+ePhoneNo+" "+emAge+" "+eAddress);
			if(!eName=="" && !eGender=="" && !ePassword=="" && !eCnfPassword=="" &&
					!empPhoneNo=="" && !emAge=="" && !eAddress=="" )
			{
				/*var form = $('#EmployeeModel')[0];
				var formdata = new FormData(form);*/
				alert(formdata);
				$("#emptyErr").html("");
			}
			else
			{
				$("#emptyErr").html("All fields are mandatory.");
				alert("All fields are madatory");
				return false;
				/*e.preventDefault();*/
			}
	        /*console.log(formdata);
	        var search = {
	        		"EmpId" : eId,"EmpName" : eName,"EmpGender" : eGender,"EmpPass" : ePassword,
	        				"EmpCfPass" : eCnfPassword,"EmpPhno" : ePhoneNo,"EmpAge" : emAge,  "EmpAddress" : eAddress,
	        }
			if(true)
			{
				//alert("sadfa");
				$.ajax({
					type:"POST",
					 enctype : 'multipart/form-data',

					url:"register2.html",
					data:"Name = "+eName+"Gender = "+eGender+"Password = "+ePassword+
							"CnfPassword = "+eCnfPassword+"Phone number = "+ePhoneNo+
							"Age = "+eAge+"Address = "+eAddress,
					 data : search,

					success: function(response)
					{
						alert(response);
					},
					error: function(e)
					{
						alert('Error: '+e);
					}
				});
				alert("submit function");
			}
			else
			{
				//alert("Empty fields are not allowed");
				$('#emptyErr').html("No empty fields are allowed");
			}*/			
		});	
});
