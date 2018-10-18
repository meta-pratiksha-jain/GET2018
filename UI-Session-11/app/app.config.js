angular.module('ShoppingApp').
config(['$locationProvider', '$routeProvider',
        function config($locationProvider, $routeProvider) {

        $locationProvider.hashPrefix('!');
        $routeProvider.
        when('/', {
            template: '<item-list></item-list>'
        }).
        when('/products/cart/', {
            template: '<cart-detail></cart-detail>'
        }).
        when('/products/shipping/', {
            template: '<shipping-detail></shipping-detail>'
        }).
        when('/products/order-success/',{
                    template:'<order-success></order-success>'
                }).
        when('/products/orders/',{
                    template:'<order-list></order-list>'
                }).
        otherwise({
            template: '<item-list></item-list>'
        });
}]);
