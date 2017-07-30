package com.kingfish.show.utils;

import com.kingfish.show.bean.UserVO;
import org.springframework.web.servlet.ModelAndView;

public class LoginUtil {

    public static Long getLoginUserId(ModelAndView modelAndView) {
        if (modelAndView == null || modelAndView.getModel().get("user") == null) {
            return null;
        } else {
            UserVO userVO = (UserVO) modelAndView.getModel().get("user");
            return userVO.getId();
        }
    }
}
