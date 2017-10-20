/**
 * 
 */
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