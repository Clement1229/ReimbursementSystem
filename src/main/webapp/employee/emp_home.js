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
			getBankUserInfo();
		}
	}
	// open the request  ?? where does get go
	xhr.open("GET", "EmployeeHomeView", true); //method, URL, true =>synchronous
	//sent it
	xhr.send();
	
}