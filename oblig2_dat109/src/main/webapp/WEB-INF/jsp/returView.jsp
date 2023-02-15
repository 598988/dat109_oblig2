<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<link rel="stylesheet" href="css/main.css">
<script defer src="js/PassordValidator.js"></script>
<title>Retur</title>
</head>
<body>


	<form action="retur" method="post">
	  <fieldset><legend>Retur av av leiebil</legend>
	 	<p>Valgt hentested for bil: ${utleie.utleiested.addresse}</p>
	  	<p>Valgt retursted for bil: ${utleie.retursted.addresse}</p>
	  	<p>Bilen som ble valg for leie: ${utleie.regnr.merke} ${utleie.regnr.model} ${utleie.regnr.regnr}</p>
	 	
		<p>Levert leie dato:   <input type="text" title="skirv inn i datoformat" name="dato" placeholder="Fyll inn dato" pattern="[0-3]{1}[0-9]{1}[,]{1}[0-1]{1}[0-9]{1}[,]{1}[0-9]{4}" required="required"/></p>
	  	<p>Levert leie tid:   <input type="text" title="skriv inn i tidformat" name="tid" placeholder="Fyll inn tid" pattern="[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}" required="required"/></p>
		<p>Skriv inn antall kilometer kjort: <input type="number" name="kiloMeter" min="1" max="999" required="required">
		
		
	    <p><input type="submit" value="Gaa til betaling" /></p>
	  </fieldset>
	</form>


</body></html>