/**
 * Created by bonan on 11/02/2017.
 */
app.factory('JourneyService',['$resource', function($resource){
    var url="/ebuonweekend-web";
    return $resource(url, {}, {
        getJourney: {
            method: 'GET',
            url: url + "/searchMyJourneys",
            isArray: true,
            params: {
                user: '@nick'
            },
            transformResponse: function (data) {
                return angular.fromJson(data);
            }
        },
    });
}]);