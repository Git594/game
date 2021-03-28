package com.etm.racc;

import com.etm.racc.map.prop.EndangeredAnimalCard;
import com.etm.racc.map.prop.Prop;
import com.etm.racc.map.prop.QACard;
import org.junit.Test;

public class PropTest {

    @Test
    public void initPropTest() {
        Prop prop = Prop.getInstant();
        for (EndangeredAnimalCard item : prop.getAnimalCards()) {
            System.out.println(item);
        }
        for (QACard item : prop.getQaCards()) {
            System.out.println(item);
        }
    }

}
