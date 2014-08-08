package com.jonda.rbac.shiro;

import com.jonda.common.domain.BaseDomain;
import com.jonda.rbac.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by rejoady on 2014/7/26.
 */
public class JondaRbacUtil {

    public static final String USER_SESSION_KEY = "CURRENT_SYSTEM_USER";

    public static synchronized void setCurrentUser(User user) {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute(USER_SESSION_KEY, user);
    }

    public static User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        Object user = session.getAttribute(USER_SESSION_KEY);
        return (User)user;
    }

    public static void setDataOperateInfo(BaseDomain domain, Boolean ... modify) {
        User currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("");
        }
        // 数据创建
        if (modify == null || modify.length <= 0 || !modify[0]) {
            domain.setCreator(currentUser.getName());
        }
        domain.setModifier(currentUser.getName());
    }

}
