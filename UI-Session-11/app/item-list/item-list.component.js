angular.module("itemList").
component('itemList', {
    templateUrl: 'item-list/item-list.template.html',
    controller: function ItemController($scope, $http, $rootScope) {
        var self = this;
        $rootScope.cartCount = 0;
        $http.get('http://localhost:3000/cart').then(function successCallback(response) {
            var cartItems = response.data;
            for (var cartItem in cartItems) {
                $rootScope.cartCount += cartItems[cartItem].quantity;

            }
        })


        $http.get('http://localhost:3000/items').then(function (response) {
            self.items = response.data;
        });

        $scope.addCart = function (item) {
            $rootScope.cartCount = $rootScope.cartCount + 1;
            $http.get('http://localhost:3000/cart/' + item.id).then(function successCallback(response) {

                $http({
                    method: 'PUT',
                    url: 'http://localhost:3000/cart/' + item.id,
                    data: response.data,
                    dataType: 'json'
                });
                response.data.quantity += 1;
                response.data.totalPrice = response.data.quantity * item.price;
            }, function errorCallback(response) {

                var cartData = {
                    "id": item.id,
                    "item": item,
                    "totalPrice": item.price,
                    "quantity": 1
                }

                $http({
                    method: 'POST',
                    url: 'http://localhost:3000/cart/',
                    data: cartData,
                    dataType: 'json'
                })

            });
        }

    }
})
