<!DOCTYPE html>
<html>
<head>
    <title>Please enter your name</title>
</head>
<body>

<div id="name-label">Please enter your name</div>
<input type="text" id="name"/>
<input type="button" id="send-name-btn" value="Send"/>
<select id="storage-type">
    <option selected="selected">Database</option>
    <option>Memory</option>
</select>

<script src="/js/jquery-3.1.0.min.js"></script>
<script type="application/javascript">
    $("#send-name-btn").click(function () {
        $.ajax({
            url: "/auth",
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                name: $("#name").val(),
                type: $("#storage-type option:selected").text().toUpperCase()
            })
        }).done(function () {
            document.location = '/'
        }).fail(function () {
            $("#name-label").css("color", "red")
        });
    });
</script>
</body>
</html>
