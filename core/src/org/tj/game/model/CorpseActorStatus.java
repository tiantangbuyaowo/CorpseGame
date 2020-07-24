package org.tj.game.model;

import lombok.AllArgsConstructor;

/**
 * 僵尸状态枚举类
 */
@AllArgsConstructor
public enum CorpseActorStatus {
    WALK, EAT, HEADDOWN, LOSTHEADWALK, LOSTHEADEAT, DIE;
}
