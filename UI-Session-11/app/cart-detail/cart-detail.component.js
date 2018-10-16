angular.module('cartDetail').
    component('cartDetail',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: function CartDetailController($http,$scope,$rootScope){
            var self = this;
            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
                var item;
                self.totalOrderPrice=0;
                for(item in self.items){
                    self.totalOrderPrice += self.items[item].totalPrice;  
                }
            });

            
            $scope.deleteAll=function(){
                
                var item=1;
                for(item in self.items){
                    $http.delete('http://localhost:3000/cart/' + self.items[item].id, item).then(function(response){
                    })
                }
                $rootScope.cartCount=0;
                window.location.reload();
            }

        }
    });