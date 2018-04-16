<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>SIGNUP</title>
   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

   <!-- Compiled and minified JavaScript -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
   <link rel="stylesheet" href="css/form.css">
</head>
<body>
	<!-- <div>
	   <form action="Register">
	      Name: <input type="text" name='name'><br>
	      email: <input type="text" name='email'><br>
	      password: <input type="password" name='pass'><br>
	      <button type="submit">REGISTER</button>
	   </form>
	</div> -->
   <div class="container">
      <h2 class="center">SIGNUP</h2>
      <form action="Register" method="post">
         <div class="row">
            <div class="input-field col s12 m6">
               <input id="name" type="text" name="name" class="validate" required>
               <label class="active" for="name">Name</label>
            </div>
            <div class="input-field col s12 m6">
               <input id="email" type="email" name="email" class="validate" required>
               <label class="active" for="email">Email</label>
            </div>
         </div>
         <div class="row">
            <div class="input-field col s12 m6">
               <input id="pass" type="password" name="pass" class="validate" required>
               <label class="active" for="password">Password</label>
            </div>
            <div class="input-field col s12 m6">
               <input id="con_pass" type="password" class="validate" required>
               <label class="active" for="con_pass">Confirm Password</label>
            </div>
         </div>
         <div class="center row">
            <button class='btn black' type="submit">Register</button>
         </div>
      </form>

   </div>

</body>
</html>
