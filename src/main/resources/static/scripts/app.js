(function($) {
    $("#page-size-select a").on("click", function(e) {
        e.preventDefault();

        $("#page-size").val($(this).data('value'));
        $("#page-size").closest('form').submit();
    });
})(jQuery);