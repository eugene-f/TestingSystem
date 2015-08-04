var app = angular.module('app', ['ngMaterial']);

app.config(function ($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('indigo')
        .accentPalette('pink')
        .warnPalette('red')
        //.backgroundPalette('blue-grey')
    ;
});



app.controller('AppCtrl', function ($scope, $mdDialog) {
    $scope.alert = '';
    $scope.showRegistrationDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/user/admin/registration_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
    $scope.showLoginDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/components/login_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
    $scope.showCreateTestDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/user/tutor/create_test_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
    $scope.showCreateQuestionDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/user/tutor/create_question_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
    $scope.showSolveTestDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/user/student/solve_test_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
    $scope.showAboutDialog = function (ev) {
        $mdDialog.show({
            controller: DialogController,
            templateUrl: '/components/about_dialog.jsp',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
            .then(function (answer) {
                $scope.alert = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.alert = 'You cancelled the dialog.';
            });
    };
});
function DialogController($scope, $mdDialog) {
    $scope.hide = function () {
        $mdDialog.hide();
    };
    $scope.cancel = function () {
        $mdDialog.cancel();
    };
    $scope.answer = function (answer) {
        $mdDialog.hide(answer);
    };
}
