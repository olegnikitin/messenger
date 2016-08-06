<!DOCTYPE html>
<html>
<head>
    <title>Please enter your name</title>
</head>
<body>

Please enter your name<br/>
<div id="error" style="display: none; color: red">Please enter your name</div>
<input type="text" id="name"/>
<input type="button" id="send-name-btn" value="Send"/>

<script src="/js/jquery-3.1.0.min.js"></script>
<script type="application/javascript">
    $("#send-name-btn").click(function () {
        $.post("/auth", {
            userName: $("#name").val()
        }).done(function () {
            document.location = '/'
        }).fail(function () {
            $("#error").show();
        });
    });
</script>
</body>
</html>
