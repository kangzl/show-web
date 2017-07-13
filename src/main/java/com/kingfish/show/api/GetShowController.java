package com.kingfish.show.api;

import com.github.pagehelper.PageHelper;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.kingfish.show.bean.ShowVO;
import com.kingfish.show.mybatis.dao.ShowsMapper;
import com.kingfish.show.mybatis.model.Shows;
import com.kingfish.show.mybatis.model.ShowsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by kingfish on 2017/7/14.
 */
@RestController
public class GetShowController {

    @Autowired
    private ShowsMapper showsMapper;

    @RequestMapping("api/get-shows.json")
    public ShowVO getBooks(@RequestParam(value = "page", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Shows> shows = showsMapper.selectByExample(new ShowsExample());
        return makeVO(shows);
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
                dataBean.setId(String.valueOf(show.getId()));
                dataBean.setTitle(show.getContent());
                String pics = show.getPics();
                if (StringUtils.isEmpty(pics)) return;
                String firstPicUrl = Splitter.on(",").splitToList(pics).get(0);
                dataBean.setImage(firstPicUrl.substring(0, firstPicUrl.length() - 12));
                dataBean.setPreview(firstPicUrl);
                dataBean.setHeight("200");
                dataBean.setHeight("400");
                showVO.getData().add(dataBean);
            });
        }
        return showVO;
    }
}
