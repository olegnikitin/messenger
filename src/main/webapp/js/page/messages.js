var addMessageModal = $("#message-add-modal");
var updateMessageModal = $("#message-update-modal");
var messageInput = $("#message-input");
var messageUpdateInput = $("#message-input-update");

var iDMessageToUpdate = null;
var textMessageToUpdateBlock = null;

function messageRow(message) {
    return '<tr><td>' + message.text + '</td>' +
        '<td>' + message.sender.name + '</td>' +
        '<td><input type="button" class="btn btn-warning" data-id="' + message.id + '" value="Edit"/>' +
        '<input type="button" class="btn btn-danger" data-id="' + message.id + '" value="Delete"/></td></tr>';
}

$("#message-add-btn").click(function () {
    addMessageModal.modal();
});

$("#logout-btn").click(function () {
    $.post("/logout").done(function () {
        document.location = '/'
    })
});

$(document).on("click", ".btn-warning", function () {
    iDMessageToUpdate = $(this).data('id');
    textMessageToUpdateBlock = $(this.parentElement.parentElement.firstChild);
    messageUpdateInput.val(textMessageToUpdateBlock.html());
    updateMessageModal.modal();
});

$.get("/messages", function (data) {
    data.forEach(function (message) {
        $('#messages-table').append(messageRow(message));
    })
});

$("#send-message-btn").click(function () {
    var messageText = messageInput.val();
    if (messageText !== "") {
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

$("#update-message-btn").click(function () {
    $.ajax({
        url: "/messages/" + iDMessageToUpdate,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            'text': messageUpdateInput.val()
        })
    }).done(function (message) {
        textMessageToUpdateBlock.html(message.text);
        updateMessageModal.modal('hide')
    }).fail(function () {
        alert("Something is bad!")
    })
});

$(document).on("click", ".btn-danger", function () {
    var self = this;
    $.ajax({
        url: "/messages/" + $(self).data('id'),
        method: 'DELETE'
    }).done(function () {
        self.parentElement.parentElement.remove()
    }).fail(function () {
        alert("Something is bad!")
    })
});