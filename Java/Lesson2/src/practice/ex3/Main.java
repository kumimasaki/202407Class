package practice.ex3;

public class Main {
    public static void main(String[] args) {
        Quiz q1 = new Quiz("最も面積の広い都道府県はどこですか？");
        String[] answers = { "青森県", "さくらんぼ", "みかん", "ぶどう" };
        Quiz q2 = new MultipleChoiceQuiz("赤色の果物はどれですか", answers);
        Quiz q3 = new BlankQuiz("(      )は(      )年に縦横無尽を設立した。", 2);

        QuizViewer.showQuiz(q1);
        QuizViewer.showQuiz(q2);
        QuizViewer.showQuiz(q3);
    }
}