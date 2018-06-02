var app = angular.module('index', []);
app.controller('indexCtrl', function($scope) {
  const vm = this

  init = function() {
    console.log(vm)
  }

  init();
});
