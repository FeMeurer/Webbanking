function showTransactionList() {
    var contentDiv = document.getElementById("content");
    cleanDiv(contentDiv);

    var headlineDiv = document.getElementById("headline");
    headlineDiv.innerHTML = "Zahlungen"
	
	var flexbox = document.createElement("div");
	flexbox.id = "flexbox-container"
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
    json.forEach(element => {
        var transaction = element.receiver + " " + element.iban + " " + element.bic + " "  + element.purpose + " " + element.amount;

        //Create TSC element
        var divElement = document.createElement("div");
        divElement.className = "transaction-select-container"
        divElement.id = element.id;

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
        var textElement = document.createTextNode(parseFloat(element.amount).toFixed(2) + "€")
        amountElement.appendChild(textElement);
        subElement.appendChild(amountElement);

        divElement.appendChild(subElement);

        // Create element for showing purpose
        var subElement = document.createElement("div");
        subElement.className = "tsc-bottom"
        var textElement = document.createTextNode(element.purpose)
        subElement.appendChild(textElement);
        divElement.appendChild(subElement); 
        
        divElement.onclick = showTransaction;
        document.getElementById("flexbox-container").appendChild(divElement);
    });  
}

