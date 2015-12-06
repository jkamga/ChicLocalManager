<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*" import="com.journaldev.spring.model.User" import="com.journaldev.spring.model.User"
    import="com.journaldev.spring.model.Schedule" import="com.journaldev.spring.model.Local" import="com.journaldev.spring.model.Presentation"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chic Local Manager | UdeS</title>
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/bootstrap/css/bootstrap-datetimepicker.min.css">
<link rel="shortcut icon" href="${webappRoot}/ChicLocalManager/resources/assets/images/gt_favicon.png">
<link rel="stylesheet" href="${webappRoot}/ChicLocalManager/resources/assets/css/magister.css">
<link rel="shortcut icon" href="${webappRoot}/ChicLocalManager/resources/bootstrap/fonts/glyphicons-halflings-regular.eot">
<link rel="stylesheet"    href="${webappRoot}/ChicLocalManager/resources/assets/css/sticky-footer-navbar.css" >
<link rel="stylesheet" href="/bower_components/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepick">

<!-- Custom template scripts -->
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/jquery/jquery-1.11.3.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/assets/js/magister.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/bootstrap.min.js" /></script>
<script type="text/javascript"  src="${webappRoot}/ChicLocalManager/resources/bootstrap/js/bootstrap-datetimepicker.min.js" /></script>
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
				    <li><button type="button" class="btn btn-info btn-block" data-toggle="modal" data-target="#logoutModal">Logout</button></li>
					<li><a href="#Locals" class="btn btn-info" role="button">Locals Status</a></li>
					<li><a href="#news" class="btn btn-info" role="button">Conferences News</a></li>
				</ul>
			</div>
			<div class="navbar-header pull-right">
		          <% 
				     User admin = (User)request.getAttribute("admin");
				  %>
				<c:if test="${admin.userid != null}">
				  <h5><small>WELCOME : ${admin.firstName}, ${admin.lastName}</small></h5>
				</c:if>
				<p style="color:red">${Error}</p>
				<p style="color:green">${Success}</p>
		    </div>
	    </div><!--/.nav-collapse -->
	     
	</div>
</nav>

<!-- Main (Home) section -->
<section class="section" id="head">
	<div class="container">
		<div class="row">
			<div class="col-md-16 col-lg-10 col-md-offset-1 text-center">	
                 <form>
					        <!--Default buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle">Manage Locals <span class="caret"></span></button>
					            <ul class="dropdown-menu">
					                <li><a type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Local</a></li>
					                <li><a type="button" class="btn btn-info updateLocal" data-toggle="modal" data-target="#myModal">Update Local</a></li>
					                <li><a href="#" type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Remove Local</a></li>
					                <li><a href="#" type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">View Local</a></li>
					            </ul>
					        </div>
					        <!--Primary buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-primary dropdown-toggle">Manage Schedules <span class="caret"></span></button>
					            <ul class="dropdown-menu">
					                <li><a type="button" class="btn btn-info" data-toggle="modal" data-target="#horaireModal">Add Schedule</a></li>
					                <li><a type="button" class="btn btn-info updateSchedule" data-toggle="modal" data-target="#horaireModal">Update Schedule</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Remove Schedule</a></li>
					                <li><a href="#" type="button" class="btn btn-info">View Schedule</a></li>
					            </ul>
					        </div>
					        <!--Info buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-info dropdown-toggle">Manage Buildings <span class="caret"></span></button>
					            <ul class="dropdown-menu">
					                 <li><a type="button" class="btn btn-info" data-toggle="modal" data-target="#buildingModal">Add Building</a></li>
					                <li><a type="button" class="btn btn-info updateItem" data-toggle="modal" data-target="#buildingModal">Add Building</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Remove Building</a></li>
					                <li><a href="#" type="button" class="btn btn-info">View Building</a></li>
					            </ul>
					        </div>					      
					        <!--Warning buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-warning dropdown-toggle">Manage Universities<span class="caret"></span></button>
					            <ul class="dropdown-menu">
					                <li><a href="#" type="button" class="btn btn-info">Add University</a></li>
					                <li><a href="#" type="button" class="btn btn-info updateItem">Add University</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Remove University</a></li>
					                <li><a href="#" type="button" class="btn btn-info">View University</a></li>
					            </ul>
					        </div>
					        <!--Danger buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-danger dropdown-toggle">Manage Conferences<span class="caret"></span></button>
					            <ul class="dropdown-menu">
					                <li><a type="button" class="btn btn-info" data-toggle="modal" data-target="#conferenceModal">Add Conference</a></li>
					                <li><a type="button" class="btn btn-info updateItem" data-toggle="modal" data-target="#conferenceModal">Update Conference</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Remove Conference</a></li>
					                <li><a href="#" type="button" class="btn btn-info">View Conference</a></li>
					            </ul>
					        </div>
					          <!--Success buttons with dropdown menu-->
					        <div class="btn-group">
					            <button type="button" data-toggle="dropdown" class="btn btn-success dropdown-toggle">More Options<span class="caret"></span></button>
					            <ul class="dropdown-menu">
					               <li><a href="#" type="button" class="btn btn-info">Add Schedule</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Update Schedule</a></li>
					                <li><a href="#" type="button" class="btn btn-info">Remove Schedule</a></li>
					                <li><a href="#" type="button" class="btn btn-info">View Schedule</a></li>
					            </ul>
					        </div>
					    </form>
	
			</div> <!-- /col -->
			<br/>
			<br/>
			
			<div >
			<hr/>
			<div class="row">
				<div class="thumbnail">
					<img href="${webappRoot}/ChicLocalManager/resources/assets/screenshots/sshot1.jpg" alt="">
					<div class="col-md-2 col-md-offset-4"><table class="table"><thead ><thcol-md-offset-5>SCHEDULE DETAILS<th></th></thead></table></div>
					<c:if test="${not empty scheduleList}">
						 <table class="table" >
							    <thead>
							        <tr class="row">
							            <th >Scedule ID</th>
							            <th >Date</th>
							            <th >Start time</th>
							            <th >Subject</th>
							            <th >Owner</th>
							            <th >Hours</th>
							            <th >Seets</th>
							            <th >Building ID </th>
							            <th >Floor</th>
							            <th >Local No</th>
							            <th >Capacity</th>
							            <th >Description</th>
							            <th >Materials</th>
							            <th >Status</th>
							            <th >Delete</th>
							            <th >Edit</th>
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
							     <tr  class="row">  
							           <td> <%=schedule.getUuid().substring(0, 5)%></td>
							           <td> <%=schedule.getDate()%></td>
							           <td> <%=schedule.getHeureDebut()%> H </td>
							           
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
						               <td><a href="{http://localhost:8085/ChicLocalManager/}schedule/delete/"+<%=schedule.getUuid()%> class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-remove"></span></a></td>
                                       <td><a href="#" class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-pencil"></span></a><td>
							     </tr>
							   <% }} %>
							   </tbody>
							</table>
					</c:if>
					</div>
			</div>
		  </div>
		</div>

	
		</div> <!-- /row -->
	   
	
	
</section>

<!-- Modal -->
<div class="modal fade pull-right" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Manage Local | Add/Update</h4>
      </div>
      <div class="modal-body">
       <form action="createLocal"  id="localForm" method="post"  commandName="salleForm"  role="form">
			<fieldset>
			    <div id="LocaldTextId"  class="control-group">
			      <!-- First  -->
			      <label class="control-label"  for="localId">Local Id</label>
			      <div class="controls">
			        <input type="text" id="localId" name="numero" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			     <div  id="selecteableLocaldId" class="control-group hidden">
			      <label class="control-label"  for="localId">Local Id</label>
			         <div class="controls">
				        <select class="form-control" id="localIdSelectorForInput" name="numero">
				           <script type="text/javascript">
				           var option="<option>Local</option>"; 
				            $("#localIdSelectorForInput").append(option);
				           var localsList = ${locals};
				           for(var i=0;i<localsList.length;i++)
				           {
				        	 var idLocal = localsList[i]._id;
				             var option="<option value='"+idLocal+"'>"+idLocal+"</option>"; 
				              $("#localIdSelectorForInput").append(option); 

				           }  
				           localStorage.setItem('Localist',localsList);
				           </script>
							
					    </select>
					   </div>
			      </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="capacity">Capacity</label>
			      <div class="controls">
			        <input type="text" id="capacity" name="capacite" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- E-mail -->
			      <label class="control-label" for="floor">Floor</label>
			      <div class="controls">
			        <input type="text" id="floor" name="etage" placeholder="5" class="input-xlarge form-control">
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="buildingID">Building ID</label>
			      <div class="controls">
			        <input type="text" id="buildingID" name="idbatiment" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Description</label>
			      <div class="controls">
			        <input type="text" id="description" name="description" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="status">Status</label>
			      <div class="controls">
			        <input type="text" id="status" name="statut" placeholder="Disonible 2h par jour" class="input-xlarge form-control">
			      </div>
			    </div>
			     <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="Equipment">Equipment</label>
			      <div class="controls">
			        <input type="text" id="Equipment" name="equipement" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <br/>
			     <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			         <button type="submit" class="btn btn-success">Confirm</button>
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

<!-- Modal -->
<div class="modal fade pull-right" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Logout</h4>
      </div>
      <div class="modal-body">
       <p>Are You Sure That Want To completely Log out?</p>
        <form action="schedule"  method="GET"   role="form">
			<fieldset>
			     <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			         <button type="submit" class="btn btn-success">Confirm</button>
			      </div>
			    </div>
			 </fieldset>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>

<!--building  -->
<div class="modal fade pull-right" id="buildingModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Manage Building | Add</h4>
      </div>
      <div class="modal-body">
       <form action="createBuilding"  method="post"  commandName="batimentForm"  role="form">
			<fieldset>
			    <div class="control-group">
			      <!-- First  -->
			      <label class="control-label"  for="localId">Name</label>
			      <div class="controls">
			        <input type="text" id="localId" name="nom" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="capacity">Addresse</label>
			      <div class="controls">
			        <input type="text" id="capacity" name="adresse" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- E-mail -->
			      <label class="control-label" for="floor">Faculte</label>
			      <div class="controls">
			        <input type="text" id="floor" name="faculte" placeholder="5" class="input-xlarge form-control">
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="buildingID">Campus</label>
			      <div class="controls">
			        <input type="text" id="buildingID" name="campus" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>		 
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Universite</label>
			      <div class="controls">
			        <input type="text" id="description" name="universite" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <br/>
			     <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			         <button type="submit" class="btn btn-success">Confirm</button>
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

<!-- update -->
<div class="modal fade pull-right" id="conferenceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Manage Conference | Add</h4>
      </div>
      <div class="modal-body">
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<!--Conference  -->
<div class="modal fade pull-right" id="conferenceModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Manage Conference | Add</h4>
      </div>
      <div class="modal-body">
       <form action="createConference"  method="post"  commandName="conferenceForm"  role="form">
			<fieldset>
			    <div class="control-group">
			      <!-- First  -->
			      <label class="control-label"  for="localId">Title</label>
			      <div class="controls">
			        <input type="text" id="localId" name="titre" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="capacity">Participants</label>
			      <div class="controls">
			        <input type="text" id="capacity" name="nombreParticipants" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- E-mail -->
			      <label class="control-label" for="floor">Equipment Needed</label>
			      <div class="controls">
			        <input type="text" id="floor" name="equipement" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			 
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="buildingID">Number Of Hours</label>
			      <div class="controls">
			        <input type="text" id="buildingID" name="dureeHeure" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>		 
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Number Of Min</label>
			      <div class="controls">
			        <input type="text" id="description" name="dureeMinute" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			     <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Owvner</label>
			      <div class="controls">
			        <input type="text" id="description" name="presentateur" placeholder="" class="input-xlarge form-control">
			      </div>
			    </div>
			    <br/>
			     <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			         <button type="submit" class="btn btn-success">Confirm</button>
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

<!--Hraire  -->
<div class="modal fade pull-right" id="horaireModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Manage Schedule</h4>
      </div>
      <div class="modal-body">
       <form action="createSchedule" id="scedulForm" method="post"  commandName="scheduleForm"  role="form">
			 <fieldset>
			    <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Please choose Local.</label>
			      <div class="controls">
				        <select class="form-control" id="localIdSelector" name="idSalle">
				           <script type="text/javascript">
				           var option="<option>Local</option>"; 
				            $("#localIdSelector").append(option);
				           var localsList = ${locals};
				           for(var i=0;i<localsList.length;i++)
				           {
				             var option="<option value=\""+localsList[i]._id+"\"> Etage "+localsList[i].etage+", " +localsList[i].idBatiment[0].adresse +", "+ localsList[i].capacite +" palces , "+ localsList[i].description+"</option>"; 
				              $("#localIdSelector").append(option); 

				           }   
				           </script>
							
					    </select>
			      </div>
			    </div>
			     <div class="control-group">
			      <!-- Password -->
			      <label class="control-label"  for="description">Please choose Conference.</label>
			      <div class="controls">
				        <select class="form-control" id="confrerencesSelect" name="idPresentation">
							    <script type="text/javascript">
							      var option="<option>Conference</option>"; 
					              $("#confrerencesSelect").append(option); 
						           var confList = ${conferences};
						           for(var i=0;i<confList.length;i++)
						           {
						              var option="<option value=\""+confList[i]._id+"\">"+confList[i].titre+", " +confList[i].nombreParticipants +" participants , "+ confList[i].dureeHeure +" h , "+ confList[i].dureeMinute +" Min , par "+ confList[i].presentateur+"</option>"; 
						              $("#confrerencesSelect").append(option); 
		
						           }  
						          
						         </script>
					    </select>
					  
			      </div>
			    </div>
			    <div class="control-group">
			      <label class="control-label" for="buildingID">Date</label>
			       <div class="form-group">
		               <div class='input-group date' id='datetimepicker5'>
		                    <input type='text' class="form-control form_datetime" name="date" value="" placeholder="2015-02-23"/>
		                    <span class="input-group-addon">
		                        <span class="glyphicon glyphicon-calendar"></span>
		                    </span>
		                </div>
		                 <script type="text/javascript">
		                   $(".form_datetime").datetimepicker({
		                	   format: 'yyyy-mm-dd',
		                	   defaultDate: new Date()
		                	   
		                   });
			            </script>
                   </div>
                  
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="buildingID">Start Hour</label>
			      <div class="controls">
			        <input type="text" id="buildingID" name="heureDebut" placeholder="2" class="input-xlarge form-control">
			      </div>
			    </div>		 
			    <br/>
			     <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			         <button id="addButton" type="submit" class="btn btn-success">Confirm</button>
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
