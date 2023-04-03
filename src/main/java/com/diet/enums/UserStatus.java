package com.diet.enums;

/**
 * User Account Status
 */
public enum UserStatus {

    /**
     * This status indicates that the user account has been created but has not yet been activated.
     * This could be because the user needs to verify their email address or complete some other
     * registration process
     */
    PENDING(0),

    /**
     * This status indicates that the user account is currently active and can be used to access the system
     */
    ACTIVE(1),

    /**
     * This status indicates that the user account is inactive and cannot be used to access the system.
     * This could be due to the user not having used the account for a certain period of time,
     * or because the user has requested to have their account deactivated
     */
    INACTIVE(2),

    /**
     * This status indicates that the user account has been blocked by the system administrator.
     * This could be because the user has violated the terms of service or engaged in other
     * inappropriate behavior
     */
    BLOCKED(3),

    /**
     * This status indicates that the user account has been deleted from the system.
     * This could be because the user has requested to have their account deleted or because the
     * account has been inactive for a long period of time
     */
    DELETED(4);

    UserStatus(int status) {

    }
}