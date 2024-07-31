// 配列の初期化
let arr = [1, 2, 3, "Alice", 12.5];
// 中身の確認
console.log(arr);

// 配列に値を追加
arr.push("追加しました");
console.log(arr);
console.log(arr.length);
// 配列の一番最後のデータを削除
arr.pop();
console.log(arr);

// 配列の作成
let arr2 = new Array(5);
arr2[0] = 12;
arr2[1] = "hello";
console.log(arr2);

// オブジェクトの書き方
let obj = {name:"Alice", id:122, isStudent:true};
console.log(obj);
// 特定のデータの表示の仕方
console.log(obj.name);
console.log(obj["name"]);
// 値の上書きの仕方
obj.id = 30;
console.log(obj.id);

obj["isStudent"] = false;
console.log(obj["isStudent"]);
console.log(obj.isStudent);

// for-of
for(let key of arr){
    console.log(key);
}

// for-in
for(let key in obj){
    console.log(key + "：" + obj[key]);
}