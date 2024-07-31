// メソッドの作成 戻り値なし 引数なし
function printHello(){
    console.log("Hello");
}
// メソッドの呼び出し
printHello();

// メソッドの作成 戻り値あり 引数あり
function sum(num1, num2){
    return num1 + num2;
}
// メソッドの呼び出し
console.log(sum(1, 2));

// デフォルトパラメータ
function print(str1, str2="世界", str3="!!!"){
    console.log(str1 + " " + str2 + " " + str3);
}
// メソッドの呼び出し
print("やっほー");
print("やっほー", "こんにちは");
print("やっほー", "こんにちは", "おやすみ");

// ラムダ式
let add = (x, y) => x + y;
console.log(add(2, 3));