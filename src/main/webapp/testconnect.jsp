<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/17/2023
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="include/header-footer/header.jsp" %>
<style>
    #chatLog {
        padding: 10px;
        height: 400px;
        border-radius: 10px;
        border: #0bff7e solid;
        overflow: scroll;
    }

    #chatContainer {

        padding: 10px;
        border-radius: 10px;
        border: #0a53be solid;
    }

    .span-time-chat {
        color: #25cff2;;
    }

    .userMe {
        color: red;
    }

    .userYou {
        color: yellow;
    }


    /*input mess css*/
    .Message {
        width: 100%;
        height: 60px;
        border-radius: 10px;
        border: #40414f solid;
        background-color: white;
        transform: translate(0px, 0px);
        box-shadow: 5px 5px #34343f;
    }

    .MsgInput {
        font-size: 18px;
        border-radius: 5px;
        background-color: white;
        border: none;
        outline: none;
        width: 87%;
        height: 50px;
        transform: translate(0px, 0px);

        padding: 10px;
        font-weight: bold;
    }

    .SendSVG {
        width: 30px;
        height: 35px;
        border-width: 50px;
        transform: translate(20px, 5px);
        background-size: 10px;
        border-radius: 10px;
        transition: 0.3s;
        background-color: #8fda2d;
    }

    .SendSVG:hover {
        background-color: #2b2b35;
    }

    .l {
        position: absolute;
        width: 2px;
        height: 54px;
        background-color: #2e2f38;
        transform: translate(-20px, 2px);
    }


</style>


<div class="container mt-5 mb-5">
    <div class="row">
        <h1 class="text-center">Chat với nhân viên tư vấn</h1>
    </div>
    <div class="row">

        <div id="chatContainer" class="col-10 offset-1">
            <div id="chatLog"></div>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-10 offset-1">
            <div class="Message">
                <input id="messageArea" title="Write Message" tabindex="i" pattern="\d+" placeholder="Message.."
                       class="MsgInput"
                       type="text">


                <svg xmlns="http://www.w3.org/2000/svg" version="1.0" width="30.000000pt" height="30.000000pt"
                     viewBox="0 0 30.000000 30.000000" preserveAspectRatio="xMidYMid meet" class="SendSVG">
                    <g transform="translate(0.000000,30.000000) scale(0.100000,-0.100000)" fill="#ffffff70"
                       stroke="none">
                        <path onclick="send()"
                              d="M44 256 c-3 -8 -4 -29 -2 -48 3 -31 5 -33 56 -42 28 -5 52 -13 52 -16 0 -3 -24 -11 -52 -16 -52 -9 -53 -9 -56 -48 -2 -21 1 -43 6 -48 10 -10 232 97 232 112 0 7 -211 120 -224 120 -4 0 -9 -6 -12 -14z"></path>
                    </g>
                </svg>

                <span class="l"></span>

            </div>
        </div>

    </div>

    <%--    <div class="row">--%>
    <%--&lt;%&ndash;        <textarea name="" id="messageArea" cols="30" rows="10"></textarea>&ndash;%&gt;--%>
    <%--        <br>--%>
    <%--        <button onclick="send()">Gửi</button>--%>
    <%--        <button onclick="toii()">Click</button>--%>

    <%--    </div>--%>

</div>


<script>
    var chatLog = document.querySelector("#chatLog");
    var server = new WebSocket('ws://' + window.location.host + '/VapeShop_war_exploded/chatAll/0');
    var username = '${sessionScope.user.userName}';
    var otherJoined = false;

    var disconnect;
    var messageArea = document.querySelector("#messageArea");
    server.binaryType = 'arraybuffer';


    function inforMessage(infor) {
        var timeSend = document.createElement("span");
        timeSend.setAttribute("class", "span-time-chat")
        var newElement = document.createElement("h4");
        timeSend.innerHTML = "" + (new Date()).toLocaleString();
        newElement.appendChild(timeSend);
        newElement.innerHTML += ": " + infor;
        chatLog.appendChild(newElement);

    }

    server.onopen = function () {
        var infor = "Đã kết nối tới server " + window.location.host + " " + window.location.hostname;
        inforMessage(infor);
    }
    server.onclose = function (event) {
        if (event.data instanceof ArrayBuffer) {
            var message = JSON.parse(String.fromCharCode.apply(null, new Uint8Array(event.data)));
            console.log(message);

            // objectMessage(message);
            inforMessage(message.user + " :" + message.content);


        } else {
            var infor = "Đóng kết nối server";
            inforMessage(infor);
        }

    }
    server.onmessage = function (event) {
        if (event.data instanceof ArrayBuffer) {
            var message = JSON.parse(String.fromCharCode.apply(null, new Uint8Array(event.data)));
            console.log(message);

            // objectMessage(message);
            inforMessage(message.user + " :" + message.content);
            if (message.type == 'JOINED') {
                otherJoined = true;
                if (username != message.user)
                    infoMessage('You are now chatting with ' +
                        message.user + '.');
            }
        }

    }

    var objectMessage = function (message) {

        var date = message.timestamp == null ? '' :
            moment.unix(message.timestamp).format('h:mm:ss a');
        // chèn thẻ
        var timeSend = document.createElement("span");
        var newElement = document.createElement("h4");
        if (message.user != null) {
            if (message.user == username) {
                newElement.setAttribute("class", "userMe")
            } else {
                testuserYou.setAttribute("class", "userYou");
            }
        }
        timeSend.innerHTML = "" + date;
        newElement.appendChild(timeSend);


        var infor = "(" + message.user + ") " + message.content;
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
        } else if (messageArea.value.trim().length > 0) {
            var message = {
                timestamp: new Date(), type: 'TEXT', user: username,
                content: messageArea.value.trim()
            };
            console.log(message);
            try {
                var json = JSON.stringify(message);
                var length = json.length;
                var buffer = new ArrayBuffer(length);
                var array = new Uint8Array(buffer);
                for (var i = 0; i < length; i++) {
                    array[i] = json.charCodeAt(i);
                }

                server.send(buffer);
                messageArea.value = '';
            } catch (error) {
                var infor = "Lỗi khi gửi tin nhắn vui lòng thử lại sau";
                inforMessage(infor);
            }
        }
    }

    disconnect = function () {
        if (server != null) {
            inforMessage("Kết thúc");
            server.close();
            server = null;

        }
    }

    // test
    function toii() {
        console.log(messageArea.value.trim());
        messageArea.value = '';
        var info = "Đã kết nối tới server";
        inforMessage(info + " " + server == null);
        var testuserMe = document.createElement("h4");
        testuserMe.innerHTML = "Đây chỉ là test";
        testuserMe.setAttribute("class", "userMe")

        var testuserYou = document.createElement("h4");
        testuserYou.innerHTML = "Đây chỉ là test";
        testuserYou.setAttribute("class", "userYou");

        chatLog.appendChild(testuserMe);
        chatLog.appendChild(testuserYou)
    }


</script>
<%@include file="include/header-footer/footer.jsp" %>
