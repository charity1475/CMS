(function (angular) {
    'use strict';
    /*services*/
    angular.module(
        'cms.services',
        [
            'cms.modules.category.services',
            'cms.modules.user.services',
            'cms.modules.news.services'
        ]
    );
})(angular);