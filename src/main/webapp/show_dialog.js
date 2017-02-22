
function init_dialogs() {

    if (Notification.permission =="granted") {
        delayd_show_dialog();
    } else {
        requestPermisions();
    }

    function requestPermisions() {
        if (Notification.permission !== 'denied' || Notification.permission === "default") {
            Notification.requestPermission().then(function(result) {
                delayd_show_dialog();
            });
        }
    }

    function utcDate() {
        var time = new Date();
        return time.getTime() + (time.getTimezoneOffset() * 60 * 1000)
    }

    function delayd_show_dialog() {
        setTimeout(show_dialog, 1000);

    }
    function show_dialog() {


        function send_answer(answer) {
            $.ajax({
                method: 'POST', contentType: "application/json",
                url: "answer",
                data: JSON.stringify({
                    "askedAt": state.startedAt,
                    "answeredAt": utcDate(),
                    "answer": answer
                }),
                error: function (error) {
                    console.log("error", answer, error);
                }
            });
        }

        state  = {
            "startedAt": utcDate()
        };



        var notification = new Notification(
            "Hi there!",
            {
                body: "is it flow?",
                data: {
                    "startedAt": utcDate()
                },
                requireInteraction: true
            }
        );


        notification.onclick = function(event) { }

        var yes_button = $("#yes");


        var no_button = $("#no");

        function button_click(event) {
            send_answer(event.target.id);
        }

        yes_button.click(button_click);
        no_button.click(button_click);
    }


}
