
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

   <!-- Compiled and minified JavaScript -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
   <link rel="stylesheet" href="css/form.css">
   <title>LOGIN</title>
</head>
<body>
   <!-- <div>
      <form action="Login">
         Email<input type="text" name="email"><br>
         Password<input type="password" name="pass"><br>
         <button type="submit">submit</button>
      </form>
      <br>
      <a href="signup.jsp">SIGNUP</a>
   </div> -->
   <div class="container">
      <h4>${err}</h4>		
      <h2 class="center">LOGIN/SIGNUP</h2>
      <form action="Login" method="post">
         <div class="row">
            <div class="input-field col s12 m6">
               <input id="email" type="email" name="email" class="validate" required>
               <label class="active" for="email">Email</label>
            </div>
            <div class="input-field col s12 m6">
               <input id="pass" type="password" name="pass" class="validate" required>
               <label class="active" for="password">Password</label>
            </div>
         </div>
         <div class="center row">
            <button class='btn black' type="submit">SUBMIT</button>

         </div>
         <div class="row center">
            <a href="signup.jsp" class="waves-effect btn-flat">SIGNUP</a>
         </div>
      </form>

   </div>


   <script>
      $(document).ready(function() {
         Materialize.updateTextFields();
      });
   </script>
</body>
</html>
