let receiver = $(".checkUser").val();
let stomp="";

window.onload=function (){
    if(receiver != null){
        let socket = new SockJS('/websocket');
        stomp = Stomp.over(socket);
        stomp.connect({}, function () {
            console.log('연결됨');
            stomp.subscribe('/sub/alarm/'+receiver, function (result){
                let parsingResult = JSON.parse(result.body);
                console.log(parsingResult);
                $("#boxAlarm").empty();
                $("#boxAlarm").append(viewMessage(parsingResult));
            });
        });
    }
}

function viewMessage(message){
    let sender =  message.sender;
    let alarmType = message.alarmType;

    // message = message.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp");

    let resultMessage =`<div>`+sender+`이 `+alarmType+`</div>`;
    return resultMessage
}
// topbar---------------------------------------------------------------------


function sendData(){
    let writer = $("#writer").val();
    let data = {
        'receiverUsername': writer,
        'alarmType':'구독함',
        'sender':receiver,
    };

    stomp.send("/pub/alarm", {}, JSON.stringify(data));
}
// company detail-----------------------------------------------------------------