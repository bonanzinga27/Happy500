/**
 * Created by lorenzogagliani on 11/02/17.
 */

app.controller('chatController', function($scope, $cookies, $filter, $location, ChatService, SearchService) {

    $scope.myProfilePicture = $cookies.get('myProfilePicture');
    $scope.picture = "";
    $scope.users = {};
    $scope.conversation = {};
    $scope.nick_rcv = "";
    $scope.message = "";
    $scope.newMessage = {};

    $scope.buttonSend = false;
    $scope.buttonHandshake = false;

    $scope.houses = {};

    $scope.users = ChatService.getSenders({
            receiver: $cookies.get('nick')
        },
        function(data){
            if(data.length === 0){

            }
            else{

            }

        },function(error){
            alert("Error: Get Senders, try again");
        }
    );




    $scope.showConversation = function (rcv) {

        $scope.buttonSend = false;
        $scope.buttonHandshake = false;


        $scope.picture = rcv.profilePicture;
        $scope.nick_rcv = rcv.nickName;

        $scope.conversation = ChatService.getConversation({
                sender: $cookies.get('nick'),
                receiver: rcv.nickName
            },
            function(data){
                for (var i = 0; i < $scope.conversation.length; i++){
                    if ($scope.conversation[i].isHand === "2"){
                        $scope.buttonSend = true;
                        $scope.buttonHandshake = true;
                    }
                }

            }
        );
    };

    $scope.isMyMessage = function(sender){
        return ($cookies.get('nick') === sender)
    };


    $scope.sendHandshake = function (nick_receiver) {
        ChatService.sendHandshake({
                sender: $cookies.get('nick'),
                receiver: nick_receiver
            },
            function(data){
                if(data.returnObject){

                }else {

                }
            }
        );
    };

    $scope.sendPrivateMessage = function (nick_receiver) {
        ChatService.sendPrivateMessage({
                sender:     $cookies.get('nick'),
                receiver:   nick_receiver,
                message:    $scope.message
            },
            function(data){
                if(data.returnObject){
                    var data_tmp = new Date();
                    data_tmp = $filter('date')(data_tmp, "dd/MM/yyyy");
                    data_tmp = data_tmp.split('/');
                    $scope.newMessage = {   'message' : $scope.message,
                                            'sender' :  $cookies.get('nick'),
                                            'dataMessage':  {
                                                dayOfMonth: data_tmp[0],
                                                monthValue: data_tmp[1],
                                                year:       data_tmp[2]
                                            }
                                        };
                    $scope.conversation.push($scope.newMessage);
                    $scope.message = "";
                }else {

                }
            }
        );

    };

    $scope.searchHouseUser = function (user) {
        SearchService.setTipoRicerca('user');
        SearchService.setUser(user);
        $location.path('/search');
    };


    $scope.selectDays = function(rcv){
        ChatService.getHandedHouses({
            sender: $cookies.get('nick'),
            receiver: rcv
        },
        function (data) {
            if(data.returnObject != null){
                $scope.houses = data.returnObject;

                for(var i=0;i<$scope.houses.length;i++)
                    $scope.houses[i].availableDates = $scope.houses[i].availableDates.split(';');
            }
            else{

            }
        }

        );
    };

});
