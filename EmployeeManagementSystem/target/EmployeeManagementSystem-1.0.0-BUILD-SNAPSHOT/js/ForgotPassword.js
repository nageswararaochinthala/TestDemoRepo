var app = angular.module('myapp', []);
app
		.controller(
				'myctrl',
				function($scope, $http) {

					/* default values and variable declarations */
					var adminIdLength = 6;
					var emailLength = 10;
					var flag1 = false;
					var flag2 = false;

					$scope.username = '';
					$scope.email = '';

					/* function to check admin id is number or not */
					$scope.checkId = function() {

						if ($scope.username.match(/^[0-9]*$/)) {
							$scope.invalidId = "";
							flag1 = ($scope.username.length == adminIdLength) ? true : false;
						} 
						else {
							$scope.invalidId = "only digits allowed";
						}
					};

					$scope.getPassword = function() {
						console.log("int id: " + parseInt($scope.username));
						console.log("condn:"+flag1 == true && $scope.email.length >=emailLength);
						if (flag1 == true && $scope.email.length >=emailLength) {

							$http(
									{
										method : 'post',
										url : 'forgotPasswordHome.do?id='
												+ $scope.username + "&email="
												+ $scope.email

									})
									.success(
											function(data, status, headers,
													config) {
												console.log("response status:"+data);
												$scope.hide = true;
												$scope.msg = (data == 1) ? "We sent password to your email successfully. check your email "
														: "please give correct email ID";
												$scope.msg = (data == -1)  ? "Invalid Admin Id": $scope.msg;
											})
									.error(
											function(data, status, headers,
													config) {

												$scope.hide = true;
												$scope.msg1 = "Some internal problem occured try again.";
											});
							console.log("request: "
									+ 'forgotPasswordHome.do?id='
									+ $scope.username + "&email="
									+ $scope.email);
						} else {
							$scope.valid = "Email or Admin Id is not valid";
						}

					};
					$scope.idValidation = function() {
						console.log("in ad validation");
						$scope.valid = "";
					};

				});
