package com.bst.red_green_blue.util;

/**
 * Created by 熊厚谨 on 2018/6/16 11:00
 *
 * @author 熊厚谨
 */
public class RoleUtil {

    public static String RoleValidate(int role) {
        String userRole = "";
        switch (role) {
            case 0:
                userRole = "ROLE_ADMIN";
                break;
            case 1:
                userRole = "ROLE_CUSTOMER";
                break;
            default:
        }
        return userRole;
    }
}
