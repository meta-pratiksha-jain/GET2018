'use strict';
angular.
module('userList').
component('userList', {
    templateUrl: 'user-list/user-list.template.html',
    controller: function UserController($scope, $http) {
        $scope.userData;
        var self = this;
        
        $http.get('http://localhost:3000/users').then(function (response) {
            self.users = response.data;
        });

        $scope.postData = function () {
            if($scope.user.id==null){
            $http({
                method: 'POST',
                url: 'http://localhost:3000/users/',
                data: $scope.user,
                dataType: 'json'
            });
            }
            else{
                $http.put('http://localhost:3000/users/' + $scope.user.id,$scope.user);
            }
            window.location.reload();
        };

        $scope.editUser = function(userId){
            $http({
                method: 'GET',
                url: 'http://localhost:3000/users/' + userId
            }).then(function (response){
                $scope.user = response.data;
            });
        } 
        $scope.resetUser = function(){
            $scope.user.id = null;  
            $scope.user.name = null;
            $scope.user.city = null;
            $scope.user.contact = null;
        }
    }
});
