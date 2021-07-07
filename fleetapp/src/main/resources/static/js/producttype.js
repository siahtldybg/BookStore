
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		let href = $(this).attr('href');
		
		$.get(href, function(product_type, status){
			$('#idEdit').val(product_type.id);
			$('#productTypeEdit').val(product_type.type);
			$('#categoryEdit').val(product_type.category);
		});	
		$('#editModal').modal();
	});

	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		let href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});


});