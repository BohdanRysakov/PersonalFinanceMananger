package com.pfma.enums;

public enum RoleName {
    ROLE_VIEWER,        // Наблюдатель
    ROLE_DEPOSITOR,     // Участник с правом пополнять бюджет
    ROLE_WITHDRAWER,    // Участник с правом снимать деньги
    ROLE_PARTICIPANT,   // Участник с ограничением по сумме
    ROLE_OWNER,         // Владелец (полный доступ)
    ROLE_ADMIN          // Администратор (может изменять права на те, которые разрешит владелец)
}