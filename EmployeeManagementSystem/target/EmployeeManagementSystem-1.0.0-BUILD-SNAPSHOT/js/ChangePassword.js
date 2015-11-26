
var app=angular.module('myapp',[]);
var st="";
app.controller('myctrl',function($scope,$http){
	$scope.getChange= function(){
		if($scope.cpwd!=null && $scope.npwd!=null && $scope.rpwd!=null)
			{
			
			if($scope.cpwd!=$scope.npwd)
			{
					if($scope.npwd==$scope.rpwd )
					{
	
						$scope.valid="";
							$http({
							method : 'POST',
							url : 'changePassword.do?cpwd='+$scope.cpwd+'&&npwd='+$scope.npwd
	            
	            
					}).success(function(data, status, headers, config) {
	     
							//$scope.hide=true;
	    	
							$scope.msg=data ;
							//$scope.msg=request.getParametersByName("status") ;
	      
	    	    	
	     }).error(function(data, status, headers, config) {
	    	 $scope.hide=true;
	    	   $scope.msg1="Some internal problem occured try again.";
	    	   
	     });
			}
		else{
			$scope.valid="new password and confirm password must same";
		}
			}
			else{
				$scope.valid="current password and new password should not be same";
			}
			}
		else
			{
			$scope.valid="fields should not be empty";
			}

	};

});
