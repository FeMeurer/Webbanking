function readData(data) {
    var json = data.json();
    return json;
}

function readJson(json) {
    json.transactions.forEach(element => {
        console.log(element.receiver);
        console.log(element.iban);
        console.log(element.bic);
        console.log(element.institute);
        console.log(element.purpose);
        console.log(element.amount);
    });
    
}

fetch('/json/transactions.json')
    .then(readData)
    .then(readJson)