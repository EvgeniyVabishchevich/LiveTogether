var roomUrl = null;
var userLogin = null;
var stompClient = null;
var messageInput = document.getElementById("text");
var previousTime;

video.controlBar.progressControl.seekBar.on('mouseup', function (){
    setTimeout(() => {
        video.pause();
        sendVideoChangeStateMessage("REWIND");
    }, 0); //Без таймаута не работает
})
video.controlBar.progressControl.on('mouseup', function (){
    setTimeout(() => {
        video.pause()
        sendVideoChangeStateMessage("REWIND")
    }, 0); //Без таймаута не работает
})

video.on("timeupdate", function(e) {
    previousTime = video.currentTime();
});

video.bigPlayButton.on("click", function () {
    sendVideoChangeStateMessage('PLAY');
})

video.controlBar.playToggle.on("click", function () {
    if (video.paused()) {
        sendVideoChangeStateMessage("PAUSE")
    } else {
        sendVideoChangeStateMessage("PLAY")
    }
})

function sendChatMessage() {
    var messageContent = messageInput.value.trim();

    var inputMessage = {
        messageType: 'CHAT',
        text: messageInput.value,
    };

    sendMessage(inputMessage);

    messageInput.value = '';
}

function sendVideoChangeStateMessage(playerAction) {
    var inputMessage = {
        messageType: 'PLAYER',
        playerAction: playerAction,
        currentTime: video.currentTime()
    }

    sendMessage(inputMessage);
}

function sendMessage(inputMessage) {
    inputMessage.sender = userLogin;

    stompClient.send("/app/communication/" + roomUrl, {}, JSON.stringify(inputMessage));
}

function receiveMessage(payload) {
    var message = JSON.parse(payload.body);

    switch (message.messageType) {
        case 'CHAT':

            var response = document.getElementById('response');
            var p = document.createElement('p');

            p.appendChild(document.createTextNode( message.text));
            response.appendChild(p);

            break;

        case 'PLAYER':
            if(message.sender === userLogin) return;
            switch (message.playerAction) {
                case 'PLAY':
                    video.play();
                    break;
                case 'PAUSE':
                    video.pause();
                    break;
                case 'REWIND':
                    video.currentTime(message.currentTime);
                    video.pause();
                    break;
            }
            break;
    }
}

function connect(roomUrl, userLogin) {
    window.roomUrl = roomUrl;
    window.userLogin = userLogin;

    var socket = new SockJS('http://localhost:8080/communication', null, {
        transports: 'websocket'
    });
    stompClient = Stomp.over(socket);
    stompClient.connect({}, onConnected, onError);
}
function onConnected() {
    stompClient.subscribe('/topic/' + roomUrl, receiveMessage);
}

function onError(error) {
    console.log("There is an error", error);
}