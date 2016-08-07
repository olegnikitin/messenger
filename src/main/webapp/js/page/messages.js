var addMessageModal = $("#message-add-modal");
var messageInput = $("#message-input");

function messageRow(message) {
    return '<tr><td>' + message.text + '</td>' +
        '<td>' + message.sender.name + '</td>' +
        '<td><input type="button" class="btn btn-warning" value="Edit"/>' +
        '<input type="button" class="btn btn-danger" value="Delete"/></td></tr>';
}

$("#message-add-btn").click(function () {
    addMessageModal.modal();
});

$.get("/messages", function (data) {
    data.forEach(function (message) {
        $('#messages-table').append(messageRow(message));
    })
});

$("#send-message-btn").click(function () {
    var messageText = messageInput.val();
    if(messageText !== "") {
        $.post("/messages", {
            text: messageText
        }).done(function (data) {
            $('#messages-table').append(messageRow(data));
            addMessageModal.modal('hide')
        }).fail(function () {
            alert("Something is bad!")
        })
    } else {
        alert("You have to enter message")
    }
});