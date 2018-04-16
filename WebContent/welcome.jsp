<%@page import="login.LoginBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <link rel="stylesheet" href="css/welcome.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-alpha.4/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-alpha.4/js/materialize.min.js"></script>
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
   <title>Welcome</title>
</head>
<body>
	<%
		if(session.getAttribute("user") == null){
			response.sendRedirect("login.jsp");
		}
	%>
   <div class="navbar-fixed">
      <nav>
        <div class="nav-wrapper black">
          <a href="#!" class="brand-logo">Filmarina</a>
          <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
             <li><a href="" class="waves-effect btn-flat underline">Theatre</a></li>
             <li><a href="MoviesDao" class="waves-effect btn-flat ">Movies</a></li>
             <li><a href="" class="waves-effect btn-flat ">My Account</a></li>
             <li>
				<form action="Logout">
					<button class="waves-effect btn-flat " type="submit">Logout</button>
				</form>
             </li>
          </ul>
        </div>
      </nav>
   </div>
   <ul class="sidenav" id="mobile-demo">
      <li><a href="login.jsp" class="waves-effect btn-flat">SIGNUP/LOGIN</a></li>
      <li><a href="" class="waves-effect btn-flat">Theatre</a></li>
      <li><a href="" class="waves-effect btn-flat">Movies</a></li>
      <li><a href="" class="waves-effect btn-flat">My Account</a></li>
      <li>
		<form action="Logout">
			<button class="waves-effect btn-flat " type="submit">Logout</button>
		</form>
      </li>
   </ul>
   <div class="landing">
      <div class="layer">

      </div>
      <div class="content">
         <h1>WELCOME</h1>
         <h5>${user.getName()}</h5>
      </div>
   </div>
	<!-- <header>
      <h3>filmarina</h3>
      <form action="Logout">
         <button type="submit">LOGOUT</button>
      </form>
      <h3>WELCOME ${user}</h3>
   </header>
   <div class="movies">
      <div class="m">TSK</div>
      <div class="m">BP</div>
      <div class="m">IW</div>
      <div class="m">JL</div>
   </div>
   <p id="movie"></p> -->
   
</body>
</html>
