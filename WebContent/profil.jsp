<%@ include file="parts/_menuForUser.jsp" %>>


<section class="main-section" id="client_outer"><!--main-section client-part-start-->
  
  <div class="client_area ">
    <div class="client_section animated  fadeInUp wow">
      <div class="client_profile">
        <div class="client_profile_pic">
        	<img src="pic/${client.photo }" alt=""> 
        </div> <!-- "img/IMG_6180.jpg" -->
        <h3><span class="Bonjour">Bonjour</span> ${ client.nom} ${client.prenom} </h3> 
        <span class="connected">Connected</span> 
       </div>
      <div class="quote_section">
        <div class="quote_arrow"></div>
         <p> ${client.biographie} </p>
      </div>
      <div class="clear"></div> 
    </div>

  </div>
</section>

<%@ include file="parts/_gallery.jsp" %>

	<div id="commande" class ="commande">
	  <form class ="arme" action="<%= request.getContextPath()%>/commandeClient" method="post">
	    <input class ="armes" type="submit" value="Voir  commande">
	  </form>
	</div>

<%@ include file="parts/_footer.jsp" %>



