<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<link rel="stylesheet" href="css/main.css">
<script defer src="js/PassordValidator.js"></script>
<title>Betaling</title>
</head>
<body>


	<form action="betalretur" method="post">
	  <fieldset><legend>Betaling</legend>
	  
	  	  <fieldset><legend>${kunde.fornavn} ${kunde.etternavn} </legend>
	  		<p>Mobilnummer: ${utleie.kunde.mobil}</p>
	  		<p>Start dato for utleie : ${retur.dato}</p>
	  		<p>Start tid for utleie: ${retur.tid}</p>
	  		<p>Valgt hentested for bil: ${utleie.utleiested.addresse}</p>
	  		<p>Valgt retursted for bil: ${utleie.retursted.addresse}</p>
	  		<p>Bilen som ble valg for leie: ${utleie.regnr.merke} ${utleie.regnr.model} ${utleie.regnr.regnr}</p>
	  		<p>total kjørt kilometer: ${kiloMeter}</p>
	  		<p>total sum blir: ${total}</p>
	  		<p></p>
	  		<P>Det betales med dette kortnummeret: ${kunde.kortnr}</P>
	  		
	  </fieldset>
	  
	    <p><input type="submit" value="trykk her for Betaling" /></p>
	  </fieldset>
	</form>


</body></html>