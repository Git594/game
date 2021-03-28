package com.etm.racc.map.prop;

public class QACard extends Card {

    private final String answer;

    public QACard(Integer number, String title, String answer) {
        super(number, title);
        this.answer = answer;
    }

    /**
     * 检查是否正确
     * @param answer 答案
     * @return 是否正确
     */
    public boolean checkAnswer(String answer) {
        return this.answer.equals(answer);
    }

    @Override
    public String toString() {
        return super.toString() + ", answer: " + this.answer;
    }
}
