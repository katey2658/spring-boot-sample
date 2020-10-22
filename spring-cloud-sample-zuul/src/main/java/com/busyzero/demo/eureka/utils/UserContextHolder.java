package com.busyzero.demo.eureka.utils;

import com.busyzero.demo.stream.vo.UserContext;
import org.springframework.util.Assert;

public class UserContextHolder {
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();
    public static final UserContext curUserContenxt() {
        UserContext context = userContext.get();
        if (context == null){
            context = createEmptyContext();
            userContext.set(context);
        }
        return userContext.get();
    }

    public static final UserContext createEmptyContext() {
        return new UserContext();
    }

    public static final void setContext(UserContext context) {
        Assert.notNull(context, "Only none-null UserContext instance are permitted");
        userContext.set(context);
    }

}
