/**
 * Created by max on 03.03.15.
 */
$(document).ready(function() {
    var app = Sammy('#book-info', function () {
        this.get('#/', function(){
            console.log("You're in the Main route");
        });

        this.get('#/book/:bookId', function() {
            refreshBookInfoView(this.params['bookId']);
            $.ajax({
                type: 'POST',
                url: '/book/' + this.params['bookId']
            }).done(function(data) {
                $('#book-info').empty().append(data);
            })
        });
    });

    //app.run("#/");

    $(".clickable").click(function() {
        var link = $(this).attr("data-href");
        if (link) {
            window.document.location = link;
        }
    });
});

function refreshBookInfoView(bookId) {
    var bookInfo = $("#book-info-button");
    bookInfo.children('a.active').removeClass("active");
    bookInfo.children('a[href^="#/book/' + bookId + '"]').addClass("active");
}

/*$("#book-info-button").children("a").click(function(e) {
 e.preventDefault();*/