<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/29/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>

<!--
=========================================================
* Soft UI Dashboard - v1.0.7
=========================================================

* Product Page: https://www.creative-tim.com/product/soft-ui-dashboard
* Copyright 2023 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="include/header-product-management-dashboard.jsp" %>
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
    border:  #40414f solid;
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
<main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
  <!-- Navbar -->
  <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur"
       navbar-scroll="true">
    <div class="container-fluid py-1 px-3">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
          <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Dashboard</a>
          </li>
          <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="product-management">Quản lí
            sản phẩm</a>
          </li>

          <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Thêm sản phẩm mới</li>
        </ol>
        <h6 class="font-weight-bolder mb-0">Quản lí sản phẩm</h6>
      </nav>
      <div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4" id="navbar">
        <div class="ms-md-auto pe-md-3 d-flex align-items-center">
          <div class="input-group">
            <span class="input-group-text text-body"><i class="fas fa-search" aria-hidden="true"></i></span>
            <input type="text" class="form-control" placeholder="Type here...">
          </div>
        </div>
        <ul class="navbar-nav  justify-content-end">

          <li class="nav-item d-flex align-items-center">
            <a href="javascript:;" class="nav-link text-body font-weight-bold px-0">
              <i class="fa fa-user me-sm-1"></i>
              <span class="d-sm-inline d-none">Sign In</span>
            </a>
          </li>
          <li class="nav-item d-xl-none ps-3 d-flex align-items-center">
            <a href="javascript:;" class="nav-link text-body p-0" id="iconNavbarSidenav">
              <div class="sidenav-toggler-inner">
                <i class="sidenav-toggler-line"></i>
                <i class="sidenav-toggler-line"></i>
                <i class="sidenav-toggler-line"></i>
              </div>
            </a>
          </li>
          <li class="nav-item px-3 d-flex align-items-center">
            <a href="javascript:;" class="nav-link text-body p-0">
              <i class="fa fa-cog fixed-plugin-button-nav cursor-pointer"></i>
            </a>
          </li>
          <li class="nav-item dropdown pe-2 d-flex align-items-center">
            <a href="javascript:;" class="nav-link text-body p-0" id="dropdownMenuButton"
               data-bs-toggle="dropdown" aria-expanded="false">
              <i class="fa fa-bell cursor-pointer"></i>
            </a>
            <ul class="dropdown-menu  dropdown-menu-end  px-2 py-3 me-sm-n4"
                aria-labelledby="dropdownMenuButton">
              <li class="mb-2">
                <a class="dropdown-item border-radius-md" href="javascript:;">
                  <div class="d-flex py-1">
                    <div class="my-auto">
                      <img src="assets/img/team-2.jpg" class="avatar avatar-sm  me-3 ">
                    </div>
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="text-sm font-weight-normal mb-1">
                        <span class="font-weight-bold">New message</span> from Laur
                      </h6>
                      <p class="text-xs text-secondary mb-0 ">
                        <i class="fa fa-clock me-1"></i>
                        13 minutes ago
                      </p>
                    </div>
                  </div>
                </a>
              </li>
              <li class="mb-2">
                <a class="dropdown-item border-radius-md" href="javascript:;">
                  <div class="d-flex py-1">
                    <div class="my-auto">
                      <img src="assets/img/small-logos/logo-spotify.svg"
                           class="avatar avatar-sm bg-gradient-dark  me-3 ">
                    </div>
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="text-sm font-weight-normal mb-1">
                        <span class="font-weight-bold">New album</span> by Travis Scott
                      </h6>
                      <p class="text-xs text-secondary mb-0 ">
                        <i class="fa fa-clock me-1"></i>
                        1 day
                      </p>
                    </div>
                  </div>
                </a>
              </li>
              <li>
                <a class="dropdown-item border-radius-md" href="javascript:;">
                  <div class="d-flex py-1">
                    <div class="avatar avatar-sm bg-gradient-secondary  me-3  my-auto">
                      <svg width="12px" height="12px" viewBox="0 0 43 36" version="1.1"
                           xmlns="http://www.w3.org/2000/svg"
                      >
                        <title>credit-card</title>
                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                          <g transform="translate(-2169.000000, -745.000000)" fill="#FFFFFF"
                             fill-rule="nonzero">
                            <g transform="translate(1716.000000, 291.000000)">
                              <g transform="translate(453.000000, 454.000000)">
                                <path class="color-background"
                                      d="M43,10.7482083 L43,3.58333333 C43,1.60354167 41.3964583,0 39.4166667,0 L3.58333333,0 C1.60354167,0 0,1.60354167 0,3.58333333 L0,10.7482083 L43,10.7482083 Z"
                                      opacity="0.593633743"></path>
                                <path class="color-background"
                                      d="M0,16.125 L0,32.25 C0,34.2297917 1.60354167,35.8333333 3.58333333,35.8333333 L39.4166667,35.8333333 C41.3964583,35.8333333 43,34.2297917 43,32.25 L43,16.125 L0,16.125 Z M19.7083333,26.875 L7.16666667,26.875 L7.16666667,23.2916667 L19.7083333,23.2916667 L19.7083333,26.875 Z M35.8333333,26.875 L28.6666667,26.875 L28.6666667,23.2916667 L35.8333333,23.2916667 L35.8333333,26.875 Z"></path>
                              </g>
                            </g>
                          </g>
                        </g>
                      </svg>
                    </div>
                    <div class="d-flex flex-column justify-content-center">
                      <h6 class="text-sm font-weight-normal mb-1">
                        Payment successfully completed
                      </h6>
                      <p class="text-xs text-secondary mb-0 ">
                        <i class="fa fa-clock me-1"></i>
                        2 days
                      </p>
                    </div>
                  </div>
                </a>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <!-- End Navbar -->
  <div class="container-fluid py-4">
    <div class="row">
      <div class="col-12">
        <div class="card mb-4">
          <div class="card-header pb-0">
            <h4 class="text-center">Chat với khách hàng</h4>
          </div>
          <div class="card-body px-0 pt-0 pb-2">


            <div class="container mt-5 mb-5">

              <div class="row">

                <div id="chatContainer" class="col-10 offset-1">
                  <div id="chatLog"></div>
                </div>
              </div>
              <div class="row mt-5">
                <div class="col-10 offset-1">
                  <div class="Message">
                    <input id="messageArea" title="Write Message" tabindex="i" pattern="\d+" placeholder="Message.." class="MsgInput"
                           type="text">


                    <svg xmlns="http://www.w3.org/2000/svg" version="1.0" width="30.000000pt" height="30.000000pt"
                         viewBox="0 0 30.000000 30.000000" preserveAspectRatio="xMidYMid meet" class="SendSVG">
                      <g transform="translate(0.000000,30.000000) scale(0.100000,-0.100000)" fill="#ffffff70"
                         stroke="none">
                        <path onclick="send()" d="M44 256 c-3 -8 -4 -29 -2 -48 3 -31 5 -33 56 -42 28 -5 52 -13 52 -16 0 -3 -24 -11 -52 -16 -52 -9 -53 -9 -56 -48 -2 -21 1 -43 6 -48 10 -10 232 97 232 112 0 7 -211 120 -224 120 -4 0 -9 -6 -12 -14z"></path>
                      </g>
                    </svg>

                    <span class="l"></span>

                  </div>
                </div>

              </div>

<%--              <div class="row">--%>
<%--                &lt;%&ndash;        <textarea name="" id="messageArea" cols="30" rows="10"></textarea>&ndash;%&gt;--%>
<%--                <br>--%>
<%--                <button onclick="send()">Gửi</button>--%>
<%--                <button onclick="toii()">Click</button>--%>

<%--              </div>--%>

            </div>

            <div class="mx-5 mb-2">
              <a href="product-management"><i class="fa-solid fa-arrow-left-long fa-2xl"
                                              style="color: #2e2bd4;"></i> Quay lại quản lí sản phẩm</a>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
  <script>
    var chatLog = document.querySelector("#chatLog");
    var server = new WebSocket('ws://'+window.location.host+'/VapeShop_war_exploded/chatAll/${sessionId}');
    var username = '${sessionScope.user.userName}';
    var otherJoined = false;

    var disconnect;
    var messageArea = document.querySelector("#messageArea");
    server.binaryType = 'arraybuffer';


    function inforMessage(infor) {
      var timeSend = document.createElement("span");
      timeSend.setAttribute("class","span-time-chat")
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
      inforMessage(info);
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
  <%@include file="include/footer-dashboard.jsp" %>


