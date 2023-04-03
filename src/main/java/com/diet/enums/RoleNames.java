package com.diet.enums;

/**
 * User Roles
 */
public enum RoleNames {

    /**
     * This role has full access to all features and functions of the system.
     * Administrators can manage other users, create new accounts, and configure system settings
     */
    ADMIN,

    /**
     * This role has access to some administrative functions but is primarily responsible for
     * managing other users and/or resources within the system. Managers may have access to certain
     * reports or analytics.
     */
    MANAGER,

    /**
     * This role has limited access to the system and can only perform certain functions
     * based on their permissions. Users may be able to view or edit their own profile,
     * create or modify content, or interact with other users
     */
    USER,

    /**
     * This role has limited access to the system and is typically used for users who have not yet
     * created an account or who do not have any permissions. Guests may be able to view some content
     * or perform basic functions but cannot access all features of the system
     */
    GUEST,

    /**
     * This role has access to support-related features and functions, such as handling customer
     * support tickets, responding to user inquiries, or providing technical assistance.
     */
    SUPPORT,

    /**
     * IT Guys
     */
    IT_SUPPORT
}