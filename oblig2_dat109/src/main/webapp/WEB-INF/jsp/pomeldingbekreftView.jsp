<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		 Fornavn: ${kunde.fornavn} <br>
		Etternavn: ${kunde.etternavn} <br>
		Mobil: ${kunde.mobil} <br>
		Addresse: ${kunde.addresse} <br>
		kortnummer: ${kunde.kortnr} <br>
	</p>
	
	<form action="pomeldingbekreft" method="post">
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