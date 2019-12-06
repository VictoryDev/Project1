/**
 * 
 */

window.onload = function(){
	console.log("Hello -_-")
	getEmployeeInfo();
}

function getEmployeeInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let username = JSON.parse(xhttp.responseText);
			setValues(username);

		}
	}
	
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/session.do',true);
	xhttp.send();
}

function setValues(username){
	document.getElementById("hello").innerHTML = "Welcome " + username.firstname + " "+ username.lastname;
	document.getElementById("emp_id").innerHTML = "Employee ID..." + username.employee_id_pk;
	document.getElementById("firstName").innerHTML = "Employee First name..." + username.firstname;
	document.getElementById("lastName").innerHTML = "Employee Last name..." + username.lastname;
	document.getElementById("email").innerHTML = "Employee Email..." + username.email;
	

}

