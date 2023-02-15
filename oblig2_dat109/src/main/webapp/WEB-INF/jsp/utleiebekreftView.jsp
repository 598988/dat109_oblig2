<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<title>Utleie bekreftelse</title>
</head>
<body>
	<h2>Utleie bekreftelse</h2>
	
	  <fieldset><legend>${kunde.fornavn} ${kunde.etternavn} </legend>
	  		<p>Mobilnummer: ${utleie.kunde.mobil}</p>
	  		<p>Start dato for utleie : ${utleie.datofra}</p>
	  		<p>Start tid for utleie: ${utleie.tidfra}</p>
	  		<p>Retur data for utleie: ${utleie.datotil}</p>
	  		<p>Retur tid for utleie: ${utleie.tidtil}</p>
	  		<p>Valgt hentested for bil: ${utleie.utleiested.addresse}</p>
	  		<p>Valgt retursted for bil: ${utleie.retursted.addresse}</p>
	  		<p>Bilen som ble valg for leie: ${utleie.regnr.merke} ${utleie.regnr.model} ${utleie.regnr.regnr}</p>
	  </fieldset>
	
	
	
	<form action="utleiebekreft" method="post">
	  <fieldset>
	  		<p><input type="submit" value="gå til Minside" /></p>
	  </fieldset>
	</form>
	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Logg ut" /></p>
	  </fieldset>
	</form>
</body></html>