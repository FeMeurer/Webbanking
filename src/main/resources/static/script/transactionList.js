function showTransactionList() {
    if (document.getElementById("userData") == null) {
        var headerDiv = document.getElementById("header-container");
        var userDataDiv = document.createElement("div");
        userDataDiv.id = "userData";
        userDataDiv.innerHTML = "<i class='fas fa-user-circle'></i> " + userSession.name + " " + userSession.surname
        //userDataDiv.addEventListener('click', changeUserData);
        headerDiv.appendChild(userDataDiv);
    }
    
    if (document.getElementById("gotoNewTransaction") == null) {
        var headerDiv = document.getElementById("header-container");
        var newTransactionDiv = document.createElement("div");
        newTransactionDiv.id = "gotoNewTransaction";
        newTransactionDiv.innerHTML = "<i class='fa fa-plus-square'></i> Neue Überweisung"
        newTransactionDiv.addEventListener('click', addTransaction);
        headerDiv.appendChild(newTransactionDiv);
    }

    if (document.getElementById("logout") == null) {
        var headerDiv = document.getElementById("header-container");
        var logoutDiv = document.createElement("div");
        logoutDiv.id = "logout";
        logoutDiv.innerHTML = "<i class='fa fa-sign-out'></i> Abmelden"
        logoutDiv.addEventListener('click', logout);
        headerDiv.appendChild(logoutDiv);
    }

    document.getElementById("gotoIndex").addEventListener('click', showTransactionList);

    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlungen"
	
	var balanceDiv = document.createElement("div");
	balanceDiv.id = "balance-container";
	contentDiv.appendChild(balanceDiv);
	
	var flexbox = document.createElement("div");
	flexbox.id = "flex-container";
	contentDiv.appendChild(flexbox);

    fetch('/' + userSession.id + '/transaction')
        .then(getJsonData)
        .then(readTransactionListJson)
}

function readTransactionListData(data) {
    var json = data.json();
    return json;
}

function readTransactionListJson(json) {
    var balance = 0.00;
    json.forEach(element => {
		balance += element.amount;
		console.log(element);
        //Create TSC element
        var divElement = document.createElement("div");
        divElement.className = "transaction-select-container"
        divElement.id = element.id;

        //Create element for showing date in TSC element
        var date = createDateString(element.creationdate);
        var subElement = document.createElement("div");
        subElement.className = "tsc-top"
        var textElement = document.createTextNode(date)
        subElement.appendChild(textElement);
        divElement.appendChild(subElement); 

        //Create element for showing receiver and amount in TSC element
        var subElement = document.createElement("div");
        subElement.className = "tsc-mid"

        //// Create element for showing receiver 
        var receiverElement = document.createElement("div");
        var textElement = document.createTextNode(element.receiver)
        receiverElement.appendChild(textElement);
        subElement.appendChild(receiverElement);

        //// Create element for showing amount
        var amountElement = document.createElement("div");
        amountElement.innerHTML = '<span class="transaction-num">' + parseFloat(element.amount).toFixed(2) + '€</span>';
        subElement.appendChild(amountElement);

        divElement.appendChild(subElement);

        // Create element for showing purpose
        var subElement = document.createElement("div");
        subElement.className = "tsc-bottom"
        var textElement = document.createTextNode(element.purpose)
        subElement.appendChild(textElement);
        divElement.appendChild(subElement); 
        
        divElement.addEventListener("click", function(){showTransaction(this.id)});
        document.getElementById("flex-container").appendChild(divElement);
    });  
    
    if (json === '{}') {
		noTransDiv = document.createElement("div");
		noTransDiv.className = "notification"
		noTransDiv.innerHTML = "Es sind keine Zahlungsvorgänge vorhanden"
		document.getElementById("flex-container").appendChild(noTransDiv);
	}	
    
	var divBalance = document.getElementById("balance-container");
	divBalance.innerHTML = 'Gesamt: <span class="transaction-num">' + parseFloat(balance).toFixed(2) + '€</span>';
	colorNumbers();
}


function colorNumbers() {
	var numbers = document.getElementsByClassName("transaction-num")
	Array.prototype.forEach.call(numbers, function(element) {
		if (element.innerHTML.replace("€","") < 0) {
			element.classList.add('redFont');
		} 
		else {
			element.classList.add('greenFont');
		}
	});
}