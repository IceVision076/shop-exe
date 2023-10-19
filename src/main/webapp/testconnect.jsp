<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/17/2023
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    #chatLog {
        padding: 10px;
        height: 600px;
        border-radius: 10px;
        border: #0bff7e solid;
        overflow: scroll;
    }

    #chatContainer {
        padding: 10px;
        border-radius: 10px;
        border: #0a53be solid;
    }

    span {
        color: #25cff2;;
    }
   .userMe{
    color: red;
   }
   .userYou{
       color: yellow;
   }

</style>


<div id="chatContainer">
    <div id="chatLog"></div>
</div>


<textarea name="" id="messageArea" cols="30" rows="10"></textarea>
<br>
<button onclick="send()">Gửi</button>


<button onclick="toii()">Click</button>


<script>
    var chatLog = document.querySelector("#chatLog");
    var server = new WebSocket('ws://localhost:8111/VapeShop_war_exploded/chatAll');
    var username = '${sessionScope.user.userName}';
    var otherJoined = true;

    var disconnect;
    var messageArea = document.querySelector("#messageArea");
    server.binaryType = 'arraybuffer';


    function inforMessage(infor) {
        var timeSend = document.createElement("span");
        var newElement = document.createElement("h4");
        timeSend.innerHTML = "" + (new Date()).toLocaleString();
        newElement.appendChild(timeSend);
        newElement.innerHTML += ": " + infor;
        chatLog.appendChild(newElement);

    }

    server.onopen = function () {
        var infor = "Đã kết nối tới server";
        inforMessage(infor);
    }
    server.onclose = function () {
        var infor = "Đóng kết nối server";
        inforMessage(infor);
    }
    server.onmessage=function (event){
        if(event.data instanceof ArrayBuffer){
            var message =JSON.parse(String.fromCharCode.apply(null,new Uint8Array(event.data)));
            console.log(message);

            // objectMessage(message);
            inforMessage(message.user+" :"+message.content);
            if(message.type == 'JOINED') {
                otherJoined = true;
                if(username != message.user)
                    infoMessage('You are now chatting with ' +
                        message.user + '.');
            }
        }

    }

    var objectMessage= function (message){

        var date = message.timestamp == null ? '' :
            moment.unix(message.timestamp).format('h:mm:ss a');
        // chèn thẻ
        var timeSend = document.createElement("span");
        var newElement = document.createElement("h4");
        if(message.user!=null){
            if(message.user==username) {
                newElement.setAttribute("class","userMe")
            }
            else{
                testuserYou.setAttribute("class","userYou");
            }
        }
        timeSend.innerHTML = "" + date;
        newElement.appendChild(timeSend);


        var infor="("+ message.user+") "+message.content;
        newElement.innerHTML += ": " + infor;
        chatLog.appendChild(newElement);


    }
     function send() {
        if (server == null) {
            var info = "Kết nối với server không thành công vui lòng kiểm tra lại";
            inforMessage(info);
        } else if (!otherJoined) {
            var info = "Vui lòng chờ nhân viên phục vụ";
            inforMessage(info);
        } else if(messageArea.value.trim().length>0) {
            var message = {
                timestamp: new Date(), type: 'TEXT', user: username,
                content: messageArea.value.trim()
            };
           console.log(message);
            try{
                var json =JSON.stringify(message);
                var length =json.length;
                var buffer =new ArrayBuffer(length);
                var array=new Uint8Array(buffer);
                for(var i = 0; i < length; i++) {
                    array[i] = json.charCodeAt(i);
                }
                server.send(buffer);
                messageArea.value='';
            }
            catch (error){
                var infor="Lỗi khi gửi tin nhắn vui lòng thử lại sau";
                inforMessage(infor);
            }
        }
    }
    disconnect=function (){
        if(server!=null){
            inforMessage("Kết thúc");
            server.close();
            server=null;

        }
    }

    // test
    function toii() {
        console.log(messageArea.value.trim());
        messageArea.value='';
       var info = "Đã kết nối tới server";
        inforMessage(info);
        var testuserMe =document.createElement("h4");
        testuserMe.innerHTML="Đây chỉ là test";
        testuserMe.setAttribute("class","userMe")

        var testuserYou =document.createElement("h4");
        testuserYou.innerHTML="Đây chỉ là test";
        testuserYou.setAttribute("class","userYou");

        chatLog.appendChild(testuserMe);
        chatLog.appendChild(testuserYou)
    }


</script>
</body>
</html>
