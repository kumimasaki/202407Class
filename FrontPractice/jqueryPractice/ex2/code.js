$(function(){
    // <ol>の取得
    let list = $("#list");
    // 新しい<li>を作成
    let newLink = $("<li>");
    list.append(newLink);

    // 新しい<a>要素を追加
    let item = $("<a>");
    // 作成したaタグの中に文字を挿入
    item.html("developer.mozilla.org");
    // リストの末尾に追加
    newLink.append(item);

    // 要素の作成<p>
    let test = $("<p>");
    // <p>の内容を挿入：And more
    test.html("And more");
    // <ol>の外側に要素を追加
    list.after(test);

    // 要素の削除
    // list.remove();
    // 要素の中を空にする
    list.empty();

    // onClick
    // $("#button1").click(() => {
    //     console.log("ボタン１");
    // });

    // addEventListner
    $("#button1").on("click", () => {
        console.log("ボタン１");
        $("#text").css("color", "red");
    });
    $("#button1").on("click", () => {
        console.log("ボタン２");
    });

});