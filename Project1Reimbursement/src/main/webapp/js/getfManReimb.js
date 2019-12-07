/**
 * 
 */
window.onload = function() {
	console.log("Hello -_-");
	getEmployeeInfo();
}

function getEmployeeInfo() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let session = JSON.parse(xhttp.responseText);
			setValues(session);
			console.log("this is user info hello " + session.firstname);
		}
	}

	xhttp
			.open(
					"GET",
					'http://localhost:8080/Project1Reimbursement/html/session.do',
					true);
	xhttp.send();
}

function setValues(session) {
	document.getElementById("hello").innerHTML = "Welcome " + session.firstname
			+ " " + session.lastname;
	document.getElementById("emp_id").innerHTML = "Employee ID..."
			+ session.employee_id_pk;
	document.getElementById("firstName").innerHTML = "Employee First name..."
			+ session.firstname;
	document.getElementById("lastName").innerHTML = "Employee Last name..."
			+ session.lastname;
	document.getElementById("email").innerHTML = "Employee Email..."
			+ session.email;
}

// Get PAST JavaScript

let buttonOne = document.getElementById("past_btn");
buttonOne.addEventListener('click', getReimbursementInfo);

function getReimbursementInfo() {
	let xhttpStart = new XMLHttpRequest();
	xhttpStart
			.open(
					"GET",
					'http://localhost:8080/Project1Reimbursement/html/allReimbursement.do',
					true);
	xhttpStart.send();

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setValues(users);
			console.log(users);
			console.log("hihi");
		}
	}
	console.log("before the past open send")
	xhttp
			.open(
					"GET",
					'http://localhost:8080/Project1Reimbursement/html/getAllReimbursement.do',
					true);
	xhttp.send();
}

function setValues(users) {

	var table = document.createElement('table');
	table.setAttribute("class", "table table-hover table-dark");
	var tr = document.createElement('tr');

	var td1 = document.createElement('td');
	var td2 = document.createElement('td');
	var td3 = document.createElement('td');
	var td4 = document.createElement('td');
	var td5 = document.createElement('td');
	var td6 = document.createElement('td');
	var td7 = document.createElement('td');
	var td8 = document.createElement('td');
	var td9 = document.createElement('td');
	var td10 = document.createElement('td');

	var text1 = document.createTextNode('Reimbursement ID');
	var text2 = document.createTextNode('Dates');
	var text3 = document.createTextNode("Reimbursement Types");
	var text4 = document.createTextNode("Amount");
	var text5 = document.createTextNode("Reimbursement Status");
	var text6 = document.createTextNode('Submission Date');
	var text7 = document.createTextNode('Author');
	var text8 = document.createTextNode('Resolver');
	var text9 = document.createTextNode('Reimbursement Status');
	var text10 = document.createTextNode('Reimbursement Type');

	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	td7.appendChild(text7);
	td8.appendChild(text8);
	td9.appendChild(text9);
	td10.appendChild(text10);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	tr.appendChild(td8);
	tr.appendChild(td9);
	tr.appendChild(td10);

	table.appendChild(tr);

	for (var i = 0; i < users.length; i++) {
		var tr = document.createElement('tr');

		var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		var td7 = document.createElement('td');
		var td8 = document.createElement('td');
		var td9 = document.createElement('td');
		var td10 = document.createElement('td');

		var text1 = document.createTextNode(users[i].reimb_id_pk);
		var text2 = document.createTextNode(users[i].dates);
		var text3 = document.createTextNode(users[i].reimb_type);
		var text4 = document.createTextNode(users[i].amount);
		var text5 = document.createTextNode(users[i].reimb_status);
		var text6 = document.createTextNode(users[i].reimb_description);
		var text7 = document.createTextNode(username[i].reimb_author);
		var text8 = document.createTextNode(username[i].reimb_resolver);
		var text9 = document.createTextNode(username[i].reimb_status);
		var text10 = document.createTextNode(username[i].reimb_type);

		td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		td7.appendChild(text7);
		td8.appendChild(text8);
		td9.appendChild(text9);
		td10.appendChild(text10);
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		tr.appendChild(td8);
		tr.appendChild(td9);
		tr.appendChild(td10);
		table.appendChild(tr);

	}

	document.getElementById("view_all_table").append(table);

}
