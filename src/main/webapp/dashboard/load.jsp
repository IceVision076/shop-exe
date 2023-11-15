<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/8/2023
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="test()">Test</button>
</body>

<div id ="random">Xin chờ</div>
<script>
    setInterval(test, 10000);
    function test(){
        const xhr = new XMLHttpRequest();
        var random= document.getElementById("random");
        xhr.open("GET", "http://localhost:8111/VapeShop_war_exploded/load", true);

        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.send();

        xhr.onload = function() {
            if (xhr.status === 200) {
                const data = JSON.parse(xhr.responseText);
                console.log(data);
                random.innerHTML = data;
            } else {
                console.log("ERROR");
            }
        };
    }

</script>
</html>
