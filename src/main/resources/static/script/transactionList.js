function showTransactionList() {
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

    fetch('/transaction')
        .then(readTransactionListData)
        .then(readTransactionListJson)
}

function readTransactionListData(data) {
    var json = data.json();
    return json;
}

function readTransactionListJson(json) {
    var counter = 0;
    var balance = 0.00;
    json.forEach(element => {
        var transaction = element.receiver + " " + element.iban + " " + element.bic + " "  + element.purpose + " " + element.amount;
	
		balance += element.amount;
		
        //Create TSC element
        var divElement = document.createElement("div");
        divElement.className = "transaction-select-container"
        divElement.id = counter;

        //Create element for showing date in TSC element
        var date = createDateString(element.date);
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
        counter++;
    });  
    
    if (counter == 0) {
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