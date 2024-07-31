// 要素を取得
let list = document.getElementById("list");

// 新しい要素の作成
let newLink = document.createElement("a");
// 内容を挿入
newLink.innerHTML = "developer.mozilla.org";
// 最後挿入
list.append(newLink);
// 新しいliを作成
let item = document.createElement("li");
list.append(item);
item.append(newLink);

// 削除したい要素を取得
let removeLink = document.getElementById("link-2");
// 要素の削除
// removeLink.remove();
// 子から見た親を消す
removeLink.parentNode.remove();