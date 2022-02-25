function cleanDiv(element) {
    while (element.firstChild) {
		element.removeChild(element.firstChild);
	}
}

function createDateString(unformatedDate) {
  var date = new Date(unformatedDate);
  return date.toLocaleDateString('de-DE', {year: 'numeric', month: '2-digit', day: '2-digit', timezone: 'Germany/Berlin', hour: '2-digit', minute: '2-digit' })
}


document.getElementById("gotoIndex").addEventListener('click', showTransactionList);
document.getElementById("gotoNewTransaction").addEventListener('click', addTransaction);
showTransactionList();