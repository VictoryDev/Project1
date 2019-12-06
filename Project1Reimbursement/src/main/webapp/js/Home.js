/**
 * 
 */

window.onload = function(){
	console.log("Hello -_-")
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/session.do',true);
	xhttp.send();
	getEmployeeInfo();
}

function getEmployeeInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let session = JSON.parse(xhttp.responseText);
			setValues(session);
			console.log("this is user info hello " + session.firstname);
		}
	}
	
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/session.do',true);
	xhttp.send();
}

function setValues(session){
	document.getElementById("hello").innerHTML = "Welcome " + session.firstname + " "+ session.lastname;
	document.getElementById("emp_id").innerHTML = "Employee ID..." + session.employee_id_pk;
	document.getElementById("firstName").innerHTML = "Employee First name..." + session.firstname;
	document.getElementById("lastName").innerHTML = "Employee Last name..." + session.lastname;
	document.getElementById("email").innerHTML = "Employee Email..." + session.email;
	

}

