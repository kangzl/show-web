package com.kingfish.show.bean;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.kingfish.show.mybatis.model.Shows;
import org.springframework.util.StringUtils;

import java.util.List;

public class DetailVO extends Shows {
    private String productUrl;

    public List<String> getPicUrls() {
        List<String> result = Lists.newArrayList();
        if (!StringUtils.isEmpty(this.getPics())) {
            List<String> pics = Splitter.on(",").splitToList(this.getPics());
            for (String pic : pics) {
                result.add(pic.substring(0, pic.length() - 12));
            }
        }
        return result;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
