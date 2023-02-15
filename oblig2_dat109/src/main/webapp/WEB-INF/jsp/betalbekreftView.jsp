<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<title>Utleie bekreftelse</title>
</head>
<body>
	<h1>Betaling bekreftelse</h1>
	
	<fieldset><legend>Din betaling har suksessfullt blitt motatt</legend>
		<p>kunde: ${kunde.fornavn} ${kunde.etternavn} </p>
	  		
	  		<p>total sum blir: ${total}</p>
	
	  </fieldset>
	
	
	<form action="betalbekreft" method="post">
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