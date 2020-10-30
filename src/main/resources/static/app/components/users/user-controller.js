(function (angular) {
    'use strict';
    /*controllers*/
    angular.module('cms.modules.user.controllers', []).
    controller(
        'UserCreateController',
        [
            '$scope','UserService',
            function ($scope,UserService) {
                $scope.resetForm = function () {
                    $scope.user = null;
                };
                $scope.create = function (user) {
                    UserService.create(user).then(
                        function (data) {
                            console.log("success on creating user!")
                        },
                        function (err) {
                            console.log("Error on creating user")
                        }
                    );
                };
            }
        ]
    ).
    controller(
        'UserListController',
        [
            '$scope','UserService',
            function ($scope, UserService) {
                UserService.find().then(
                    function (data) {
                        $scope.users = data;
                    },
                    function (err) {
                        console.log(err);
                    }
                );
            }
        ]
    );

})(angular);