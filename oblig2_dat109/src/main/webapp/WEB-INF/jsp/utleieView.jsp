<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/simple.css">
<link rel="stylesheet" href="css/main.css">
<script defer src="js/PassordValidator.js"></script>
<title>Utleie</title>
</head>
<body>


	<form action="utleie" method="post">
	  <fieldset><legend>Utleie</legend>
	  	<p>Start leie dato:   <input type="text" title="skirv inn i datoformat" name="datoFra" placeholder="Fyll inn dato" pattern="[0-3]{1}[0-9]{1}[,]{1}[0-1]{1}[0-9]{1}[,]{1}[0-9]{4}" required="required"/></p>
	  	<p>Start leie tid:   <input type="text" title="skriv inn i tidformat" name="tidFra" placeholder="Fyll inn tid" pattern="[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}" required="required"/></p>
		<p>Retur leie dato:   <input type="text" title="skriv inn i datoformat" name="datoTil" placeholder="Fyll inn dato" pattern="[0-3]{1}[0-9]{1}[,]{1}[0-1]{1}[0-9]{1}[,]{1}[0-9]{4}" required="required"/></p>
		<p>Retur leie tid:   <input type="text" title="skriv inn i tidformat" name="tidTil" placeholder="Fyll inn tid" pattern="[0-2]{1}[0-9]{1}[:]{1}[0-5]{1}[0-9]{1}" required="required"/></p>
		
		<p style="color:red">${redirectMessage}</p>
		<p>velg av utleie sted og bil</p>
		<c:forEach var="sted" items="${utleiesteder}">
		
		<p>biler fra: <input type="radio" name="utleiested_nr" value="${sted.id}"/> ${sted.addresse}</p>
			
			<c:forEach var="bil" items="${biler}">
			<c:set var="val" value="${bil.utleiekontor_id.id}"/>
			<c:set var="val1" value="${sted.id}"/>
			<c:if test="${val1==val}">
			<p><input type="radio" checked="checked" name="regnr" value="${bil.regnr}"/> ${bil.merke} ${bil.model} </p>
			</c:if>
			</c:forEach>
		</c:forEach>
		
		<p>velg retursted der du skal returnere bilen: </p>
		<c:forEach var="sted" items="${utleiesteder}">
		<p><input type="radio"  name="retursted_nr" value="${sted.id}"/> ${sted.addresse} </p>
		</c:forEach>
		
	    <p><input type="submit" value="Start utleie av bilen" /></p>
	  </fieldset>
	</form>


</body></html>