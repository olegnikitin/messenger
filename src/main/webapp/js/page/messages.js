var addMessageModal = $("#message-add-modal");
var messageInput = $("#message-input");

$("#message-add-btn").click(function () {
    addMessageModal.modal();
});

$("#send-message-btn").click(function () {
    var messageText = messageText.val();
    if(messageText !== "") {
        $.post("/messages", {
            text: messageText
        });
    }
});