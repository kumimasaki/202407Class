$(function(){

    // $("#text").animate({
    //     // フォントのサイズを変更
    //     "fontSize" : "128px"
    // }, 2000);

    $("#out").fadeOut(3000);
    $("#in").fadeIn(3000);

    $("#btn").on("click", () => {
        // $("#menu").hide();
        // 表示非表示
        $("#menu").toggle();
    });

});