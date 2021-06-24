<%@ include file="parts/_menuForManagerTool.jsp" %>

<table>
 <tr>
<td>ID Commande<td>
<td>ID Arme<td>
<td>Date<td>
<td>Document<td>
<td>Statut</td>
</tr>
 <tr>
<td> ${idc} <td>
<td> ${ida} <td>
<td> ${dc} <td>
<td><a href="<%= request.getContextPath()%>/PermisPdf" style="text-decoration:none;color:red;" target="_blank"  >Voir Permis Ici</a><td>
<td> 
<div class ="commandes">
<form class ="arme" action="<%= request.getContextPath()%>/StatutCommande" method="post">
	 <select name="valide" id="valide">
	 	 <option value="" ></option>
		 <option value="Success" >Success</option>
		 <option value="Echec" >Echec</option>
	 </select> 
	 <input class ="armes" type="submit" style="padding:0px;font-size:1.7rem;" value="Enregistrer">
	  </form>
	 </div>
<td>
</tr>
</table>
<br><br>
</body>
</html>