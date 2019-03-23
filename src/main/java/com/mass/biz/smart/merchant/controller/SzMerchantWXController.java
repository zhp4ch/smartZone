package com.mass.biz.smart.merchant.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.merchant.model.SzMerchant;
import com.mass.biz.smart.merchant.service.SzMerchantService;
import com.mass.biz.smart.merchantMgt.model.SzMerchantMgt;
import com.mass.biz.smart.merchantMgt.service.SzMerchantMgtService;
import com.mass.core.utils.AjaxResponse;
import org.activiti.editor.language.json.converter.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName 商户入驻
 * @Author 郑上进
 * @Date 2018/7/17 14:59
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/wx/szMerchant")
public class SzMerchantWXController {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private SzMerchantService szMerchantService;

    @Autowired
    SzMerchantMgtService szMerchantMgtService;

    @RequestMapping(value = "/selectByCondition", method = RequestMethod.POST)
    public AjaxResponse selectByCondition(SzMerchant szMerchant) {
        try {
            List<SzMerchant> list = szMerchantService.selectByCondition(szMerchant);
            return AjaxResponse.success("ok", list);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }


    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(SzMerchant szMerchant) {
        try {
            String code = szMerchant.getMerchant_code();
            SzMerchant merchant = szMerchantService.getEntityByCode(code);
            if (merchant != null) {//说明已经存在该企业
                if (merchant.getMerchantState().intValue() == 1) {//说明该企业为启用状态,0禁用,1启用
                    if (merchant.getExamineState().intValue() == 1) {//已通过
                        return AjaxResponse.success("running"); //该企业正在使用中
                    }
                } else {//禁用
                    if (merchant.getExamineState().intValue() == 0) {//说明该企业正在审核中,则可以再次进行审请,0审核中，1已通过，2已驳回
                        return AjaxResponse.success("auditing");
                    } else if (merchant.getExamineState().intValue() == 2) {
                        SzMerchant rpk = this.szMerchantService.addEntity(szMerchant);
                        if (rpk.getId() != null) {
                            return AjaxResponse.success("ok", szMerchant);
                        } else {
                            return AjaxResponse.error("error");
                        }
                    }
                }
            } else {
                //可以审请该企业
                SzMerchant rpk = this.szMerchantService.addEntity(szMerchant);
                if (rpk.getId() != null) {
                    return AjaxResponse.success("ok", szMerchant);
                } else {
                    return AjaxResponse.error("error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("insert sz error!", e);
            return AjaxResponse.error("error");
        }
        return AjaxResponse.error("error");

    }

    @RequestMapping(value = "/showStatusByUserId", method = RequestMethod.POST)
    public AjaxResponse showStatusByUserId(SzMerchant szMerchant) {
        List<SzMerchant> list = szMerchantService.selectByCondition(szMerchant);
        if (CollectionUtils.isNotEmpty(list)) {
            //该用户已经申请过企业了,判断状态
            SzMerchant merchant = list.get(0);
            if (merchant.getMerchantState().intValue() == 1) {//说明该企业为启用状态,0禁用,1启用
                if (merchant.getExamineState().intValue() == 1) {//已通过
                    return AjaxResponse.success("pass", merchant); //该企业正在使用中
                }
            } else {//禁用
                if (merchant.getExamineState().intValue() == 0) {//说明该企业正在审核中,则可以再次进行审请,0审核中，1已通过，2已驳回
                    return AjaxResponse.success("auditing");//请耐心等待
                } else if (merchant.getExamineState().intValue() == 2) {//已驳回
                    return AjaxResponse.success("refused");//已驳回
                } else if (merchant.getExamineState().intValue() == 1) {//已驳回
                    return AjaxResponse.success("auditing");//
                }
            }
        } else {
            return AjaxResponse.success("normal");//正常,可以申请加入
        }
        return AjaxResponse.error("error");
    }

    /**
     * 根据id查询数据
     *
     * @Author 郑上进
     * @Date 14:45 2018/7/18
     **/
    @RequestMapping(value = "/getEntityById", method = RequestMethod.GET)
    public AjaxResponse getEntityById(@RequestParam("id") Long id) {
        try {
            SzMerchant szMerchant = szMerchantService.getEntityById(id);
            return AjaxResponse.success("ok", szMerchant);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    @RequestMapping(value = "/getEntityByUserid", method = RequestMethod.GET)
    public AjaxResponse getEntityByUserid(@RequestParam("user_id") Long id) {
        try {
            SzMerchant szMerchant = szMerchantService.getEntityByUserid(id);
            return AjaxResponse.success("ok", szMerchant);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select sz error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * //园区、楼栋、门牌号，有效数据唯一校验
     *
     * @param szMerchantMgt
     * @return
     */
    @RequestMapping(value = "/countByDoorNumber", method = RequestMethod.GET)
    public AjaxResponse countByDoorNumber(SzMerchantMgt szMerchantMgt) {

        Long count_dn = szMerchantMgtService.countByDoorNumber(szMerchantMgt);
        return AjaxResponse.success("ok", count_dn);
    }





}
