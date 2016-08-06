<!DOCTYPE html>
<html>
<head>
    <title>Message list</title>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/css/page/messages.css"/>
</head>
<body>
<header class="container-fluid">
    <h1>Messages</h1>
</header>
<div id="main" class="container-fluid">
    <table width="100%">
        <%--<thead></thead>--%>
        <tr>
            <td width="50%">Message text</td>
            <td width="20%">User name</td>
            <td width="30%">Actions</td>
        </tr>
        <tr>
            <td>Some text</td>
            <td>user1</td>
            <td>
                <input type="button" class="btn btn-warning" value="Edit"/>
                <input type="button" class="btn btn-danger" value="Delete"/>
            </td>
        </tr>
    </table>
    <input id="message-add-btn" type="button" class="btn btn-default center-block" value="Add new message"/>
</div>

<div id="message-add-modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">Add new message</h4>
            </div>
            <div class="modal-body">
                <input id="message-input" type="text" placeholder="Enter your message here"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="send-message-btn" type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>
<script src="/js/jquery-3.1.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/page/messages.js"></script>
</body>
</html>