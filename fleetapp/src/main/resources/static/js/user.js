
$('document').ready(function(){
	
	$('table #editButton').on('click',function(event){
		event.preventDefault();
			
		let href = $(this).attr('href');
		
		$.get(href, function(user, status){
			$('#idEdit').val(user.id);
			$('#usernameEdit').val(user.username);
			$('#passwordEdit').val(user.password);
			$('#firstnameEdit').val(user.firstname);
			$('#lastnameEdit').val(user.lastname);
			$('#rolesEdit').val(user.roles);
			$('#enabledEdit').val(user.enabled?'true':'false');
			$('#fupImageEdit').val(user.photo);
		});					
		$('#editModal').modal();
	});

	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		let href= $(this).attr('href');
		
		$('#confirmDeleteButton').attr('href', href);
		
		$('#deleteModal').modal();
	});

	$('.table #photoButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();		
	});
});