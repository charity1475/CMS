(function (angular) {
    'use strict';
    /*controllers*/
    angular.module('cms.modules.news.controllers',[]).
        controller(
            'NewsCreateController',
        [
            '$scope',
            'NewsService',
            function ($scope, NewsService) {
                $scope.resetForm = function () {
                    $scope.news = null;
                };
                $scope.create = function (customer) {
                    NewsService.create(customer).then(
                        function (data) {
                            console.log("Success on creating News")
                        },
                        function (err) {
                            console.log("Error on creating News")
                        }
                    );
                };
            }
        ]
    ).
        controller(
            'NewsEditController',
        [
            '$scope',
            'NewsService',
            function ($scope, NewsService) {
                $scope.findOne = function (id) {
                    NewsService.findOne(id).then(
                        function (data) {
                            $scope.product = data;
                        },
                        function (err) {
                            console.log(err);
                        }
                    );
                };
            }
        ]
    );
})(angular);