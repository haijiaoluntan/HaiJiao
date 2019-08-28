$(function() {

    //$("#inner-App-Nav").css({ "display": "none" });

    var headers = $("section > ul > li");
    var bodys = $("section > div");

    headers.each(function(index, element) {
        $(this).on("click", function() {
            headers.each(function() {
                $(this).removeClass("active-header");
            });
            $(this).addClass("active-header");

            bodys.each(function() {
                $(this).css("display", "none");
            });
            bodys.eq(index).css("display", "block");
        });
    });

});

var suffix = ['@163.com', '@qq.com', '@gmail.com', '@126.com'];

function autoCompleteEmail(parent_class, child_ul_id, email_input_id) {
    $('#' + child_ul_id).html('');
    var prefix = $('#' + email_input_id).val();
    var li = '';
    if (prefix == '' || prefix.indexOf('@') != -1) {
        $('#' + child_ul_id).html('');
    } else {
        for (var i = 0; i < suffix.length; i++) {
            li += '<li>' + prefix + suffix[i] + '</li>';
        }
        $('#' + child_ul_id).html(li);
        var liArr = $('.' + parent_class + '>ul>li');
        for (var i = 0; i < liArr.length; i++) {
            (function(i) {
                liArr[i].onclick = function() {
                    $('#' + email_input_id).val(prefix + suffix[i]);
                    $('#' + child_ul_id).html('');
                };
            })(i);
        }
    }
}