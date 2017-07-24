package com.kingfish.show.api.html;

import com.kingfish.show.bean.DetailVO;
import com.kingfish.show.mybatis.dao.ProductMapper;
import com.kingfish.show.mybatis.dao.ShowsMapper;
import com.kingfish.show.mybatis.model.Product;
import com.kingfish.show.mybatis.model.ProductExample;
import com.kingfish.show.mybatis.model.Shows;
import org.springframework.beans.BeanUtils;
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
public class GetShowDetailController {

    @Autowired
    private ShowsMapper showsMapper;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("api/get-show-detail.htm")
    public String getShowDetail(Model mode, @RequestParam(value = "showId") long showId) {
        if (showId == 0) return null;
        Shows show = showsMapper.selectByPrimaryKey(showId);
        Long productId = show.getProductId();
        Product product = null;
        if (productId != null) {
            ProductExample productExample = new ProductExample();
            ProductExample.Criteria criteria = productExample.createCriteria();
            criteria.andProductIdEqualTo(productId);
            List<Product> products = productMapper.selectByExample(productExample);
            if (!CollectionUtils.isEmpty(products)) {
                product = products.get(0);
            }
        }
        DetailVO vo = new DetailVO();
        BeanUtils.copyProperties(show, vo);
        fillProductInfo(vo, product);
        mode.addAttribute("detail", vo);
        return "get-show-detail";
    }

    private void fillProductInfo(DetailVO vo, Product product) {
        if (vo == null || product == null) return;
        if (!StringUtils.isEmpty(product.getP4pUrl())) {
            //优先使用p4p链接
            vo.setProductUrl(product.getP4pUrl());
        } else {
            vo.setProductUrl(product.getDetailUrl());
        }
    }

}
