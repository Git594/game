package com.etm.bftb.map.prop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.etm.bftb.constant.Prop;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CardFactory {

    /**
     * 创建卡片
     * @param type 类型，0为动物卡，1为问答卡
     * @return 卡片实例
     */
    public Card createCard(int type, int number) throws IOException {
        if (type == 0) {
            return createAnimalCard(number);
        } else {
            return createQACard(number);
        }
    }

    /**
     * 创建问答卡
     * @param number 编号
     * @return 问答卡实体类
     * @throws IOException 文件未找到异常
     */
    public QACard createQACard(int number) throws IOException {
        String qaStr;
        try {
            qaStr = FileUtils.readFileToString(new File(Prop.Q_A_FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException("File QACard.json not found!");
        }
        JSONArray qaList = JSONArray.parseArray(qaStr);
        if (number < qaList.size()) {
            JSONObject qa = qaList.getJSONObject(number);
            String q = qa.getString(Prop.Q_A_FILE_QUESTION);
            String a = qa.getString(Prop.Q_A_FILE_ANSWER);
            return new QACard(number, q, a);
        } else {
            throw new RuntimeException("create q a card error!");
        }
    }

    public EndangeredAnimalCard createAnimalCard(int number) {
        if (number < Prop.ENDANGERED_CARD_COUNT) {
            return new EndangeredAnimalCard(number, Prop.ENDANGERED_ANIMAL_CARDS.get(number));
        } else {
            throw new RuntimeException("create endangered animal card error!");
        }
    }

}
