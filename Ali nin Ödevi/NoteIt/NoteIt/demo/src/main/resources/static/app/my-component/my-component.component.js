angular.module("myModule") //routing part?
    .component("index", {
        templateUrl: "/template/index.html",
        controller: function ($scope) {

        }
    })
    .component("myHotels", {
        templateUrl: "/template/hotels.html",
        controller: function ($scope) {

        }
    })
    .component("allHotels", {
        templateUrl: "/template/allHotels.html",
        controller: function ($scope) {

        }
    })
    .component("searchHotels",{
        templateUrl: "/template/searchHotels.html",
        controller: function($scope){

        }
    })
    .component("userLogin",{
        templateUrl: "/template/singPage.html",
        controller: function($scope){

        }
    })
;