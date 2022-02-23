function cleanDiv(element) {
    while (element.firstChild) {
		element.removeChild(element.firstChild);
	}
}

function createDateString(dateString) {
  var date = new Date(dateString);
  return (date.getDay() + "." + date.getMonth() + "." + date.getFullYear() + " " + date.getHours() + ":" + date.getMinutes());
}


document.getElementById("gotoIndex").addEventListener('click', showTransactionList);
document.getElementById("gotoNewTransaction").addEventListener('click', addTransaction);
showTransactionList();