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
//			document.getElementById('pending').addEventListener("click",loadHistoryOfPendingView, false);
//			document.getElementById('profile').addEventListener("click",loadProfileView, false);
//			document.getElementById('resolved').addEventListener("click",loadHistoryOfResolvedView, false);
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
			getUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "ajaxEmployeeListView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}