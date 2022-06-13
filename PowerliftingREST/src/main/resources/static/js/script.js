//EVENT LISTENER
window.addEventListener('load', function(evt) {
	console.log('script.js loaded');
	init();
});


//initilize form
function init() {
	console.log('In init()');
	loadTrainingList();
	document.newTrainingDayForm.addTrainingDayButton.addEventListener('click', addNewTrainingDay);
	document.updateTrainingDayForm.updateTrainingDayButton.addEventListener('click', updateTrainingDay);
	document.deleteTrainingDayForm.deleteTrainingDayButton.addEventListener('click', deleteTrainingDay);

}


//----CREATE TRAINING DAY----

//ADD A NEW TRAINING DAY PLAN
//JSON
function addNewTrainingDay(evt) {

	evt.preventDefault();

	console.log("create operation start");

	let form = document.newTrainingDayForm;
	let newTrainingDay = {
		trainingLift: form.trainingLift.value,
		firstSetWeight: form.firstSetWeight.value,
		secondSetWeight: form.secondSetWeight.value,
		thirdSetWeight: form.thirdSetWeight.value,
		amrapWeight: form.amrapWeight.value,
		userId: 1
	};
	console.log(newTrainingDay);
	sendNewTrainingDay(newTrainingDay);
}

//SEND THE NEW SERIES REQUEST
//XMLHttpRequest POST
function sendNewTrainingDay(newTrainingDay) {

	console.log("sending create request");

	let xhr = new XMLHttpRequest();
	console.log(newTrainingDay);

	xhr.open('POST', `api/trainingDayLifts`);
	xhr.onreadystatechange = function() {
		if (xhr.status === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let trainingDay = JSON.parse(xhr.responseTest);

				console.log("create operation succesful");
				console.log(trainingDay);

				loadTrainingList();
			}
			else {
				console.error("create operation failed");
				displayError('Error creating series: ' + xhr.status + " " + xhr.statusText);
				console.trace();
			}
		}
	};

	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newTrainingDay));


	console.log("create operation finished");
}


//-----UPDATE TRAINING DAY-----

function updateTrainingDay(evt) {

	evt.preventDefault();

	console.log("UPDATE operation start");



	console.log("UPDATE operation is a go");
	let form = document.updateTrainingDayForm;

	let trainingDayUpdater = {
		id: form.id.value,
		trainingLift: form.trainingLift.value,
		firstSetWeight: form.firstSetWeight.value,
		secondSetWeight: form.secondSetWeight.value,
		thirdSetWeight: form.thirdSetWeight.value,
		amrapWeight: form.amrapWeight.value
	};
	sendUpdateTrainingDay(trainingDayUpdater, trainingDayUpdater.id);
}

function sendUpdateTrainingDay(trainingDayUpdater, updateId) {

	console.log("sending UPDATE request");
	let xhr = new XMLHttpRequest();
	xhr.open("PATCH", "api/trainingDayLifts/" + trainingDayUpdater.id);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				//let updatedTrainingDay = JSON.parse(xhr.responseText);

				loadTrainingList();
			}
			else {

				console.error("UPDATE operation failed");
				console.error(xhr.status + ': ' + xhr.responseText);
				console.trace();
			}
		}
	};
	console.log(trainingDayUpdater);
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(trainingDayUpdater, updateId));

	console.log("UPDATE operating finished");

}


//-----DELETE TRAINING PLAN-----

function deleteTrainingDay(evt) {

	evt.preventDefault();

	let xhr = new XMLHttpRequest();

	let deleteTrainingDay = document.deleteTrainingDayForm.deleteTrainingDay.value;
	console.log(deleteTrainingDay);
	xhr.open("DELETE", "api/trainingDayLifts/delete/" + deleteTrainingDay);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 204) {
				console.log("DELETE operation succesful");
				loadTrainingList();
			}
			else {

				console.error("DELETE operation failed");
				console.error(xhr.status + ': ' + xhr.responseText);
				console.trace();
			}
		}
	};
	xhr.send();
}

//----DISPLAY ALL TRAINING DAYS----
//LOAD TRAINING DAY LIFTS
//XMLHttpRequest GET
function loadTrainingList() {
	console.log("load training list");
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "api/trainingDayLifts")
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let trainingDay = JSON.parse(xhr.responseText);
				console.log("load training list finished");
				displayTrainingList(trainingDay);
			}
			else {
				console.log("Error retrieve list");
				console.error(xhr.status + ': ' + xhr.responseText);
				console.trace();
			}
		}
	};
	xhr.send();
}


//CREATE THE TABLE TO DISPLAY TRAINING DAYS
function displayTrainingList(trainingDayList) {

	//*trainingDayRow points to the table row id inside the html file*
	let tbody = document.getElementById('trainingDayRows');
	tbody.textContent = '';

	//refresh the list
	while (tbody.firstElementChild) {

		tbody.removeChild(tbody.firstElementChild);

	}


	var countLifts = document.getElementById('countLifts');
	var divBench = document.getElementById('benchWorkouts');
	var divSquat = document.getElementById('squatWorkouts');
	var divDeadlift = document.getElementById('deadliftWorkouts');




	var trainingTotal = 0;
	var benchCount = 0;
	var squatCount = 0;
	var deadliftCount = 0;


	for (let trainingDayLift of trainingDayList) {

		let tr = document.createElement('tr');
		tbody.appendChild(tr);

		let td = document.createElement('td');
		td.textContent = trainingDayLift.id;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = trainingDayLift.trainingLift;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = trainingDayLift.firstSetWeight;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = trainingDayLift.secondSetWeight;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = trainingDayLift.thirdSetWeight;
		tr.appendChild(td);

		td = document.createElement('td');
		td.textContent = trainingDayLift.amrapWeight;
		tr.appendChild(td);

		//get total amount of weight lifted
		//counts the total amount of weight lifted in this workout (531 sets only)
		//DATA AGGREGATION
		trainingTotal = ((trainingDayLift.firstSetWeight) + (trainingDayLift.secondSetWeight) + (trainingDayLift.thirdSetWeight));
		console.log("Training Total: " + trainingTotal);

		td = document.createElement('td');
		td.textContent = trainingTotal;
		tr.appendChild(td);


		//find the total number of each lift. Bench, squat, or dead lift
		if (trainingDayLift.trainingLift === "Bench") {
			benchCount += 1;
			console.log("Bench Count:" + benchCount);
		}

		if (trainingDayLift.trainingLift === "Squat") {
			squatCount += 1;
			console.log("Squat Count:" + squatCount);
		}

		if (trainingDayLift.trainingLift === "Deadlift") {
			deadliftCount += 1;
			console.log("Dead Lift Count:" + deadliftCount);
		}


	}


	//total bench workouts
	divBench.textContent = benchCount;


	//total squat workouts
	divSquat.textContent = squatCount;
	

	//total deadlift workouts
	divDeadlift.textContent = deadliftCount;
;

	//COMBINE EVENTS
	//USE TRAVERALS
	//tr.addEventListener('click', showTrainingDayDetails);
}


//function showTrainingDayDetails(evt) {

//	evt.preventDefault();
	//let row = evt.target;

//	console.log(row);
//	let trainingDayId = row.parentElement.firstElementChild.textContent;
//	console.log('Details for training day id ' + trainingDayId);
	// TODO

//}

