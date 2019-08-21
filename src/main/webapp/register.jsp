<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #ff0000;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

button:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	padding: 14px 20px;
	background-color: #f44336;
}

/* Add padding to container elements */
.container {
	padding: 16px;
}
</style>
<body>

	<form action="registrazione" style="border: 1px solid #ccc" method="POST">
		<div class="container">
			<h1>
				Inserire i dati per la registrazione
			</h1>
			<hr>

			<label for="username"><b>Scegli il tuo username</b></label> <input
				type="text" placeholder="Enter Username" name="username" required>
			<label for="psw"><b>Scegli la tua Password</b></label> <input
				type="password" placeholder="Enter Password" name="password"
				required>
			<button type="submit" value="registrazione">Sign Up</button>
		</div>
	</form>
	<a href="login.jsp">sei gia' registrato? Clicca qui</a>
</body>
</html>