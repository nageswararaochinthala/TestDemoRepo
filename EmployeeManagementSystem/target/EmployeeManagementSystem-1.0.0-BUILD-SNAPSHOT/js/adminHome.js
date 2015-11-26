var app = angular.module('AdminApp', []);

app.controller('AdminController', function($scope, $http, $window) {

	/*creating variables */
	var file;
	var allowedFileExtension="xl";
	
	
	
	/* function to set default values */
	function defaultValues()
	{

		$scope.showExcelDiv = false;
		$scope.showManuallyEnterDiv=false;
		$scope.fileUploadSuccessMsg="";
	}

	/* calling defaultvalues() */
	defaultValues();

	$scope.adminStatus = "hi admin";
	console.log("in admin hom page");

	/* function for logout button */
	$scope.logout = function() {

		$window.location.href = '/EmployeeManagementSystem/adminLogout.do';

		console.log("admin logout");
	};

	/* function to show Add employee Manually division */
	$scope.showAddEmployeeDiv = function() {
       
		$scope.showManuallyEnterDiv= !$scope.showManuallyEnterDiv;
		$scope.showExcelDiv=false;
		console.log("in showAddEmployeeDiv()");
	};

	/* function to show Add employees By Excel file division */
	$scope.showFromExcelDiv = function() {
		
		console.log("in showFromExcelDiv()");
		$scope.fileUploadSuccessMsg="";
		$scope.showExcelDiv = !$scope.showExcelDiv;
		$scope.showManuallyEnterDiv	=false;

	};
		
	
	/*function for file_change()*/
	$scope.file_changed = function(element) {		
		file=element.files[0];
	    element=null;
		console.log("file extension:: "+ getFileExtension(file));
	    	
	};
	
	/*function to get file extension*/
	function getFileExtension(fileObject){
		
		return fileObject.name.split('.').pop().substring(0,2);
		
	}
	
	/*function to check file extension*/
	function checkFileExtension(extensionName){
		
		return (extensionName == allowedFileExtension)? true: false ;
		
	}
	
	/*function to upload file*/
	$scope.uploadFile=function (){		
		
		if(checkFileExtension(getFileExtension(file))){
		
		      var formData=new FormData();
	          formData.append("file",file);
	          console.log("file:  "+file);
	          $http.post('/EmployeeManagementSystem/uploadEmployeeDetailsExcelFile.do', formData, {
	                transformRequest: function(data, headersGetterFunction) {
	                    return data;
	                },
	                headers: { 'Content-Type': undefined }
	                }).success(function(data, status) {                       
	                    console.log("Success ... " + data);
	                    if(data == "00")
	                	    $scope.fileUploadSuccessMsg="uploaded success fully";
	                    else
	                	    $scope.fileUploadSuccessMsg="In excel file RowNumber:"+data.charAt(0)+" column Number:"+data.charAt(1)+" DOB is wrong";
	                }).error(function(data, status) {
	                    console.log("Error ... " + status);
	                    $scope.fileUploadSuccessMsg="Problem ocuured!";
	            });
		}
		else{
			$scope.fileUploadSuccessMsg="Please select Excel file ";
			$scope.excelFilePath="";
		}
		 
		
	};
	
	/*function to set employee default details*/
	function employeeDefaultDetails(){
		
		$scope.empId="";
		$scope.empFirstName="";
		$scope.empLastName="";
		/*$scope.DOB=new Date();*/
		
	}
	
	/*function call to set employee default values*/
	employeeDefaultDetails();
	
	/*function to add single employee details*/
	$scope.addEmployee=function(){
		
		if($scope.empId.length > 4 && $scope.empFirstName.length > 2 && $scope.empLastName > 2 &&  $scope.DOB < new Date()){
			if($scope.empId.length < 20 && $scope.empFirstName.length < 30 && $scope.empLastName < 30 ){
				
				console.log("emp data: "+$scope.empId+" "+$scope.empFirstName+" "+$scope.empLastName+" "+$scope.DOB);
			}
			else{
				
				console.log("bad request");
				$scope.addEmployeeSuccessMsg="Request too long !";
			}
			
		}
		else{
			
			console.log("invalid employee details");
			$scope.addEmployeeSuccessMsg="Invalid employee details";
		}
			
		/*$scope.empFirstName="fn";
		$scope.empLastName="ln";
		$scope.DOB=new Date();*/
		
		console.log("manually add emp : add emp()");
		
	};
	

		 


	
	
});
