package com.kingfish.show.api;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.kingfish.show.bean.ShowVO;
import com.kingfish.show.bean.UserVO;
import com.kingfish.show.mybatis.dao.ShowsMapper;
import com.kingfish.show.mybatis.model.Shows;
import com.kingfish.show.mybatis.model.ShowsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by kingfish on 2017/7/14.
 */
@Controller
public class GetShowsHTMLController {

    @Autowired
    private ShowsMapper showsMapper;

    @RequestMapping("api/get-shows.htm")
    public String getShows(Model mode, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ShowsExample showsExample = new ShowsExample();
        showsExample.setOrderByClause("show_time desc");
        List<Shows> shows = showsMapper.selectByExample(showsExample);
        mode.addAttribute("shows", makeVO(shows));
        return "get-shows";
    }

    @RequestMapping("api/get-shows-div.htm")
    public String getShows4Div(Model mode, @RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        ShowsExample showsExample = new ShowsExample();
        showsExample.setOrderByClause("show_time desc");
        List<Shows> shows = showsMapper.selectByExample(showsExample);
        mode.addAttribute("shows", makeVO(shows));
        return "get-shows-div";
    }

    private ShowVO makeVO(List<Shows> shows) {
        ShowVO showVO = new ShowVO();
        showVO.setMessage("Could not find any shows!");
        if (!CollectionUtils.isEmpty(shows)) {
            showVO.setSuccess(true);
            showVO.setMessage("Retrieved shows!");
            showVO.setData(Lists.newArrayList());
            shows.forEach(show -> {
                ShowVO.DataBean dataBean = new ShowVO.DataBean();
                dataBean.setId(show.getId());
                dataBean.setContent(show.getContent());
                String pics = show.getPics();
                if (StringUtils.isEmpty(pics)) return;
                String firstPicUrl = Splitter.on(",").splitToList(pics).get(0);
                //dataBean.setImage(firstPicUrl.substring(0, firstPicUrl.length() - 12));
                dataBean.setPreview(firstPicUrl);
                dataBean.setUser(new UserVO(show.getOutsideUserNickname(), show.getOutsideUserHeadPic()));
                if (show.getIsOutside()) {
                    dataBean.setOutside(show.getIsOutside());
                    dataBean.setUser(new UserVO(show.getOutsideUserNickname(), show.getOutsideUserHeadPic()));
                    //TODO:获取最近点赞的用户id和头像
                    //dataBean.setUserLikeLately();
                }
                //dataBean.setHeight("200"); self-adaption
                //dataBean.setHeight("400"); self-adaption
                showVO.getData().add(dataBean);
            });
        }
        return showVO;
    }
}
