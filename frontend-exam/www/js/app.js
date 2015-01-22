//เป็นการสร้าง module จาก ng-app="app" และใช้งาน module 'onsen' (setter)
//เมือสร้างเสร็จจะ มาเก็บไว้ใน ตัวแปร app ('getter')
var app = angular.module('app', ['onsen'])

//กำหนด url ของ server (spring boot)
var SERVER_URL = 'http://localhost:8080'

//สร้าง service ขื่อ $Login
app.factory('$Login', function() {
	var user = false

	return {
		getLogin : function() {
			return (user) ? user : false
		},
		setUser : function(newUser) {
			user = newUser
		}
	}
})