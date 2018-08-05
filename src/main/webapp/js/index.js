

function getHome() {
	
	changeInner("text/titles/home.txt", "pagetitle");
	changeInner("text/hello.txt", "loginbody");
	changesrc("text/src/home.txt", "indexbackground");
}

function getInfo() {
	
	changeInner("text/titles/roominfo.txt", "pagetitle");
	changesrc("text/src/img.txt", "indexbackground");
	let xhr = new XMLHttpRequest();  
	if(xhr.readyStaye == 4 && xhr.Status == 200) {
			var title = document.getElementById("pageTitle");
			title.innerHtml = '';
			title.innerHtml = xhr.responseText;
		}
	xhr.open("GET", '/Overlook/IndexHandler');
	xhr.send();
}

function process() {
		
		if(xhr.readyStaye == 4 && xhr.Status == 200) {
			var title = document.getElementById("pageTitle");
			title.innerHtml = '';
			title.innerHtml = 'Room Info';
			
		}
	}

function getAbout() {
	
	changeInner("text/titles/about.txt", "pagetitle");
	changeInner("text/hello.txt", "loginbody");
	changesrc("text/src/img.txt", "image");
	
}

function goToAccount() {
	location.href = "login.html";
}

function changeInner(file, id) {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			document.getElementById(id).innerHTML = xhttp.responseText;
		}
	}
	xhttp.open("GET", file);
	xhttp.send();
}



function changesrc(file, id) {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			document.getElementById(id).setAttribute( "src", xhttp.responseText);
		}
	}
	xhttp.open("GET", file);
	xhttp.send();
}



