$(document).ready(function() {
	// выделить кнопку в navbar при нажатии до загрузки страницы
	$('.navbar-nav li').click(function() {
		$(this).addClass('active');
	});
	
	// выделить кнопку в navbar при нажатии после загрузки страницы
	$('.navbar-nav li a').each(function() {
		if ($(this).attr('href') == document.location.pathname)
			$(this).parent().addClass('active');
	});
	
	// run plugin "scroll to top"
	$.scrollUp({
		scrollName: 'scrollUp',			// Element ID
		topDistance: '300',				// Distance from top before showing element (px)
		topSpeed: 300,					// Speed back to top (ms)
		animation: 'fade',				// fade, slide, none
		animationInSpeed: 200,			// Animation in speed (ms)
		animationOutSpeed: 200,			// Animation out speed (ms)
		scrollText: 'Scroll to top',	// Text for element
		activeOverlay: false,			// Set CSS color to display scrollUp active point, e.g '#00FFFF'
	});
	
	// bootstrap: tooltip (всплывающие подсказки)
	$('[data-toggle="tooltip"]').tooltip();
});