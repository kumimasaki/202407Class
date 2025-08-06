package practice.ex3;

public class BlankQuiz extends Quiz {
    private int blankCount;

    public BlankQuiz(String main, int blankCount) {
        super(main);
        this.blankCount = blankCount;
    }

    @Override
    public void displayHeader() {
        System.out.println("「次の文の空欄を埋めなさい。」");
    }

    @Override
    public void displayMain() {
        super.displayMain();
        for (int i = 0; i < blankCount; i++) {
            System.out.println((i + 1) + ". ______________ ");
        }
    }
}