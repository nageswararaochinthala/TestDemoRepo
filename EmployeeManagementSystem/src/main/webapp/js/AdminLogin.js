
var app=angular.module("myapp",[]);
app.controller("MyController", function($scope,$http,$window){
		
	/*default values*/
	
	$scope.passwordType="password";
	
	$scope.isDisable=true;
	$scope.admin={};

	$scope.idValidation=function(){
		if($scope.admin.id!=""){
			$scope.validationMsg1="";
		    
			if( $scope.admin.id.match(/^[0-9]*$/)){
				
				$scope.validationMsg1="";
			
			
			if($scope.admin.id.length>=2){
			    $scope.validationMsg1="";
			
             if($scope.admin.id.length<=6){
        	    $scope.validationMsg1="";	
		 		
        	   $scope.isDisable=false;
		 		
		 		/*flag1=false;
		 		if(flag1==false && flag2==false){
		 			
		 			$scope.isDisable=false;
		 			
		 		}else{
		 			
		 			$scope.isDisable=true;
		 			flag1=true;
		 		}*/
		     	}else{
		     		$scope.isDisable=true;	
			    	/*$scope.validationMsg1="Id cannot be grater than 6 digit"*/
		     		$scope.validationMsg1="Invalid AdminId";
			   }
			
		     }else{
		    	 $scope.isDisable=true;
			     /*$scope.validationMsg1="Admin ID can not less than 4 digit";*/
		    	 $scope.validationMsg1="Invalid AdminId";
			   	
		   }
			}else{
				$scope.isDisable=true;
				$scope.validationMsg1=" only digits allowed"
			}
	     }else{
	    	 $scope.isDisable=true;		
 		     $scope.validationMsg1="Admin ID can not be empty";
		 	
	  }
    };	
    
    /*function to show password*/	      
    $scope.showPass=function(){
	
	   $scope.passwordType=($scope.showPassword)? "text":"password";
	
    }
	
	$scope.passwordValidation=function(){
		
		if($scope.admin.pass!=""){
			
			 $scope.validationMsg1="";
		     if($scope.admin.pass.length>=3){
			    $scope.validationMsg2="";
			    $scope.isDisable=false;
		     }
			
        /*   if($scope.admin.pass.length<=10){
      	    $scope.validationMsg2="";	
		    $scope.isDisable=false;
      	    flag2=false;
      	    if(flag1==false&&flag2==false){
      	    	$scope.isDisable=false;
      	    	
      	    }else{
      	    	
      	    	$scope.isDisable=true;
      	    	flag2=true;
      	    }
      	    
		     	}else{
		     		$scope.isDisable=true;	
			    	$scope.validationMsg2="password can't be grater than 10 digit";
		     		$scope.validationMsg2="password ";
			   }
			
		     }else{
		    	 $scope.isDisable=true;
			     $scope.validationMsg2="password can't less than 6 digit";
			    	
		   }*/
	     }
		     else{
	    	 $scope.isDisable=true;
		     $scope.validationMsg2="password can't be Emptly";
		 	
	  }
			
		
	}

	$scope.clearFields=function(){
		$scope.admin.id="";
		$scope.admin.pass="";
	}
	
	$scope.adminLogin = function() 
	{
		var adminObj={adminId:$scope.admin.id,password:$scope.admin.pass};
		console.log("in admin login");
	    console.log("admin: "+adminObj.adminId+" "+adminObj.password);
	    if($scope.admin.id.length <= 15 && $scope.admin.pass.length <= 30 && $scope.admin.id.length >= 2 && $scope.admin.pass.length >= 2){
	        $http({
	          method: 'POST',
	          url: '/EmployeeManagementSystem/adminHome.do',
	          headers: {'Content-Type': 'application/json'},
	          data:  adminObj
	          }).success(function (data) 
	             {	    	
	    	        console.log("inside sucecess: data"+data);
	    	        if(data == 1){
	    		       console.log("login success");
	    		       $window.location.href = '/EmployeeManagementSystem/adminHomePage.do';
	    		
	    	        }
	    	        else{
	            
				       $scope.admin.pass='';
				       $scope.adminInvalidMsg=(data == 0)? "Invalid Password" : "Invalid AdminID & password";
	    	        }
	            });
	        
	    }//if end
	    else{
	    	$scope.adminInvalidMsg="Invalid Input";	
	    }
	        
	  };
	  
	  $scope.gotoAttendancePage=function(){
		  
		  $window.location.href="/EmployeeManagementSystem/log.do";
		  
	  };
	  
	  $scope.forgotPassword=function(){
		  $window.location.href = '/EmployeeManagementSystem/forgotPasswordPage.do';
	  };
	
		
	});