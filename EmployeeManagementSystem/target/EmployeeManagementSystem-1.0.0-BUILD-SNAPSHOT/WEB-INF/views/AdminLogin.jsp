<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYP html>
<html ng-app="myapp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="angularJs/angular.js"></script>
<script src="js/AdminLogin.js"></script>
<link rel="stylesheet" href="css/AdminLogin.css">
<title>Admin Login</title>
</head>

<!--form body  -->
<body bgcolor="white" ng-controller="MyController">

<!--all html body contents comes under this div   -->
<div id="div1" >

<!--for header  -->
<div id="header">
<!--header text  -->
</div>

<div id="div2" >
<div id="div3"  >

<fieldset>
<legend align="bottom"><font class="label1">Admin Login</font></legend>
<br>

<table id="table1" cellspacing="10" align="center">

<tr >
<td><font class="label1">Admin ID</font></td>  
<td><input class="textField" type="text" ng-model="admin.id" ng-change="idValidation()" maxlength="6"></td>
<td><span class="validationMsg">{{validationMsg1}}</span></td>
</tr>

<tr>
<td><font class="label1">Password</font> </td> 
<td><input class="textField" type="{{passwordType}}" ng-model="admin.pass" ng-change="passwordValidation()">
<td ><span class="validationMsg">{{validationMsg2}}</span> </td>
</tr>

<tr align="right">
<td></td>
<td align="left" ><input type="checkbox" ng-model="showPassword" ng-click="showPass()" >Show password</td> 
<td><a href="" ng-click="forgotPassword()">forgot Passwowrd ?</a></td> 
</tr>

<tr>
<td></td>
<td align="left" ><input type="button" class=button1 value="Clear" name="b1" ng-click="clearFields()">
                  <input name="b2" type="button" class=button1 value="Sign-In" style="margin-right: 30px;" ng-click="adminLogin()"  ng-disabled="isDisable" ></td>
</tr>
</table>
<div id="adminInvalidMsgDiv"><p id="message">{{adminInvalidMsg}}</p></div>
<div id="attendanceDiv"><button id="attendanceButton" ng-click="gotoAttendancePage()">Go To Login Page</button>
</fieldset>
</div>
</div>
</div>

</body>
</html>