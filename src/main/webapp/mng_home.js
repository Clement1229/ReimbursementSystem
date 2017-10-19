/**
 * 
 */
window.onload = function(){
	//console.log('emp_home Dom Ready');
	loadNavbar();
}

var navbar = null;
function loadNavbar(){
	console.log('Loading Navbar for MANAGER yo');
	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received navbar fragment manager');
		if(xhr.readyState == 4 && xhr.status == 200){
			navbar = xhr.responseText; //html fragment, no need to parse
			document.getElementById("navbar").innerHTML = navbar;
			/*
			 * once the navbar has loaded we want to set Event Listeners for changing the views
			 */
			//document.getElementById('revatureHome').addEventListener("click", loadRevatureHomeView, false);
			//document.getElementById('tx').addEventListener("click",loadTxView, false);
			document.getElementById('viewEmployee').addEventListener("click",loadEmployeeListView, false);
			document.getElementById('pending').addEventListener("click",loadPendingRequestView, false);
//			document.getElementById('submitersId').addEventListener("click",loadSingleEmployeeView, false);
			document.getElementById('resolved').addEventListener("click",loadManagerResolvedView, false);
			//document.getElementById('logout').addEventListener("click",doLogOut, false);
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxNavbarManager", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}

//************************************* View Employee

function loadEmployeeListView(){
	console.log('Loading loadEmployeeListView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received loadEmployeeListView fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxEmployeeListView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//************************************************** Manager view Resolved requests
function loadManagerResolvedView(){
	console.log('Loading loadManagerResolvedView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received manager resolved fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxManagerResolvedView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//*************************************************Manager view Pending requests
function loadPendingRequestView(){
	console.log('Loading loadPendingRequestView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received pending request fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxPendingRequestView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//*********************************view single Employee

/*function loadSingleEmployeeView(){
	console.log('Loading loadSingleEmployeeView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received loadSingleEmployeeView fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxSingleEmployeeView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
}*/