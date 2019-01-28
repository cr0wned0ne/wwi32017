var myAngularApp = angular.module('myAngularApp', []);


myAngularApp.controller('mainController', function($scope) {

$scope.name="default";
  $scope.login = function() {
    console.log("User logged in:" + $scope.name);
  }

  $scope.validate = function() {
    return $scope.name.length > 3 && $scope.name.length < 10;
  }


  $scope.users = [
    {username:'admin', email : 'admin@admin.de' },
    {username:'qwert', email : 'qwert@admin.de' },
    {username:'tester', email : 'admin@admin.de' },
    {username:'stefan', email : 'bla@admin.de'}
  ]

});


myAngularApp.controller('headerController', function($scope) {

  $scope.login = function() {
    console.log("User logged in:" + $scope.name);
  }

});
