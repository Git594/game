package com.etm.bftb.constant;

public interface Game {
    /**
     * 儿童梦
     */
    String OWNER = "ETM";

    /**
     * 游戏名称
     */
    String NAME = "RACC";

    /**
     * 初始声望值
     */
    int PRESTIGE = 3000;

    /**
     * 建立栖息地的声望值
     */
    int PRESTIGE_HABITAT_ESTABLISH = 800;

    /**
     * 进入栖息地上缴的声望值
     */
    int PRESTIGE_TURN_IN_HABITAT = 80;

    /**
     * 进入对应动物格增加的声望
     */
    int PRESTIGE_SAME_ANIMAL = 100;

    /**
     * 竞赛回答错误扣除的声望
     */
    int PRESTIGE_LOST_COMPETITION = 200;

    /**
     * 同意言论增加的声望值
     */
    int PRESTIGE_JOIN_MEETING = 100;

    /**
     * 遭遇偷猎者扣除的声望值
     */
    int PRESTIGE_MET_POACHER = 200;

    /**
     * 收容所初始声望值
     */
    int PRESTIGE_INIT_SHELTER = 200;

    /**
     * 进入其他玩家的收容所需要上缴的声望值
     */
    int PRESTIGE_ENTER_SHELTER = 40;

    /**
     * 维护收容所所需上缴的声望值
     */
    int PRESTIGE_SHELTER_MAINTENANCE = 50;

    /**
     * 维护栖息地所需上缴的声望值
     */
    int PRESTIGE_HABITAT_MAINTENANCE = 80;

}
