<%@ include file="parts/_menuForManagerTool.jsp" %>

	<form action="<%= request.getContextPath()%>/ValideCommande" method = "post">
	  <input class="input-text animated wow flipInY delay-04s" style="width:45%; margin-left:50px;" type="text" name="commandeId" value="Entrer l'Identifiant de la commande" onFocus="if(this.value==this.defaultValue)this.value='';" onBlur="if(this.value=='')this.value=this.defaultValue;">
	  <br><br>
	  <input class="input-btn animated wow flipInY delay-08s" style="width:10%;margin-left:50px;" type="submit" value="Valider">
	</form>
</body>
</html>