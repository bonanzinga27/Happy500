/**
 * Created by lorenzogagliani on 11/02/17.
 */
app.factory('ChatService', ['$resource',
    function ($resource){
        var url="/ebuonweekend-web";
        return $resource(url, {}, {
            //actions
            getSenders: {
                method: 'POST',
                url: url + "/getSenders",
                isArray: true,
                params: {
                    receiver: '@receiver'
                }
            },
            getConversation: {
                method: 'POST',
                url: url + "/getMessages",
                isArray: true,
                params: {
                    sender:     '@sender',
                    receiver:   '@receiver'
                }
            },
            sendHandshake: {
                method: 'POST',
                url: url + "/sendHandshake",
                //isArray: true,
                params: {
                    sender:     '@sender',
                    receiver:   '@receiver'
                }
            },
            sendPrivateMessage: {
                method: 'POST',
                url: url + "/sendMessage",
                //isArray: true,
                params: {
                    sender:     '@sender',
                    receiver:   '@receiver',
                    message:    '@message'
                }
            },
            getHandedHouses: {
                method: 'POST',
                url: url + "/getHandedHouses",
                params: {
                    sender: '@sender',
                    receiver: '@receiver'
                }
            }
        });
    }]);