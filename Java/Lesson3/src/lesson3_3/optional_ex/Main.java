package lesson3_3.optional_ex;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		String name = null;
		Optional<String> optinalName = Optional.ofNullable(name);
		if (optinalName.isPresent()) {
			System.out.println(optinalName.get().length());
			/*
			 * String name = "Hello";: 変数nameを宣言し、文字列 "Hello" を代入しています。
			 *
			 * Optional<String> optinalName = Optional.ofNullable(name); :
			 * Optional.ofNullable()メソッドを使用して、nameの値を含むOptionalオブジェクトoptionalNameを作成しています。
			 * ofNullable()メソッドは、渡された値がnullでない場合はその値を含むOptionalオブジェクトを作成し、
			 * nullの場合は空のOptionalオブジェクトを作成します。
			 *
			 * if(optionalName.isPresent()) {: optionalNameが値を含んでいるかどうかを確認しています。
			 * isPresent()メソッドは、Optionalが値を持っている場合にtrueを返します。
			 *
			 * System.out.println(optinalName.get().length());:
			 * もしoptionalNameが値を持っている場合、その値の文字列の長さを取得し、
			 * それをコンソールに出力しています。get()メソッドは、Optionalが値を持っている場合にその値を取得します。
			 *
			 * このコードの目的は、nameがnullでない場合にその文字列の長さを出力することです。もしnameがnullであれば、
			 * NullPointerExceptionを避けるためにOptionalを使用しています。
			 */
		} else {
			System.out.println(optinalName.orElse("Unknown"));
		}

		// orElse(T other): Optionalが値を持っている場合はその値を返し、持っていない場合は引数として指定した値を返します。

	}

}
