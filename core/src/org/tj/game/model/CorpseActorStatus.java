package org.tj.game.model;

import lombok.AllArgsConstructor;

/**
 * 僵尸状态枚举类
 */
@AllArgsConstructor
public enum CorpseActorStatus {
    WALK, EAT, WALK_TO_HEADDOWN, EAT_TO_HEADDOWN, LOSTHEADWALK, LOSTHEADEAT, DIE;
}
