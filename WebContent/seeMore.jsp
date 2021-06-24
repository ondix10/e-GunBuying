<%@ include file="parts/_menuForUser.jsp" %>>

<section id="work_outer">
<div class="top_cont_latest">
  <div class="container">
    <h2>X arme</h2>
    <div class="work_section">
      <div class="row">
        <div class="col-lg-6 col-sm-6 wow fadeInLeft delay-05s">
          <div class="service-list">
            <div class="service-list-col1"> <i class="icon-doc"></i> </div>
            <div class="service-list-col2">
              <h3>Puissance</h3>
              <p>Proin iaculis purus digni consequat sem digni ssim. Donec entum digni ssim.</p>
            </div>
          </div>
          <div class="service-list">
            <div class="service-list-col1"> <i class="icon-comment"></i> </div>
            <div class="service-list-col2">
              <h3>Vitesse de pointe</h3>
              <p>Proin iaculis purus consequat sem digni ssim. Digni ssim porttitora .</p>
            </div>
          </div>
          <div class="service-list">
            <div class="service-list-col1"> <i class="icon-database"></i> </div>
            <div class="service-list-col2">
              <h3>Hosting Et Storage</h3>
              <p>Proin iaculis purus consequat digni sem digni ssim. Purus donec porttitora entum.</p>
            </div>
          </div>
          <div class="service-list">
            <div class="service-list-col1"> <i class="icon-cog"></i> </div>
            <div class="service-list-col2">
              <h3>Customization options</h3>
              <p>Proin iaculis purus consequat sem digni ssim. Sem porttitora entum.</p>
            </div>
          </div>
          <div class="work_bottom"> <span>Ready to take the plunge?</span> <a href="#service" class="learn_more2">Learn more</a> </div>
        </div>
        <figure class="col-lg-6 col-sm-6  text-right wow fadeInUp delay-02s"> </figure>
      </div>
    </div>
  </div>
  <div class="work_pic"><img src="img/dashboard_pic.png" alt=""></div>
  </div>
</section>


<!--twitter-feed-end-->
<footer class="footer_section" id="contact">

  <div class="container">
    <div class="footer_bottom"> <span>Copyright © 2021 by <a href="http://w3goods.com">Rémy Joyce Benji</a>. </span> </div>
  </div>
</footer>
<script type="text/javascript">
    $(document).ready(function(e) {
        $('#header_outer').scrollToFixed();
        $('.res-nav_click').click(function(){
            $('.main-nav').slideToggle();
            return false    
            
        });
        
    });
</script> 
<script>
    wow = new WOW(
      {
        animateClass: 'animated',
        offset:       100
      }
    );
    wow.init();
    document.getElementById('').onclick = function() {
      var section = document.createElement('section');
      section.className = 'wow fadeInDown';
	  section.className = 'wow shake';
	  section.className = 'wow zoomIn';
	  section.className = 'wow lightSpeedIn';
      this.parentNode.insertBefore(section, this);
    };
  </script> 
<script type="text/javascript">
	$(window).load(function(){
		
		$('a').bind('click',function(event){
			var $anchor = $(this);
			
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top - 91
			}, 1500,'easeInOutExpo');
			/*
			if you don't want to use the easing effects:
			$('html, body').stop().animate({
				scrollTop: $($anchor.attr('href')).offset().top
			}, 1000);
			*/
			event.preventDefault();
		});
	})
</script> 

<!--<script type="text/javascript">

$(window).load(function(){
  
  
  var $container = $('.portfolioContainer'),
      $body = $('body'),
      colW = 350,
      columns = null;

  
  $container.isotope({
    // disable window resizing
    resizable: true,
    masonry: {
      columnWidth: colW
    }
  });
  
  $(window).smartresize(function(){
    // check if columns has changed
    var currentColumns = Math.floor( ( $body.width() -30 ) / colW );
    if ( currentColumns !== columns ) {
      // set new column count
      columns = currentColumns;
      // apply width to container manually, then trigger relayout
      $container.width( columns * colW )
        .isotope('reLayout');
    }
    
  }).smartresize(); // trigger resize to set container width
  $('.portfolioFilter a').click(function(){
        $('.portfolioFilter .current').removeClass('current');
        $(this).addClass('current');
 
        var selector = $(this).attr('data-filter');
        $container.isotope({
			
            filter: selector,
         });
         return false;
    });
  
});

</script>


--> 

<script type="text/javascript">

   
  jQuery(document).ready(function($){     
// Portfolio Isotope
	var container = $('#portfolio-wrap');	
	

	container.isotope({
		animationEngine : 'best-available',
	  	animationOptions: {
	     	duration: 200,
	     	queue: false
	   	},
		layoutMode: 'fitRows'
	});	

	$('#filters a').click(function(){
		$('#filters a').removeClass('active');
		$(this).addClass('active');
		var selector = $(this).attr('data-filter');
	  	container.isotope({ filter: selector });
        setProjects();		
	  	return false;
	});
		
		
		function splitColumns() { 
			var winWidth = $(window).width(), 
				columnNumb = 1;
			
			
			if (winWidth > 1024) {
				columnNumb = 4;
			} else if (winWidth > 900) {
				columnNumb = 2;
			} else if (winWidth > 479) {
				columnNumb = 2;
			} else if (winWidth < 479) {
				columnNumb = 1;
			}
			
			return columnNumb;
		}		
		
		function setColumns() { 
			var winWidth = $(window).width(), 
				columnNumb = splitColumns(), 
				postWidth = Math.floor(winWidth / columnNumb);
			
			container.find('.portfolio-item').each(function () { 
				$(this).css( { 
					width : postWidth + 'px' 
				});
			});
		}		
		
		function setProjects() { 
			setColumns();
			container.isotope('reLayout');
		}		
		
		container.imagesLoaded(function () { 
			setColumns();
		});
		
	
		$(window).bind('resize', function () { 
			setProjects();			
		});

});
$( window ).load(function() {
	jQuery('#all').click();
	return false;
});
</script>
</body>
</html>