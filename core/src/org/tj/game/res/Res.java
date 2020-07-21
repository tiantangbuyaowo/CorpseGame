package org.tj.game.res;

import com.badlogic.gdx.assets.AssetManager;

/**
 * 资源数据
 */
public interface Res {


    AssetManager assetManager = new AssetManager();
    /**
     * 图片根路径
     */
    String ROOT_PATH = "image/";

    /**
     * 背景图片路径
     */
    String BK_PATH = ROOT_PATH + "fight/bk1.jpg";

    /**
     * 向日葵动画
     */
    String[] SUNFLOWER_PATH = {ROOT_PATH + "plant/sunflower/p_1_01.png", ROOT_PATH + "plant/sunflower/p_1_02.png", ROOT_PATH + "plant/sunflower/p_1_03.png", ROOT_PATH + "plant/sunflower/p_1_04.png", ROOT_PATH + "plant/sunflower/p_1_05.png", ROOT_PATH + "plant/sunflower/p_1_06.png", ROOT_PATH + "plant/sunflower/p_1_07.png", ROOT_PATH + "plant/sunflower/p_1_08.png"};
    /**
     * 豌豆射手动画
     */
    String[] PEASE_PATH = {ROOT_PATH + "plant/pease/p_2_01.png", ROOT_PATH + "plant/pease/p_2_02.png", ROOT_PATH + "plant/pease/p_2_03.png", ROOT_PATH + "plant/pease/p_2_04.png", ROOT_PATH + "plant/pease/p_2_05.png", ROOT_PATH + "plant/pease/p_2_06.png", ROOT_PATH + "plant/pease/p_2_07.png", ROOT_PATH + "plant/pease/p_2_08.png"};

    /**
     * 已选的植物图片背景路径
     */
    String CHOSE_PATH = ROOT_PATH + "fight/chose/fight_chose.png";

    /**
     * 豌豆子弹的路径
     */
    String BULLET_PATH = ROOT_PATH + "fight/bullet.png";

    /**
     * 移动僵尸图片资源
     */
    String[] CORPSE_WALK_PASH = {ROOT_PATH + "zombies/zombies_1/walk/z_1_01.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_02.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_03.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_04.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_05.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_06.png", ROOT_PATH + "zombies/zombies_1/walk/z_1_07.png"};
 /**
     * 有头僵尸攻击图片资源
     */
    String[] CORPSE_HEAD_ATTACK_PASH = {ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_01.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_02.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_03.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_04.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_05.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_06.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_07.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_08.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_09.png", ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_10.png"};


}
