<html>
<head></head>
<body>
<script src="${request.contextPath}/jquery-1.11.3.min.js"></script>
aaaaaaaaaaa
<div id="htmlout"></div>
dddddddddddddddddddd
</body>

<script>
    $.ajax({
        type: "post",
        url: "hello",
        dataType: "html",
        success: function (text) {   //将已得到数据的模板传回来
            // data 可以是 xmlDoc, jsonObj, html, text, 等等.
            //this; // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this
            alert(text);

            $("#htmlout").append(text);

        }
    });
</script>
</html>