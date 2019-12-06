/**
 * 
 */

window.onload = function(){
	let xhttp = new XMLHttpRequest();
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/pastReimbursement.do',true);
	xhttp.send();
	console.log("inside past Reimbursement JS")
}

let buttonOne = document.getElementById("past_btn");
buttonOne.addEventListener('click', getReimbursementInfo);

function getReimbursementInfo(){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setValues(users);
			console.log("hi");
		}
	}
	
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/getPastReimbursement.do',true);
	xhttp.send();
}

function setValues(users){
	
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