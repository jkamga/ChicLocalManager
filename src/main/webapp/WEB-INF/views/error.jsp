<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chic Local Manager | UdeS</title>
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="shortcut icon" href="${webappRoot}/ChicLocalManager/resources/assets/images/gt_favicon.png">
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/assets/css/magister.css">
<link rel="shortcut icon" href="${webappRoot}/ChicLocalManager/resources/bootstrap/fonts/glyphicons-halflings-regular.eot">
<link rel="stylesheet"    href="${webappRoot}/ChicLocalManager/resources/assets/css/sticky-footer-navbar.css" >

<!-- Custom template scripts -->
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/jquery/jquery-1.11.3.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/assets/js/magister.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/bootstrap.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/npm.js" /></script>
<script type=" image/png"       href="${webappRoot}/ChicLocalManager/resources/assets/js/modernizr.custom.72241.jss" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/assets/js/manage_local.js" /></script>

</head>
<!-- use "theme-invert" class on bright backgrounds, also try "text-shadows" class -->
<body class="theme-invert" >

<nav class="mainmenu navbar navbar-default navbar-fixed-top">
	<div class="container">
	    <div class="navbar-header">
          <a class="navbar-brand" href="#">USHMACHINCON</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
			<div class="dropdown">
				<button type="button" class="navbar-toggle" data-toggle="dropdown"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<!-- <a data-toggle="dropdown" href="#">Dropdown trigger</a> -->
				<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				    <li><br/></li>
				    <li><br/></li>
				    <li><a href="#Lgout" class="btn btn-info" role="button">Logout</a></li>
					<li><a href="#Locals" class="btn btn-info" role="button">Locals Status</a></li>
					<li><a href="#news" class="btn btn-info" role="button">Conferences News</a></li>
				</ul>
			</div>
	    </div><!--/.nav-collapse -->
	     
	</div>
</nav>
<div class="container">
		 <div class="row">
		        <div class="col-md-16 col-lg-10 col-md-offset-2 text-center">
				    <h1 style="color:red">Error Page.</h1>
				    <p style="color:red">Application has encountered an error. Please contact support on 514 525-xxxx</p>
				    <p style="color:red">Date And Time : ${datetime}</p>
				    <p style="color:red">Failed URL: ${url}</p>
				    <p style="color:red">Exception:  ${exception.message}</p>
				    <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
				    </c:forEach>
			    </div>
          </div>
 </div>
<footer class="footer">
	<div class="container">
	<div class="col-sm-8 col-sm-offset-2 text-center">
		<ul class="list-inline list-social">
			<li><a href="https://twitter.com/jkamga" class="btn btn-link"><i class="fa fa-twitter fa-fw"></i> Twitter</a></li>
			<li><a href="https://github.com/jkamga" class="btn btn-link"><i class="fa fa-github fa-fw"></i> Github</a></li>
			<li><a href="http://linkedin/in/jkamga" class="btn btn-link"><i class="fa fa-linkedin fa-fw"></i> LinkedIn</a></li>
	   </ul>
	</div>
				 
	 <p>Copyright &copy;<script type="text/javascript" >
		var dteNow = new Date();
		var intYear = dteNow.getFullYear();
		document.write(intYear);</script> | Contact : <a href="mailto:jkamga.officiel@gmail.com">jkamga.officiel@gmail.com</a>.</p>
	</div>
</footer> 
</body>
</html>