	var app = angular.module("myApp",
    [
        "ngRoute",
        "ngResource",
        "myModule"
    ]);


app.config(["$routeProvider", "$locationProvider","$qProvider",
    function ($routeProvider, $locationProvider, $qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
        $locationProvider.html5Mode({enabled: true});
        $routeProvider
            .when("/", {
                template: "<index></index>"
            })
            .when("/hotels", {
                template: "<my-hotels></my-hotels>"
            })
            .when("/allHotels",{
                template: "<all-hotels></all-hotels>"
            })
            .when("/searchHotels",{
                template: "<search-hotels></search-hotels>"
            })
            .when("/singPage",{
                template: "<user-login></user-login>"
            })
            .otherwise({
                redirectTo: "/"
            });
    }]);

app.controller("MenuController", function ($scope, $location, AddHotel, GetAll, SearchLessThan, SearchByCity, Login, SignIn, Delete, SendFile) {

    $scope.goTo = function (address) {
        $location.path(address);
        $scope.selected = address;
    };
    $scope.submit = function () {

        AddHotel.save({},$scope.hotel,
            function () {
                console.log('Otel saved');
            },function () {
                console.log('Could not be saved');
            });

    };
    $scope.getAllHotels = function () {
        $scope.hotels = GetAll.query();
    };

    $scope.searchHotels = function () {
        $scope.hotels = SearchLessThan.query({price:$scope.priceToSearch});
    };
    $scope.searchHotelsIn = function(){
        $scope.hotels2 = SearchByCity.query({address:$scope.address});
    };
    $scope.login = function(){
        document.cookie = "sessionID" + "=" + $scope.body.token;
       $scope.message2 = Login.get({username:$scope.username,password:$scope.password,token:$scope.body.token}); // login.save returns body

    };
    $scope.singIn = function(){
        $scope.user = {username:$scope.username,password:$scope.password,role:$scope.role};
        SignIn.save($scope.user,
            function () {
                console.log('you are now member');
            },function () {
                console.log('buzz off');
            });
    };
    $scope.random = function(){
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = characters.length;
        for ( var i = 0; i < 10; i++ ) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        return result;
    };
    $scope.get = function(){
        var name = "sessionID" + "=";
        var ca = document.cookie;
        var result = '';
        for(var i = 0; i < ca.length; i++) {
            var c = ca[i];
            if(c !== name[i]){
                result = result + c;
            }
        }
        return result;
    };
    $scope.show = function() {
    };
    $scope.delete = function () {
        $scope.deletereturn = Delete.save({},$scope.body,
            function () {
                console.log('User Deleted');
            },function () {
                console.log('User Could not Deleted');
            });
    }
});

app.factory("AddHotel", function($resource){
    return $resource("http://localhost:8080/hotels");
});
app.factory("GetAll", function($resource){
    return $resource("http://localhost:8080/hotels/all");
});
app.factory("SearchLessThan", function($resource){
    return $resource("http://localhost:8080/hotels/price/:price",{price:'@price'},{
        getLesserPrice: {
            method: 'GET', isArray:true
        }
    });
});
app.factory("SearchByCity", function($resource){
    return $resource("http://localhost:8080/hotels/address/:address",{address:'@address'},{
        getByCity:{
            method: 'GET', isArray:true
        }
    });
});
app.factory("Login",function ($resource) {
    return $resource("http://localhost:8080/users/login/:username/:password/:token",{username:'@username',password:'@password',token:'@token'},{
        findUser: {
            method: "GET",
            isArray:false
        }
    });
});
app.factory("Delete",function ($resource) {
    return $resource("http://localhost:8080/users/myUser/delete");
});
app.factory("SignIn",function($resource){
    return $resource("http://localhost:8080/users");
});
app.factory("SendFile",function($resource){
    return $resource("http://localhost:8080/hotels/file/:inputFile",{inputFile:'@inputFile'},{
        sendFile:{
        method:"GET"
    }
    });
});

