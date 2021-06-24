<%@ include file="parts/_menuForUserModify.jsp" %>


<section class="main-section" id="client_outer"><!--main-section client-part-start-->
  
  <div class="client_area ">
    <div class="client_section animated  fadeInUp wow">
      <div class="client_profile">
        <div class="client_profile_pic">
        	<img src="pic/${client.photo }" alt=""> 
        	
        </div> <!-- "img/IMG_6180.jpg" -->
        <form action="<%= request.getContextPath()%>/modifyProfil" method="post" enctype="multipart/form-data">
             <input type="file" name="photo" value="Editer photo profil">
             <br>
             <input type="submit" value="Enregistrer"> 
        </form>

     </div>
      <div class="quote_section">
        <div class="quote_arrow"></div>
        <p> ${client.biographie} </p>
      </div>
    </div>
      <div class="sexBiog">
        <form action="<%= request.getContextPath()%>/modifyProfil" method="post" class="biographie" enctype="multipart/form-data">
          <input type="text" name="biographie" value="Nouvelle Biographie" onFocus="if(this.value==this.defaultValue)this.value='';" onBlur="if(this.value=='')this.value=this.defaultValue;">
          <input type="submit" value="Enregistrer"> 
        </form>
        <div class="sexe">
        <p > votre gerne: ${client.sexe} </p>
        <form action="<%= request.getContextPath()%>/modifyProfil" method="post" enctype="multipart/form-data">
          <select name="sexe">
          	<optgroup label="Genre">
          	  <option>Feminin</option>
          	  <option>Masculin</option>
          	</optgroup>
          </select>
          <input type="submit" value="Enregistrer"> 
        </form>
        </div>
      </div>
      <div class="clear"></div> 
    </div>

</section>
</body>
</html>
