<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/simple.css">
</head>
<body>
	
	
	<h1>Min Side</h1>
	
	<form action="minside" method="post">
		<fieldset>
		<legend>kunde: ${kunde.fornavn} ${kunde.etternavn}</legend>
		<legend>utleie eller retur av bil</legend>
		
			start utleie av bil: 
			<input type="submit" name="valg" value="utleie"/><br>
			
			<p style="color:red">${redirectMessage}</p>
			sjekk om du har noen utleide biler som skal returneres:
			<input type="submit" name="valg" value="retur"/><br>
	
		</fieldset>
	</form>
	
	<form action="logout" method="post">
	  <fieldset>
	  		<p><input type="submit" value="Logg ut" /></p>
	  </fieldset>
	</form>
	
</body>
</html>