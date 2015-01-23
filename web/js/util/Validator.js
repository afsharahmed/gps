/* 
 * ********************************************************************************
 * @author Afshar Ahmed
 * @desc Script for validations required throughout the Enablet application.
 * @date Wed Apr 27, 2011
 * ********************************************************************************
 */

/*
 * Constructor for 'Validator' 
 */ 
function Validator()
{
	// Expression for lower & upper case strings
	this.regExName = new RegExp("^[a-zA-Z]+$");
	
	// Expression for lower & upper case strings with spaces
	this.regExNameWithSp = new RegExp("^[a-zA-Z\\s]+$");
	
	// Expression for lower & upper case strings with spaces & underscores
	this.regExNameWithSpUscr = new RegExp("^[a-zA-Z\\s\\_]+$");
	
	// Expression for email string
	this.regExEmail = new RegExp("^[a-zA-Z0-9_\\@\\&\\*\\(\\)\\.\\-\\'\\s]+$");
	
	// Expression for only numbers
	this.regExNumber = new RegExp("^[0-9]*$");
	
	// Expression for alphanumeric string
	this.regExAlphaNumeric = new RegExp("^[a-zA-Z0-9]*$");
	
	// Expression for alphanumeric string with space
	this.regExAlphaNumericWithSpace = new RegExp("^[a-zA-Z0-9\\s]+$");
	
	// Expression for phone numbers of the form +9112345678
	this.regExPhoneNumber = new RegExp("^\\+?[0-9]*$");
	
	// Expression for http/https URL
	this.regExURL = new RegExp("^(http[s]?://|ftp://)?(www\.)?[a-zA-Z0-9-\.]+\.(com|org|net|mil|edu|ca|co.uk|com.au|gov)$");
}

/*
 * Function to validate name
 */
Validator.prototype.validateName = function ( str, regEx )
{
//		if( regEx.test( str ) != true )
//		{
//			   
//	                   
//	         return false;
//	    }
//		else
//			return true;
	
	
	return regEx.test( str );
};

/*
 * Function to validate number
 */
Validator.prototype.validateNumber = function ( elementId, msgContainer )
{
	var element = document.getElementById(elementId);
	
	if(element && element.value.length > 0 )
	{
		focus = false;
		
		if( regExNumber.test( element.value ) != true )
		{
			 showError("Please enter a valid number.", msgContainer);
	 		
	         element.focus();  
	                   
	         return false;
	    }
	    else 
	    	hideMsg(msgContainer);
	}
	
	return true;
};	
	

/*
 * Function to validate email
 */	
Validator.prototype.validateEmail = function ( elementId, msgContainer )
{
	var element = document.getElementById(elementId);
	
	if(element && element.value.length > 0 )
	{
		focus = false;
		
		if( regExEmail.test( element.value ) != true )
		{
			 showError("Please enter a valid email.", msgContainer);
	 		
	         element.focus();  
	                   
	         return false;
	    }
	    else 
	    	hideMsg(msgContainer);
	}
	
	return true;
};


Validator.prototype.checkEmail = function ( emailStr )
{
     if (emailStr.length == 0) 
     {
         return true;
     }
     
     var emailPat=/^(.+)@(.+)$/;
     var specialChars="\\(\\)<>@,;:\\\\\\\"\\.\\[\\]";
     var validChars="\[^\\s" + specialChars + "\]";
     var quotedUser="(\"[^\"]*\")";
     var ipDomainPat=/^(\d{1,3})[.](\d{1,3})[.](\d{1,3})[.](\d{1,3})$/;
     var atom=validChars + '+';
     var word="(" + atom + "|" + quotedUser + ")";
     var userPat=new RegExp("^" + word + "(\\." + word + ")*$");
     var domainPat=new RegExp("^" + atom + "(\\." + atom + ")*$");
     var matchArray=emailStr.match(emailPat);
     
     if (matchArray == null) 
     {
         return false;
     }
     
     var user=matchArray[1];
     var domain=matchArray[2];
     
     if (user.match(userPat) == null) {
         return false;
     }
     var IPArray = domain.match(ipDomainPat);
     if (IPArray != null) {
         for (var i = 1; i <= 4; i++) {
            if (IPArray[i] > 255) {
               return false;
            }
         }
         return true;
     }
     var domainArray=domain.match(domainPat);
     if (domainArray == null) {
         return false;
     }
     var atomPat=new RegExp(atom,"g");
     var domArr=domain.match(atomPat);
     var len=domArr.length;
     if ((domArr[domArr.length-1].length < 2) ||
         (domArr[domArr.length-1].length > 3)) {
         return false;
     }
     if (len < 2) {
         return false;
     }
  
  return true;
};
 
// Checks for both empty and valid
Validator.prototype.isMandatoryFieldValid = function ( regEx, elementId, msgContainer, EmptyFieldMsg, InvalidFieldMsg )
{
	if ( elementId.value == "" )
	{
		showError( EmptyFieldMsg, msgContainer );
		focus = true;
		elementId.focus();
	
		return false;
	}
	else if( elementId.value.length > 0 && ( regEx.test( elementId.value ) != true ) )
	{
		showError( InvalidFieldMsg, msgContainer );
		focus = true;
		elementId.focus();
	
		return false;
	}		
	
	return true;
};

// Checks for empty only
Validator.prototype.isFieldEmpty = function ( elementId, msgContainer, EmptyFieldMsg )
{
	if ( elementId.value == "" )
	{
		showError( EmptyFieldMsg, msgContainer);
		focus = true;
		elementId.focus();
	
		return false;
	}	
	
	return true;
};
	