/**
 * 
 */
//************************************************************************************************************************************************************
// Session
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

}

//************************************************************************************************************************************************************
//Financial manager view all 
let buttonThree = document.getElementById("fMan_viewAll_btn");
buttonThree.addEventListener('click', getReimbursementInfo);
function getReimbursementInfo() {
	var xhttpStart = new XMLHttpRequest();
	xhttpStart.open("GET",'http://localhost:8080/Project1Reimbursement/html/pastEmployeeReimbursement.do', true);
	xhttpStart.send();
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setVal(users);
			console.log(users);
			console.log("inside fMan View All ");
		}
	}
	xhttp.open("GET", 'http://localhost:8080/Project1Reimbursement/html/getPastEmployeeReimbursement.do', true);
	xhttp.send();
}
function setVal(users) {
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
		var text7 = document.createTextNode(users[i].author_id);
		var text8 = document.createTextNode(users[i].resolver_id);
		var text9 = document.createTextNode(users[i].reimb_status);
		var text10 = document.createTextNode(users[i].reimb_type);
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

//************************************************************************************************************************************************************
//View Past History

let buttonTwo = document.getElementById("fMan_past_btn");
buttonTwo.addEventListener('click', getfManPastReimbursementInfo);
function getfManPastReimbursementInfo(){
	var xhttpStart = new XMLHttpRequest();
	xhttpStart.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/pastEmployeeReimbursement.do',true);
	xhttpStart.send();
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setV(users);
			console.log(users);
			console.log("Past Button");
		}
	}
	console.log("before the past open send")
	xhttp.open("GET" , 'http://localhost:8080/Project1Reimbursement/html/getPastEmployeeReimbursement.do',true);
	xhttp.send();
}
function setV(users){
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
	document.getElementById("view_past_table").append(table);
}

//************************************************************************************************************************************************************
//Approve and Deny

let buttonFour = document.getElementById("fMan_approveDeny");
buttonFour.addEventListener('click', getApproveDenyInfo);
//let buttonFive = document.getElementById("submit");
//buttonFive.addEventListener('click', updateReimb)

function updateReimb(){
	
	console.log("inside approve and deny");


	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			update();
			console.log("inside Update Ticket View All ");
		}
	}
	xhttp.open("POST", 'http://localhost:8080/Project1Reimbursement/html/updateTicket.do', true);
	xhttp.send();
}

function update(){
	 var x = document.getElementById("approveDeny").rows[0].cells[0].childNode[0].value;
	  document.getElementById("demo").innerHTML = "Found " + x + " cells in the first tr element.";

}
function getApproveDenyInfo() {

	console.log("inside approve and deny");
	var xhttpStart = new XMLHttpRequest();
	xhttpStart.open("GET",'http://localhost:8080/Project1Reimbursement/html/fManApproveDeny.do', true);
	console.log("fManApproveDeny.do open");
	xhttpStart.send();
	console.log("fManApproveDeny.do send");

	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			console.log(xhttp.responseText);
			let users = JSON.parse(xhttp.responseText);
			setVa(users);
			console.log("What is the users set Va " + users);
			console.log("inside fMan View All ");
		}
	}
	xhttp.open("GET", 'http://localhost:8080/Project1Reimbursement/html/getfManApproveDeny.do', true);
	xhttp.send();
}
function setVa(users) {
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
	
	
	var text1 = document.createTextNode('Reimbursement ID');
	var text2 = document.createTextNode('Dates');
	var text3 = document.createTextNode("Reimbursement Types");
	var text4 = document.createTextNode("Amount");
	var text5 = document.createTextNode("Reimbursement Status");
	var text6 = document.createTextNode('Submission Date');
	var text7 = document.createTextNode("Approve/Deny");
	
	td1.appendChild(text1);
	td2.appendChild(text2);
	td3.appendChild(text3);
	td4.appendChild(text4);
	td5.appendChild(text5);
	td6.appendChild(text6);
	td7.appendChild(text7);
	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);
	tr.appendChild(td5);
	tr.appendChild(td6);
	tr.appendChild(td7);
	
	table.appendChild(tr);

	for (var i = 0; i < users.length; i++){
		var tr = document.createElement('tr');
		
		var tdHidden = document.createElement('button');
		tdHidden.setAttribute("type", "submit");
		tdHidden.setAttribute("name", "victorys");
		tdHidden.setAttribute("id", "victory");
//		tdHidden.setAttribute("onclick", "updateTick()");
		tdHidden.setAttribute("class", "btn btn-dark")
		
		
		//var td1 = document.createElement('td');
		var td2 = document.createElement('td');
		var td3 = document.createElement('td');
		var td4 = document.createElement('td');
		var td5 = document.createElement('td');
		var td6 = document.createElement('td');
		var td7 = document.createElement('td');
		
		var text1 = document.createTextNode(users[i].reimb_id_pk);
		var text2 = document.createTextNode(users[i].dates);
		var text3 = document.createTextNode(users[i].reimb_type);
		var text4 = document.createTextNode(users[i].amount);
		var text5 = document.createTextNode(users[i].reimb_status);
		var text6 = document.createTextNode(users[i].reimb_description);
		//this is the Select button
		let x = document.createElement("SELECT");
		x.setAttribute("id", "approveDenyBtn");
		x.setAttribute("name", "approveDenyBtn");
		td7.appendChild(x);
		var z = document.createElement("option");
		var y = document.createElement("option");
		z.setAttribute("value", "1");
		y.setAttribute("value", "2");
		var t = document.createTextNode("Approve");
		var r = document.createTextNode("Deny");
		z.appendChild(t);
		y.appendChild(r);
//		console.log(document.getElementById("approveDenyBtn").appendChild(z));
//		document.getElementById("approveDenyBtn").appendChild(z);
//		document.getElementById("approveDenyBtn").appendChild(y);
		x.appendChild(z);
		x.appendChild(y)
		td7.appendChild(x)

		//End of Select button
		
		//td1.appendChild(text1);
		tdHidden.setAttribute("value", users[i].reimb_id_pk);
	//	tdHidden.setAttribute("value", "41");
		tdHidden.appendChild(text1);
		console.log("This is TD1 reimb iD "+tdHidden.value);
	
	//	td1.appendChild(text1);
		td2.appendChild(text2);
		td3.appendChild(text3);
		td4.appendChild(text4);
		td5.appendChild(text5);
		td6.appendChild(text6);
		tr.appendChild(tdHidden);
		//tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		
		
		
		table.appendChild(tr);
		
	}
	
	document.getElementById("approveDeny").append(table);
	
}
//
//function updateTick(){
//	console.log("hi victory!");
//	console.log("inside  update.do");
//	var xhttpStart = new XMLHttpRequest();
//	xhttpStart.open("POST",'http://localhost:8080/Project1Reimbursement/html/updateTicket.do', true);
//	console.log("updateTicket.do open");
//	xhttpStart.send();
//	console.log("updateTicket.do send");
//
//}
