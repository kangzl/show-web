package com.kingfish.show.api.json;

import com.kingfish.show.bean.BaseVO;
import com.kingfish.show.bean.UserVO;
import com.kingfish.show.constants.Cookies;
import com.kingfish.show.mybatis.dao.UserMapper;
import com.kingfish.show.mybatis.model.User;
import com.kingfish.show.mybatis.model.UserExample;
import com.kingfish.show.utils.CookieUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("api/login.json")
    public UserVO login(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") String userName, @RequestParam(value = "pwd") String pwd) {
        UserVO userVO = new UserVO();
        userVO.setSuccess(false);
        userVO.setMessage("用户名或密码错误!");

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);

        if (CollectionUtils.isEmpty(users)) {
            return userVO;
        }

        User user = users.get(0);
        if (DigestUtils.md5Hex(DigestUtils.md5Hex(pwd.getBytes())).equals(user.getPassword())) {
            userVO.setSuccess(true);
            //生成uuid存放在cookie
            String uuid = UUID.randomUUID().toString();
            CookieUtil.addCookie(response, Cookies.USER_TOKEN_ID, uuid, Cookies.MAX_AGE);
            request.getSession().setAttribute(uuid, user);
        }

        return userVO;
    }

    @RequestMapping("api/logout.json")
    public BaseVO logout(HttpServletRequest request, HttpServletResponse response) {
        BaseVO baseVO = new BaseVO();
        Cookie uuid = CookieUtil.getCookieByName(request, Cookies.USER_TOKEN_ID);
        if (StringUtils.isEmpty(uuid)) {
            baseVO.setSuccess(false);
            baseVO.setMessage("没有发现cookie信息!");
            return baseVO;
        }
        request.getSession().removeAttribute(uuid.getValue());
        CookieUtil.removeCookie(request, response, Cookies.USER_TOKEN_ID);
        baseVO.setSuccess(true);
        return baseVO;
    }
}
