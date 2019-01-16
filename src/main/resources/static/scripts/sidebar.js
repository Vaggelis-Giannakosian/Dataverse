$(".sidebar .nav li a ").each(function () {
    var link= $(this).attr("href")
    if(link===window.location.pathname){

        $(this).addClass("active");
    }


})



