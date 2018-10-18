angular.module('cartDetail').
    component('cartDetail',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: function CartDetailController($http,$scope,$rootScope,$route){
            var self = this;
            self.cartCount=$rootScope.cartCount;
            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
                var item;
                self.totalOrderPrice=0;
                for(item in self.items){
                    console.log("get");
                    self.totalOrderPrice += self.items[item].totalPrice;  
                }
            });

            
            $scope.deleteAll=function(){
                
                var item=0;
                for(item in self.items){
                    $http.delete('http://localhost:3000/cart/' + self.items[item].id, item).then(function(response){
                        console.log("deleted");
                    })
                }
                $rootScope.cartCount=0;
                console.log("dddd");
                $route.reload();
//                window.location.reload();
            }

        }
    });