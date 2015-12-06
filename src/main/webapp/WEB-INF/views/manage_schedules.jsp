<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*" import="com.journaldev.spring.model.User"
    import="com.journaldev.spring.model.Schedule" import="com.journaldev.spring.model.Local" import="com.journaldev.spring.model.Presentation" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chic Local Manager | UdeS</title>
<link rel="stylesheet"        href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"        href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="shortcut icon"     href="${webappRoot}/ChicLocalManager/resources/assets/images/gt_favicon.png">
<link rel="stylesheet"        href="${webappRoot}/ChicLocalManager/resources/assets/css/magister.css">
<link rel="shortcut icon"     href="${webappRoot}/ChicLocalManager/resources/bootstrap/fonts/glyphicons-halflings-regular.eot">
<link rel="stylesheet"        href="${webappRoot}/ChicLocalManager/resources/assets/css/sticky-footer-navbar.css" >
9+-
<!-- Custom template scripts -->
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/jquery/jquery-1.11.3.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/assets/js/magister.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/bootstrap.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/npm.js" /></script>
<script type=" image/png"       href="${webappRoot}/ChicLocalManager/resources/assets/js/modernizr.custom.72241.jss" /></script>

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
					<li><a href="#Locals" class="btn btn-info" role="button">Locals Status</a></li>
					<li><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#accountModal">Create an account </a></li>
					<li><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#loginModal">Login</button></li>
					<li><a href="#news" class="btn btn-info" role="button">Conferences News</a></li>
				</ul>
			</div>
			<div class="navbar-header pull-right">
			 <% 
				     User admin = (User)request.getAttribute("admin");
					 if(admin!= null && admin.getEmail() != null){
						    out.write("<h5 ><small style='color:green' >Registration Completed for ");
					        out.write(admin.getFirstName()); 
					        out.write(" , "+admin.getLastName()+".  ");
					        out.write(" Please Login in.");
					        out.write("</small></h5>");	       
					 }
		     %>
			</div>
	    </div><!--/.nav-collapse -->
	</div>
</nav>


<!-- Main (Home) section -->
<section class="section" id="head">

	<div class="container">

		<div class="row">
			<div class="col-md-10 col-lg-10 col-md-offset-1 col-lg-offset-1 text-center">	

	
			</div> <!-- /col -->
		</div> <!-- /row -->
	   
	</div>
	

	<div class="container">
		<div class="row">
			<div class="col-md-18">
			<hr/>
				<div class="thumbnail">
					<img href="${webappRoot}/ChicLocalManager/resources/assets/screenshots/sshot1.jpg" alt="">
					<div class="caption">
					<div class="col-md-2 col-md-offset-4"><table class="table"><thead ><thcol-md-offset-5>SCHEDULE DETAILS<th></th></thead></table></div>
					<c:if test="${not empty scheduleList}">
				          <table class="table" >
							    <thead>
							        <tr>
							            <th >Scedule ID</th>
							            <th >Date</th>
							            <th >Start time</th>
							            <th >Conference Title</th>
							            <th >Conference Owner</th>
							            <th >Total Hours</th>
							            <th >Total Participants</th>
							            <th >Building ID </th>
							            <th >Floor</th>
							            <th >Local No</th>
							            <th >Capacity</th>
							            <th >Description</th>
							            <th >Materials</th>
							            <th >Status</th>
							        </tr>
							    </thead>
							    <tbody> 
							    <%
							    ArrayList<Schedule> schedules =(ArrayList<Schedule>) request.getAttribute("scheduleList");
							    if(schedules != null){
							    Iterator<Schedule> iter = schedules.iterator();
							    
							    while(iter.hasNext()){
							    	Schedule schedule =iter.next();
					            %>
							     <tr>  
							           <td> <%=schedule.getUuid().substring(0, 5)%></td>
							           <td> <%=schedule.getDate()%></td>
							           <td> <%=schedule.getHeureDebut()%> H</td>
							           
							      <%
							      Presentation conference = (Presentation)schedule.getConference();
							     %>
							     
							           <td> <%=conference.getTitre()%></td>
							           <td> <%=conference.getPresentateur()%></td>
							           <td> <%=conference.getDureeHeure()%> H <%=conference.getDureeMinute()%> Min</td>
							           <td> <%=conference.getNombreParticipants()%></td>
						              
							     <%
					               Local local = (Local)schedule.getLocal();
							     %>
							           <td> <%=local.getBuildingId().substring(0, 5)%></td>
							           <td> <%=local.getFloor()%></td>
							           <td> <%=local.getUuid().substring(0, 5)%></td>
						               <td> <%=local.getCapacity()%></td>
						               <td> <%=local.getDescription()%></td>
						               <td> <%=local.getMaterials()%></td>
						               <td> <%=local.getStatus()%></td>
							     </tr>
							   <% }} %>
							   </tbody>
							</table>
					</c:if>
					</div>
				</div>
			</div>
		
		</div>

	</div>
	
	
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Login</h4>
      </div>
      <div class="modal-body">
	       <form class="form-signin" action="login" method="POST" commandName="adminForm">
	       	<fieldset>
		       	<div class="control-group">
				      <!-- First  -->
				      <label class="control-label"  for="password">password</label>
				      <div class="controls">
				        <input type="password" id="password" name="password" placeholder="" class="input-xlarge form-control"  required autofocus>
				      </div>
				 </div>
				 <div class="control-group">
				      <!-- Username -->
				      <label class="control-label"  for="email">email</label>
				      <div class="controls">
				        <input type="text" id="email" name="email" placeholder="" class="input-xlarge form-control" required>
				      </div>
				</div>
	                <button class="btn btn-lg btn-success btn-block" type="submit">
	                    Sign in</button>
	                <label class="checkbox">
	                    <input type="checkbox" value="remember-me">
	                    Remember me
	                </label>
	                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
	            </fieldset>
	        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!-- Modal -->
<div class="modal fade" id="accountModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Register</h4>
      </div>
      <div class="modal-body">
	      <form action="register"  method="post" commandName="userForm">
			<fieldset>
			    <div id="legend">
			    </div>
			    <div class="control-group">
			      <!-- First  -->
			      <label class="control-label"  for="firstName">Fisrt Name</label>
			      <div class="controls">
			        <input type="text" id="firstName" name="firstName" placeholder="" class="input-xlarge form-control">
			        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="lastName">Last Name</label>
			      <div class="controls">
			        <input type="text" id="lastName" name="lastName" placeholder="" class="input-xlarge form-control">
			        <p class="help-block">Username can contain any letters or numbers, without spaces</p>
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- E-mail -->
			      <label class="control-label" for="email">E-mail</label>
			      <div class="controls">
			        <input type="text" id="email" name="email" placeholder="usherb@sher.ca" class="input-xlarge form-control">
			        <p class="help-block">Please provide your E-mail</p>
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">Password</label>
			      <div class="controls">
			        <input type="password" id="password" name="password" placeholder="" class="input-xlarge form-control">
			        <p class="help-block">Password should be at least 4 characters</p>
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="password_confirm">Password (Confirm)</label>
			      <div class="controls">
			        <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge form-control">
			        <p class="help-block">Please confirm password</p>
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-success">Register</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	
</section>

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