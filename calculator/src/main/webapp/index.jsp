<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
input {
    display: table-cell;
    vertical-align: middle
}
input[type='radio']{   
    vertical-align: baseline;
    padding: 10px;
    margin: 10px;
 }
 input[type='date'],input[type='text']{
 display:none;
 }
 

</style>
<script>


function displayInput(){
	 const radiobutton = document.querySelectorAll('input[type="radio"]');
	 let selectedValue;
	 for (const button of radiobutton) {
         if (button.checked) {
             selectedValue = button.value;
             break;
         }
     }
	 if(selectedValue==='1' ||selectedValue==='2')
		 {
		 	document.main.date1.style.display="block";
		 	document.main.date2.style.display="block";
		 	if(selectedValue==='1')
		 		document.getElementById("form").action = '/addDates';
		 	else
		 		document.getElementById("form").action = '/subtractDates';
		 }
	 else if(selectedValue=='14')
		 {
		 document.main.phrase.style.display="block";
		 document.getElementById("form").action = '/phrase';
		
		 }
	 else
		 document.main.date1.style.display="block";
	 	 document.main.n.style.display="block";
	 	document.querySelectorAll("div.menu").forEach(e=>{e.style.display='none'});	 
	 	 if(selectedValue==='3')
	 		document.getElementById("form").action = '/addNDays';
	 	 else if(selectedValue==='4')
	 		document.getElementById("form").action = '/subtractNDays';
		 else if(selectedValue==='5')
		 	document.getElementById("form").action = '/addNWeeks';
		 else if(selectedValue==='6')
		 	document.getElementById("form").action = '/subtractNWeeks';
		 else if(selectedValue==='7')	 
	 		document.getElementById("form").action = '/addNMontbs';
	 	 else if(selectedValue==='8')
	 		document.getElementById("form").action = '/subtractNMonths';
	 	 else if(selectedValue==='9')
	 		document.getElementById("form").action = '/addNYears';
	 	 else if(selectedValue==='10')
	 		document.getElementById("form").action = '/subtractNYears';

}
const allButtons = document.querySelectorAll('input[type="radio"]');
allButtons.onchange = displayInput();

</script>
</head>
<body>

	<div class="main-from">
		<form name="main" action="/calculate" method="get" id="form">
		<div class="menu">
		<input type="radio" name="choice" value="1"/>
		<label>Add two dates</label>
		</div>
		
		<div class="menu">
		<input type="radio" name="choice"  value="2"/>
		<label>Subtract two dates</label>
		
		</div>
		
		<div class="menu">
		<input type="radio" name="choice"  value="3"/>
		<label>Add n days</label>
		
		</div>
		<div class="menu">
		<input type="radio" name="choice"  value="4"/>
		<label>Subtract n days</label>
		</div>
		
		<div class="menu">
		<input type="radio" name="choice"  value="5"/>
		<label>Add n Weeks</label>
		
		</div>
		
		<div class="menu">
		<input type="radio" value="6"/>
		<label>Subtract n Weeks</label>
		</div>
		
		<div class="menu">
		<input type="radio" value="7"/>
		<label>Add n months</label>
		</div>
		
		<div class="menu">
		<input type="radio" value="8"/>
		<label>Subtract n months</label>
		</div>
		
		<div class="menu">
		<input type="radio" value="9"/>
		<label>Add n years</label>
		</div>
		
		<div class="menu">
		<input type="radio" value="10"/>
		<label>Subtract n years</label>
		</div>
		
		<div class="menu">
		<input type="radio" value="14"/>
		<label>Enter Natural phrase</label>
		</div>
		<input type="button" onclick="displayInput();" value="Select"/>
		
		
		<input type="date" name="date1" />
		<input type="date" name="date2"/>
		<input type="text" name="phrase"/>
		<input type="text" name="n" />
		
		
		<input type="submit"/>
		</form>	
	</div>

</body>
</html>