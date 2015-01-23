
// Function to set the popUp's position and alignment
function setTopLeft(popupDivId) 
{
	var popUpDiv = document.getElementById(popupDivId);
	var INIT_TOP, INIT_LEFT;
	var TOP, LEFT;
	
	popUpDiv.style.display = "block";
	
	var popWidth = popUpDiv.offsetWidth;
	var popHeight = popUpDiv.offsetHeight;
		
	// getting the top left coordinates of the container of this popup
	INIT_TOP = popUpDiv.style.top = popUpDiv.parentNode.style.top;
	INIT_LEFT = popUpDiv.style.left = popUpDiv.parentNode.style.left;
		
	// Truncating the 'px' from the end of string
	INIT_TOP = Number(INIT_TOP.substr(0, INIT_TOP.length - 2));
	INIT_LEFT = Number(INIT_LEFT.substr(0, INIT_LEFT.length - 2));
		
		
	// getting the width and height of display window
	var winWidth = 0, winHeight = 0, d = document;
	
	if (typeof (window.innerHeight) == "number") 
	{
		//for netscape 
		winWidth = window.innerWidth;
		winHeight = window.innerHeight;
	} 
	else 
	{
		if (d.documentElement && d.documentElement.clientHeight) 
		{
			//for internet explorer
			winWidth = d.documentElement.clientWidth;
			winHeight = d.documentElement.clientHeight;
		} 
		else 
		{
			if (d.body && d.body.clientHeight) {}  ///for fire fox
		} 
	}
	
	winWidth = d.body.clientWidth;
	winHeight = d.body.clientHeight;
		
	// calculating the top left of this popup
	TOP = ((winHeight / 2) - (popHeight / 2));
	LEFT = ((winWidth / 2) - (popWidth / 2));
			
	// Checking and adjusting positions for multipli layered popups
	if (INIT_TOP > 0 || INIT_LEFT > 0) 
	{
		TOP = TOP - INIT_TOP;
		LEFT = LEFT - INIT_LEFT;
	}
		
	// correcting negative coordinate error
	if (TOP < 0) TOP = 0;
	
	if (LEFT < 0) LEFT = 0;
	
		
	// assigning coordinated to this popup
	popUpDiv.style.top = TOP + "px";
	popUpDiv.style.left = LEFT + "px";
		
}

// Function to set the popUp Background layer's position and dimensions
function setPageHeightWidth(layerId)
{	
		var pageWidth;
		var pageHeight;
		var element1=document.getElementById(layerId);
		
		element1.style.display='block';
		
		if( window.innerHeight && window.scrollMaxY ) // Firefox 
		{
			pageWidth = window.innerWidth + window.scrollMaxX;
			pageHeight = window.innerHeight + window.scrollMaxY;
		}
		else if( document.body.scrollHeight > document.body.offsetHeight ) // all but Explorer Mac
		{
			pageWidth = document.body.scrollWidth;
			pageHeight = document.body.scrollHeight;
		}
		else // works in Explorer 6 Strict, Mozilla (not FF) and Safari
		{
			
			 pageWidth = document.body.offsetWidth + document.body.offsetLeft;
			 pageHeight = document.body.offsetHeight + document.body.offsetTop; 
		}
		element1.style.height=pageHeight+"px";
		element1.style.width=pageWidth+"px";
//		alert('element1.style.height--'+element1.style.height+'\nelement1.style.width--'+element1.style.width);	
} 

// Function to show popup over existing page
function showPopUp(popupContainerId, popupDivId)
{
	setPageHeightWidth(popupContainerId);
	setTopLeft(popupDivId);
}

// Function to hide popup
function hidePopUp(popupContainerId, popupDivId)
{
	document.getElementById(popupContainerId).style.display = "none";
	document.getElementById(popupDivId).style.display = "none";
}

