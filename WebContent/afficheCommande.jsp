<%@ include file="parts/_menuForUserModify.jsp" %>

<div style="display:flex;text-align:center; margin:auto; width:50%;">
<table>
 <tr>
<td style="padding:10px;font-weight:bolder;color:black;">Nom<td>
<td style="padding:10px;font-weight:bolder;color:black;">Prix<td>
</tr>
<c:forEach var="arm" items="${arme}">
 <tr>
<td style="padding:10px;"> ${arm.nom} <td>
<td style="padding:10px;"> ${arm.prix} <td>
</tr>
</c:forEach>
</table>

<table>
 <tr>
<td style="padding:10px;font-weight:bolder;color:black;">Quantite<td>
<td style="padding:10px;font-weight:bolder;color:black;">Date<td>
<td style="padding:10px;font-weight:bolder;color:black;">Statut<td>
</tr>
<c:forEach var="com" items="${commande}">
 <tr>
<td style="padding:10px;"> ${com.quantite} <td>
<td style="padding:10px;"> ${com.dateCommande} <td>
<td style="padding:10px;"> ${com.statut } <td>
</tr>
</c:forEach>
</table>

<div class ="commande">
	  <form class ="arme" action="<%= request.getContextPath()%>/pdf" method="get" target="_blank">
	    <input class ="armes" type="submit" value="Version Pdf">
	  </form>
</div>
</div>
</body>
</html>