(function($) {
    $("#page-size-select a").on("click", function(e) {
        e.preventDefault();

        $("#page-size").val($(this).data('value'));
        $("#page-size").closest('form').submit();
    });

    $("#page-select a").on("click", function(e) {
        e.preventDefault();
        if ($(this).closest('li').hasClass('disabled')) {
            return;
        }
        if ($(this).closest('li').hasClass('active')) {
            return;
        }


        $("#page").val($(this).data('value'));
        $("#page").closest('form').submit();
    });
})(jQuery);
