<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subscribe to Smooss !</title>
</head>
<body>
	<form action="RegisterServlet" method="POST">
		<div class="modal-body">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-at"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="email" id=""
						placeholder="Adresse mail" class="input_modal">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-at"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="firstName" id=""
						placeholder="Prénom" class="input_modal">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-at"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="lastName" id=""
						placeholder="Nom" class="input_modal">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-user"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="nickname" id=""
						placeholder="Pseudo (facultatif)" class="input_modal">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-lock"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="password" id=""
						placeholder="Mot de passe" class="input_modal">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<i class="fas fa-lock"></i>
						</div>
					</div>
					<input type="text" class="form-control" name="confirmpassword"
						id="" placeholder="Confirmation mot de passe" class="input_modal">
				</div>
			</div>
			<div class="modal-footer justify-content-center">
                    <button type="submit" class="btn button_submit_modal" id="button_submit_inscription_modal"> Devenir un Smoosser ! </button>
            </div>
		</div>
	</form>
</body>
</html>