<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<link rel="stylesheet" href="css/main.css">
<script defer src="js/PassordValidator.js"></script>
<title>Pomelding</title>
</head>
<body>


	<form action="pomelding" method="post">
	  <fieldset><legend>Pomelding</legend>
	  	<p>fornavn:   <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="fornavn" placeholder="Fyll inn fornavn" pattern="[A-ZÆØÅ]{1}[a-zæøå]{1,19}" required="required"/></p>
	  	<p>etternavn:   <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="etternavn" placeholder="Fyll inn etternavn" pattern="[A-ZæøåÆØÅ]{1}[a-zæøå]{1,19}" required="required"/></p>
	  	<p>mobil:   <input type="text" title="skal vere akurrat 8 siffere" name="mobil" placeholder="Fyll inn mobil" pattern="[0-9]{8}" required="required"/></p>
		<p>addresse:   <input type="text" title="Forste bokstav skal vere stor, og resten liten" name="addresse" placeholder="Fyll inn addresse" pattern="[A-ZæøåÆØÅ]{1}[a-zæøå]{1,19}" required="required"/></p>
		<p>kontonummer:   <input type="text" title="skal vere akkurat 16 sifre" name="kortnummer" placeholder="Fyll inn kontonummer" pattern="[0-9]{16}" required="required"/></p>
	
	    <p><input type="submit" value="Legg til kunde" /></p>
	  </fieldset>
	</form>


</body></html>