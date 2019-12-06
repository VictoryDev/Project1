/**
 * 
 */

window.onload = function(){
	console.log("Hello -_-");
	getEmployeeInfo();
}

function getEmployeeInfo(){
	var xhttp = new XMLHttpRequest();
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

//Get PAST JavaScript

let buttonOne = document.getElementById("past_btn");
buttonOne.addEventListener('click', getReimbursementInfo);

function getReimbursementInfo(){
	console.log("Past Button Pressed");
	var xhttpStart = new XMLHttpRequest();
	xhttpStart.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/pastReimbursement.do',true);
	xhttpStart.send();
	console.log("populated past");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setValue(users);
			console.log(users);
			console.log("hihi");
		}
	}
	console.log("before the past open send")
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/getPastReimbursement.do',true);
	xhttp.send();
}

function setValue(users){
	
	var table = document.createElement('table');
	table.setAttribute("class", "table table-hover table-dark");
	var tr = document.createElement('tr');
	
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	var td4 = document.createElement('td');
	var td5 = document.createElement('td');
	var td6 = document.createElement('td');
	
	var text1 = document.createTextNode('Reimbursement ID');
	var text2 = document.createTextNode('Dates');
	var text3 = document.createTextNode("Reimbursement Types");
	var text4 = document.createTextNode("Amount");
	var text5 = document.createTextNode("Reimbursement Status");
	var text6 = document.createTextNode('Submission Date');
	
	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	
	table.appendChild(tr);

	for (var i = 0; i < users.length; i++){
		var tr = document.createElement('tr');
		
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		
		var text1 = document.createTextNode(users[i].reimb_id_pk);
		var text2 = document.createTextNode(users[i].dates);
		var text3 = document.createTextNode(users[i].reimb_type);
		var text4 = document.createTextNode(users[i].amount);
		var text5 = document.createTextNode(users[i].reimb_status);
		var text6 = document.createTextNode(users[i].reimb_description);
		
		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		
		table.appendChild(tr);
		
	}
	
	document.getElementById("past_table").append(table);
	
}

//Get Pending.js


let buttonTwo = document.getElementById("pending_btn");
buttonTwo.addEventListener('click', getPendingReimbursementInfo);

function getPendingReimbursementInfo(){
	console.log("Pending Button Pressed");
	var xhttpStart = new XMLHttpRequest();
	xhttpStart.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/pendingReimbursement.do',true);
	xhttpStart.send();
	console.log("populated pending");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let username = JSON.parse(xhttp.responseText);
			setValu(username);
			console.log("hi");
		}
	}
	
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/getPendingReimbursement.do',true);
	xhttp.send();
}

function setValu(username){
	
	var table = document.createElement('table');
	table.setAttribute("class", "table table-hover table-dark");
	var tr = document.createElement('tr');
	
	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	var td4 = document.createElement('td');
	var td5 = document.createElement('td');
	var td6 = document.createElement('td');
	
	var text1 = document.createTextNode('Reimbursement ID');
	var text2 = document.createTextNode('Dates');
	var text3 = document.createTextNode("Reimbursement Types");
	var text4 = document.createTextNode("Amount");
	var text5 = document.createTextNode("Reimbursement Status");
	var text6 = document.createTextNode('Submission Date');
	
	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	
	table.appendChild(tr);

	for (var i = 0; i < username.length; i++){
		var tr = document.createElement('tr');
		
		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		
		var text1 = document.createTextNode(username[i].reimb_id_pk);
		var text2 = document.createTextNode(username[i].dates);
		var text3 = document.createTextNode(username[i].reimb_type);
		var text4 = document.createTextNode(username[i].amount);
		var text5 = document.createTextNode(username[i].reimb_status);
		var text6 = document.createTextNode(username[i].reimb_description);
		
		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		
		table.appendChild(tr);
		
	}
	console.log("in the pending table");
	document.getElementById("pending_table").append(table);
	
}

