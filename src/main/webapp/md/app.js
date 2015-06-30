var app = angular.module('app', ['ngMaterial']);

app.config(function($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('cyan')
        .accentPalette('deep-purple')
        .warnPalette('red')
        //.backgroundPalette('blue-grey')
    ;
});