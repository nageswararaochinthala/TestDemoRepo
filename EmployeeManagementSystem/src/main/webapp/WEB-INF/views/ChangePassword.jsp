<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="./js/ChangePassword.js"></script>
<link rel="stylesheet" type="text/css" href="./css/ChangePassword.css">
<style>
#div1 {
	width: 650px;
	height: 305px;
	padding: 10px 0px 0px 10px;
	border-radius: 10px;
	background-color: #f0f8ff;
}
</style>
</head>
<body id="body" ng-app="myapp" ng-controller="myctrl">
 <p ><h2><font color="green">{{msg}}</font></h2></p>
<p ><h2><font color="red">{{msg1}}</font></h2></p>
	<div id="div1" ng-hide="hide">
	     <div id="div2">
		      	<img src="http://s11.postimg.org/89jw5zva7/editicon.png" width="90"
				        height="120"></div>
		        <div id="div0">
			          <h2>Change your password</h2>
		        </div>
		  <div id="div3">
			    <label>Current password</label><br>
			    <br> <label>New password</label><br>
			    <br> <label>Re-enter the new password</label>
		  </div>
		  <div id="div4">
			   <input type="password" ng-model="cpwd" ><br>
			    <br> <input type="password" ng-model="npwd"><br>
			    <br> <input type="password" ng-model="rpwd">
			    <p><font color="red">{{valid}}</font></p>
			     <p>
		     <% if(request.getAttribute("status") != null) 
			    {
			    %>
			    <font color="green"><%= request.getAttribute("status") %></font> 
			    <% 
			    }
			    %>
			    </p>
			    <button ng-click="getChange()">Save</button>
		  </div>
	 </div>
	
</body>
</html>