package org.tj.game.res;

import com.badlogic.gdx.assets.AssetManager;

/**
 * 资源数据
 */
public interface Res {


    AssetManager assetManager = new AssetManager();


    //图片

    /**
     * 图片根路径
     */
    String IMAGE_ROOT_PATH = "image/";

    /**
     * 音频根路径
     */
    String MUSIC_ROOT_PATH = "music/";

    /**
     * 背景图片路径
     */
    String BK_PATH = IMAGE_ROOT_PATH + "fight/bk1.jpg";

    /**
     * 向日葵动画
     */
    String[] SUNFLOWER_PATH = {IMAGE_ROOT_PATH + "plant/sunflower/p_1_01.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_02.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_03.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_04.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_05.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_06.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_07.png", IMAGE_ROOT_PATH + "plant/sunflower/p_1_08.png"};
    /**
     * 豌豆射手动画
     */
    String[] PEASE_PATH = {IMAGE_ROOT_PATH + "plant/pease/p_2_01.png", IMAGE_ROOT_PATH + "plant/pease/p_2_02.png", IMAGE_ROOT_PATH + "plant/pease/p_2_03.png", IMAGE_ROOT_PATH + "plant/pease/p_2_04.png", IMAGE_ROOT_PATH + "plant/pease/p_2_05.png", IMAGE_ROOT_PATH + "plant/pease/p_2_06.png", IMAGE_ROOT_PATH + "plant/pease/p_2_07.png", IMAGE_ROOT_PATH + "plant/pease/p_2_08.png"};

    /**
     * 已选的植物图片背景路径
     */
    String CHOSE_PATH = IMAGE_ROOT_PATH + "fight/chose/fight_chose.png";

    /**
     * 豌豆子弹的路径
     */
    String BULLET_PATH = IMAGE_ROOT_PATH + "fight/bullet.png";

    /**
     * 移动僵尸图片资源
     */
    String[] CORPSE_WALK_PASH = {IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_06.png", IMAGE_ROOT_PATH + "zombies/zombies_1/walk/z_1_07.png"};
    /**
     * 有头僵尸攻击图片资源
     */
    String[] CORPSE_HEAD_ATTACK = {IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_06.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_07.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_08.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_09.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack/z_1_attack_10.png"};

    /**
     * 僵尸头掉下来的动画
     */
    String[] CORPSE_HEAD_DOWN = {IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_06.png"};
    //String[] CORPSE_HEAD_DOWN = {IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/head/z_1_head_04.png"};

    /**
     * 无头移动的僵尸
     */
    String[] CORPSE_LOST_HEAD_WALK = {IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_06.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_07.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_08.png", IMAGE_ROOT_PATH + "zombies/zombies_1/work_losthead/z_1_losthead_09.png"};
    /**
     * 无头攻击的僵尸
     */
    String[] CORPSE_LOST_HEAD_ATTACK = {IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_06.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_07.png", IMAGE_ROOT_PATH + "zombies/zombies_1/attack_losthead/z_1_attack_losthead_08.png"};
    /**
     * 僵尸死去
     */
    String[] CORPSE_DIE = {IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_01.png", IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_02.png", IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_03.png", IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_04.png", IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_05.png", IMAGE_ROOT_PATH + "zombies/zombies_1/die/z_1_die_06.png"};
    /**
     * 向日葵选择
     */
    String FLOWER_CHOSE = IMAGE_ROOT_PATH + "Cards/card_sunflower.png";
  /**
     * 向日葵选择
     */
    String PEASE_CHOSE = IMAGE_ROOT_PATH + "Cards/card_peashooter.png";


    //音乐

    /**
     * 背景音乐
     */
    String BGM = MUSIC_ROOT_PATH + "/bg2.MP3";

    /**
     * 种植物
     */
    String ADDPLANT = MUSIC_ROOT_PATH + "/addplant.mp3";
    /**
     * 僵尸吼叫
     */
    String CORPSEBELLOW = MUSIC_ROOT_PATH + "/corpsebellow.mp3";

    /**
     * 添加子弹
     */
    String ADDBULLET = MUSIC_ROOT_PATH + "/bullet.mp3";


    /**
     * 子弹击中僵尸
     */
    String ATTACHCORPSE = MUSIC_ROOT_PATH + "/attachcorpse.mp3";


    /**
     * 吃植物的声音
     */
    String EATPLANT = MUSIC_ROOT_PATH + "/eatplant.mp3";

}
