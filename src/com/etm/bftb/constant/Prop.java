package com.etm.bftb.constant;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public interface Prop {
    int ENDANGERED_CARD_COUNT = 8;
    List<String> ENDANGERED_ANIMAL_CARDS = Arrays.asList("苏门答腊犀牛", "西部灰鲸", "红狼", "西伯利亚虎",
            "黑脚貂", "菲律宾鳄", "山地大猩猩", "恒河鲨");
    String Q_A_FILE_NAME = "QACard.json";
    String Q_A_FILE_QUESTION = "question";
    String Q_A_FILE_ANSWER = "answer";
    int Q_A_CARD_COUNT = 15;
}
