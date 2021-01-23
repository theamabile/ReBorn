function getParameter(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getParameters() {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));

// "&size=10&key=nickname&searchOption=contain&rule=7&value=a"
}

function MMddHHmm(date){
	let month = "" + (date.getMonth() + 1),
	day = "" + date.getDate(),
	hours = "" + date.getHours(),
	minutes = "" + date.getMinutes();

	if (month.length < 2)
	month = "0" + month;
	if (day.length < 2)
	day = "0" + day;
	if (hours.length < 2)
	hours = "0" + hours;
	if (minutes.length < 2)
	minutes = "0" + minutes;

	return `${month}-${day} ${hours}:${minutes}`;
}