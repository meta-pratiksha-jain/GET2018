angular.module('orderList').
    component('orderList',{
        templateUrl:"order-list/order-list.template.html",
        controller:function OrderListController($http,$scope,$rootScope){
            var self=this;

            $http.get('http://localhost:3000/orders').then(function(response){
                self.orders = response.data;
            });

            $scope.getOrder=function(orderId){
            
                $http.get('http://localhost:3000/orders/'+ orderId).then(function(response){
                    self.items = response.data.items;
                    var item;
                    self.totalOrderPrice=0;
                    for(item in self.items){
                        self.totalOrderPrice += self.items[item].totalPrice;  
                    }
                });
            }
            //console.log(self.orders[0].user-id);
        }
    });