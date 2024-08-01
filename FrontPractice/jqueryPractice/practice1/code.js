$(function () {

    const BASE_TEXT1 = "直近1つ目：";
    const BASE_TEXT2 = "直近2つ目：";

    let firstText = "";
    let secondText = "";

    // テキストを表示させるメソッド
    function printText(setFirstText) {
        // 2つめの値を1つめの値で上書き
        secondText = firstText;
        // 1つめのテキストの内容を最新の状態にする
        firstText = setFirstText;

        $(".one").html(BASE_TEXT1 + firstText);
        $(".two").html(BASE_TEXT2 + secondText);
    }

    // リンゴを押下したときの処理
    $("#btn1").on("click", () => {
        printText("リンゴ");
    });

    $("#btn2").on("click", () => {
        printText("バナナ");
    });

    $("#btn3").on("click", () => {
        printText("ミカン");
    });
});