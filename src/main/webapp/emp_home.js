/**
 * 
 */
window.onload = function(){
	console.log('emp_home Dom Ready');
	loadNavbar();
}

var navbar = null;
function loadNavbar(){
	console.log('Loading Navbar');
	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received navbar fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			navbar = xhr.responseText; //html fragment, no need to parse
			document.getElementById("navbar").innerHTML = navbar;
			/*
			 * once the navbar has loaded we want to set Event Listeners for changing the views
			 */
			//document.getElementById('revatureHome').addEventListener("click", loadRevatureHomeView, false);
			//document.getElementById('tx').addEventListener("click",loadTxView, false);
			document.getElementById('reimbursement').addEventListener("click",loadReimbursementView, false);
			document.getElementById('pending').addEventListener("click",loadHistoryOfPendingView, false);
			document.getElementById('profile').addEventListener("click",loadProfileView, false);
			document.getElementById('resolved').addEventListener("click",loadHistoryOfResolvedView, false);
			//document.getElementById('logout').addEventListener("click",doLogOut, false);
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxNavbar", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
	
}

function loadEmployeeHomeView(){
	console.log('Loading EmployeeHomeView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received Employee_Home fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getBankUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxEmployeeHomeView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//*************************************** Profile
function loadProfileView(){
	console.log('Loading ProfileView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received Profile fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			getUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxProfileView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}


var ersUser = null;
function getUserInfo(){
	//Use AJAX to grab the JSON object from server that holds bank user data
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			//bankUser = xhr.responseText;
			ersUser = JSON.parse(xhr.responseText); //BankUserDTO parsed into JS
			document.getElementById("empFirstName").innerHTML = ersUser.firstName;   //profile.html
			document.getElementById("empUserName").innerHTML = ersUser.username;
			document.getElementById("empPassword").innerHTML = ersUser.password;
			document.getElementById("empEmail").innerHTML = ersUser.email;
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxGetErsUserInfo", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//*************************************************************************************
//******************************************* Reimbursement 
function loadReimbursementView(){
	console.log('Loading ReimbursementView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received Reimbursement fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxReimbursementView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//************************************************************************************
//******************************************* History of pending
function loadHistoryOfPendingView(){
	console.log('Loading loadHistoryOfPendingView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received pending fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxHistoryOfPendingView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}
//************************************************************************************
//******************************************* History of resolved
function loadHistoryOfResolvedView(){
	console.log('Loading loadHistoryOfResolvedView!!');
 	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received resolved fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxHistoryOfResolvedView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}

/*function doLogOut(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('logout fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("logout").innerHTML = xhr.responseText;
			//getHistoryOfPending();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "logout", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
}*/
