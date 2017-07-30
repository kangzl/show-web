package com.kingfish.show.interceptor;

import com.kingfish.show.bean.UserVO;
import com.kingfish.show.constants.Cookies;
import com.kingfish.show.mybatis.model.User;
import com.kingfish.show.utils.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class RenderContextHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        Map<String, Object> model = modelAndView.getModel();
        //登录用户信息
        Cookie uuid = CookieUtil.getCookieByName(request, Cookies.USER_TOKEN_ID);
        if (StringUtils.isEmpty(uuid)) {
            //未登录
            model.put("isLogin", false);
        } else {
            User user = (User) request.getSession().getAttribute(uuid.getValue());
            if (user == null) {
                model.put("isLogin", false);
            } else {
                model.put("isLogin", true);
                model.put("user", conver2VO(user));
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }

    private UserVO conver2VO(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUserName(user.getUsername());
        userVO.setHeaderPicUrl(user.getHeaderPicUrl());
        userVO.setSex(user.getSex().toString());
        userVO.setEmail(user.getEmail());
        userVO.setMobilePhoneNumber(user.getMobilePhoneNumber());
        userVO.setSignature(user.getSignature());
        userVO.setHideNickName(user.getHideNickName());
        return userVO;
    }
}
