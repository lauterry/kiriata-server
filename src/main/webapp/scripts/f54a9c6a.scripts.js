'use strict';

// Declare app level module which depends on filters, and services
var kiriataApp = angular.module('kiriataApp', ['ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/movieList', {
        templateUrl: 'views/movieList.html',
        controller: 'MovieListCtrl'
      })
      .when('/movieDetail/:code', {
        templateUrl: 'views/movieDetail.html',
        controller: 'MovieDetailCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);

'use strict';

kiriataApp.controller('MainCtrl', function($scope) {

});

'use strict';

kiriataApp.controller('SearchCtrl', function($scope, $resource, $location) {

    $scope.search = function(){

        $scope.allocine = $resource("http://api.allocine.fr/rest/v3/:action",
            {action:'search', q:'love', partner:'YW5kcm9pZC12M3M', format:'json', callback:'JSON_CALLBACK'},
            {get:{method:'JSONP'}}
        );

        $scope.movies = $scope.allocine.get({q:$scope.searchInput});

        $location.path('/movieList');

    }

});

'use strict';

kiriataApp.controller('MovieListCtrl', function($scope, $location) {

});

'use strict';

kiriataApp.controller('MovieDetailCtrl', function($scope, $resource, $routeParams) {
    $scope.allocine = $resource("http://api.allocine.fr/rest/v3/:action",
        {action:'movie', code:'0', partner:"YW5kcm9pZC12M3M", profile:'small', format:'json', callback:'JSON_CALLBACK'},
        {get:{method:'JSONP'}}
    );

    $scope.movie = $scope.allocine.get({code:$routeParams.code});

});
