/*
สร้าง controller ชื่อ LoginController
โดยใช้งาน service คือ $scope, $http, $Login
*/
app.controller('LoginController', function($scope, $http, $Login) {
	
	$scope.login = function() {
		var userName = $scope.userName 
		var passWord = $scope.passWord 

		// get ข้อมูลจาก path http://localhost:8080/login/{userName}/{passWord}
		$http.get(SERVER_URL + '/login/'+userName+'/'+passWord)
		.success(function(user) {
			//setUser ใน service $Login
			$Login.setUser(user)

			//ถ้าค้น userName กับ passWord เจอ if(user) จะเป็น จริง
			if(user) {
				//แยกหน้า ไปตาม level
				switch (user.level) {
					case 'ADMIN' :
						app.navi.resetToPage('/pages/admin/index.html')
						break 
					case 'USER' :
						app.navi.resetToPage('/pages/user/index.html')
						break 
				}
			} else {
				ons.notification.alert({
					message: 'userName/passWord ไม่ถูกต้อง!'
				})
			}
		})
	}

	$scope.logout = function() {
		$Login.setUser(false)
		app.navi.resetToPage('index.html')
	}
})