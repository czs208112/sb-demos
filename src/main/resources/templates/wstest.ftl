<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>测试webSocket</title>
</head>
<body>
<div>消息</div>
<div id="message"></div>
<div>
    <input id="msg">
    <button onclick="sendMsg()">发送消息</button>
</div>
</body>
<script src="${request.contextPath}/jquery-1.11.3.min.js"></script>
<script src="${request.contextPath}/jquery-1.11.3.min.js"></script>
<script src="${request.contextPath}/sockjs.min.js"></script>
<script>
    var webSocket = null;
    $(function () {
        sendMsg();
    });

    function sendMsg() {
        webSocket = new SockJS("/websocket/demo");
        webSocket.onopen = function () {
            webSocket.send();
        };
        webSocket.onmessage = function (e) {
            if (e.data) {
                var data = e.data;
                $("#message").append(data + "<br>");
            }

        };
        webSocket.onclose = function () {
            console.log('close run status socket');
        };

        webSocket.onerror = function () {
            console.error("链接出现异常，请检查服务器是否正常运行");
        };
    }
</script>
</html>