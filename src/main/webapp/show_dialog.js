
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

        function to_answer(startedAt, answer) {
            console.log("factory", startedAt, answer)
            return function () {
                $.ajax({
                    method: 'POST', contentType: "application/json",
                    url: "answer",
                    data: JSON.stringify({

                        "askedAt": startedAt,
                        "answeredAt": utcDate(),
                        "answer": answer
                    }),

                    success: function (data) {
                        console.log("data", startedAt, answer)
                    },
                    error: function (error) {
                        console.log("error", startedAt, answer)
                    }
                });
            };

        }

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



        notification.onclick = function(event) {
            var yes_button = $("#yes");
            var no_button = $("#no");

            yes_button.unbind('click');
            yes_button.click(to_answer(notification.data.startedAt, "yes"));

            no_button.unbind('click');
            no_button.click(to_answer(notification.data.startedAt, "no"));
            console.log("clicked");

        }

    }


}
