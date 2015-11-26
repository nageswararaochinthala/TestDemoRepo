<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance Management System</title>
<script src="angularJs/angular.js"></script>
<script src="js/ForgotPassword.js"></script>
<link rel="stylesheet" type="text/css" href="css/ForgotPassword.css">
</head>
<body ng-app="myapp" ng-controller="myctrl" id="body" >
<p ><h2><font color="green">{{msg}}</font></h2></p>
<p ><h2><font color="red">{{msg1}}</font></h2></p>
       <div id="div1" ng-hide="hide">
            <div id="div2">
                 <img src="http://s30.postimg.org/5mqz3osvl/Forgot_Password_icon.png" width="90"  height="120">
            </div>
            <div id="div3" >
                  <h2>Forgot your password?</h2>
            </div>
           
            <div id="div4">
                   <form  name="myForm" ng-submit="getPassword()" novalidate>
                   <p>Please Enter Your Admin Id and Registered Email Address, We will send password to your mail</p>
 
                   <input  type="text" id="adminId" ng-model="username" ng-keyup="checkId()" placeholder="Please enter Admin Id" maxlength="6" required><span style="color:red">  {{invalidId}}</span><br>
                   <input id="email" type="email" name="email" ng-model="email" ng-focus="idValidation()" placeholder="Please enter Email Id" required>
        <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
        <span ng-show="myForm.email.$error.required">Email is required.</span>
           <span ng-show="myForm.email.$error.email">Invalid email address.</span>
          </span>
         </p>
                   <p ><font color="red">{{valid}}</font></p>
            <p>
            <input type="submit" id="btn" 
              ng-disabled="myForm.email.$dirty && myForm.email.$invalid">
              </p>

            </form>

             </div>
           <div id="div5">
                    <a href="/EmployeeManagementSystem/adminLogin.do" >BACK TO  Admin LOGIN</a>
           </div>
         
</div>
</body>
</html>