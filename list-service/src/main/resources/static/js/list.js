$(".board1 th input[type=checkbox]").on("click", function() {
    var checked = $(this).prop("checked");
    $(this).closest("thead").siblings("tbody").find("td input[type=checkbox]").each(function() {
        $(this).prop("checked", checked);
    })
})