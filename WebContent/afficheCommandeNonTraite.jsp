<%@ include file="parts/_menuForManagerTool.jsp" %>

<div style="display:flex;text-align:center; margin:auto; width:50%;">
<table>
 <tr>
<td style="padding:10px;font-weight:bolder;color:black;">Id Commande<td>
<td style="padding:10px;font-weight:bolder;color:black;">Date<td>
</tr>
<c:forEach var="com" items="${commande}">
 <tr>
<td style="padding:10px;"> ${com.idCommande} <td>
<td style="padding:10px;"> ${com.dateCommande} <td>
</tr>
</c:forEach>
</table>
<table>
 <tr>
<td style="padding:10px;font-weight:bolder;color:black;">Id Arme<td>
<td style="padding:10px;font-weight:bolder;color:black;">Nom<td>
</tr>
<c:forEach var="arm" items="${arme}">
 <tr>
<td style="padding:10px;"> ${arm.idArme} <td>
<td style="padding:10px;"> ${arm.nom} <td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>