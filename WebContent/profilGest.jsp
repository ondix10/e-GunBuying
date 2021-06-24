<%@ include file="parts/_menuForManager.jsp" %>


<section class="main-section" id="client_outer"><!--main-section client-part-start-->

  
  <div class="client_area ">    
      <form action="<%= request.getContextPath()%>/CommandesAll" method="post" enctype="multipart/form-data">
        <input type="submit" class="input-text animated wow flipInY delay-02s" value="Voir toutes les Commandes"> 
      </form>
       <form action="<%= request.getContextPath()%>/CommandeTraite" method="post" enctype="multipart/form-data">
        <input type="submit" class="input-text animated wow flipInY delay-02s" value="Voir Commandes Traitees"> 
      </form>
      <form action="<%= request.getContextPath()%>/CommandeNonTraite" method="post" enctype="multipart/form-data">
        <input type="submit" class="input-text animated wow flipInY delay-02s" value="Voir Commandes Non Traitees"> 
      </form>
       <form action="<%= request.getContextPath()%>/valideCommande.jsp" method="post" enctype="multipart/form-data">
        <input type="submit" class="input-text animated wow flipInY delay-02s" value="Valider Commande"> 
      </form>
  </div>
</section>
</body>
</html>
