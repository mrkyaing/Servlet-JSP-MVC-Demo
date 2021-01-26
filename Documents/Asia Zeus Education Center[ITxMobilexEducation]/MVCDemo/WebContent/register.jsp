<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>

<script type="text/javascript">

function verifypassword(){
	var pwd=document.getElementById("txtpwd").value;
	var compwd=document.getElementById("txtcompwd").value;
	if(pwd!=compwd){
		document.getElementById("error").innerHTML="Password does not match!";
		return false;
	}
	
}
</script>
</head>
<body>
	<form action="register" method="POST" onsubmit="return verifypassword()">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>gender:</td>
				<td><input type="radio" name="gender" value="Male" checked>
					Male <input type="radio" name="gender" value="Female">
					FeMale</td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" id="txtpwd"></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="confirmpassword" id="txtcompwd">				
				<span style="color:red" id="error"></span>				
				</td>
			</tr>

			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form>
</body>
</html>