package com.mass.biz.smart.services.Contract.controller;

import com.mass.biz.news.controller.NewsController;
import com.mass.biz.smart.services.Contract.model.Contract;
import com.mass.biz.smart.services.Contract.service.ContractService;
import com.mass.core.utils.AjaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName
 * @Author 郑上进
 * @Date 2018/8/7 9:57
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/contract")
public class ContractController {

    private final static Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private ContractService contractService;

    /*后台管理*/

     /**
     * @Name 列表及条件查询
     * @Param page, limit
     * @Author 郑上进
     * @Date 15:59 2018/8/7
     **/
    @RequestMapping(value = "/selectPageList", method = RequestMethod.GET)
    public AjaxResponse selectPageList(Contract contract,
                                       @RequestParam(value = "page") Integer pageIndex,
                                       @RequestParam(value = "limit") Integer pageSize) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            /*查询所有合同*/
            List<Contract> contractList = contractService.selectPageList(contract, (pageIndex - 1) * 0, 999999);
            if (contractList.size() > 0) {
                for (int i = 0; i < contractList.size(); i++) {
                    Contract contract1 = contractList.get(i);
                    /*合同到期时间*/
                    Date expiryTime = format.parse(contract1.getExpiryTime());
                    Long nowTime = System.currentTimeMillis();
                    Contract contract2 = new Contract();
                    /*正常*/
                    if (expiryTime.getTime() - nowTime > 1296000000 && contract1.getContractState() != 0
                            ) {
                        contract2.setId(contract1.getId());
                        contract2.setContractState(0);
                        contractService.editEntity(contract2);
                    } else if (expiryTime.getTime() - nowTime < 1296000000 &&
                            expiryTime.getTime() - nowTime > 86400000  && contract1.getContractState() != 1
                            ) {
                        /*将过期*/
                        contract2.setId(contract1.getId());
                        contract2.setContractState(1);
                        contractService.editEntity(contract2);
                    } else if (expiryTime.getTime() < nowTime && contract1.getContractState() != 2
                            ) {
                        /*已过期*/
                        contract2.setId(contract1.getId());
                        contract2.setContractState(2);
                        contractService.editEntity(contract2);
                    }
                }
            }
            Long count = contractService.count(contract);
            List<Contract> list = contractService.selectPageList(contract, (pageIndex - 1) * pageSize, pageSize);
            return AjaxResponse.success("ok", list, count, pageIndex);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select cont error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * @Name 新增合同
     * @Param object
     * @Author 郑上进
     * @Date 10:32 2018/8/10
     **/
    @RequestMapping(value = "/addEntity", method = RequestMethod.POST)
    public AjaxResponse addEntity(Contract contract) {
        try {
            this.contractService.addEntity(contract);
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("inster cont error!", e);
            return AjaxResponse.error("error");
        }
    }

    /**
     * @Name 修改数据
     * @Param object
     * @Author 郑上进
     * @Date 10:32 2018/8/10
     **/
    @RequestMapping(value = "/editEntity", method = RequestMethod.POST)
    public AjaxResponse editEntity(Contract contract) {
        try {
            this.contractService.editEntity(contract);
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("update cont error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 删除数据
     * @Param id
     * @Author 郑上进
     * @Author 郑上进
     * @Date 16:01 2018/8/7
     **/
    @RequestMapping(value = "/deleteEntity", method = RequestMethod.GET)
    public AjaxResponse deleteEntity(Long id) {
        try {
            this.contractService.deleteEntity(id);
            return AjaxResponse.success("ok", 0);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("delete cont error!", e);
            return AjaxResponse.error("error");
        }
    }


    /*微信端*/

    /**
     * @Name 微信-根据公司id查询该用户租赁合同；
     * @Param companyId
     * @Author 郑上进
     * @Date 9:16 2018/8/13
     **/
    @RequestMapping(value = "/getCompanyIdByZn", method = RequestMethod.POST)
    public AjaxResponse getCompanyIdByZn(Long companyId) {
        try {
            List<Contract> contractList = contractService.getCompanyIdByZn(companyId);
            return AjaxResponse.success("ok", contractList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select cont error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 微信-根据公司id查询该用户所有其他类型合同
     * @Param companyId
     * @Author 郑上进
     * @Date 9:17 2018/8/13
     **/
    @RequestMapping(value = "/getCompanyIdByQt", method = RequestMethod.POST)
    public AjaxResponse getCompanyIdByQt(Long companyId) {
        try {
            List<Contract> contractList = contractService.getCompanyIdByQt(companyId);
            return AjaxResponse.success("ok", contractList);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("select cont error!", e);
            return AjaxResponse.error("error");
        }
    }


    /**
     * @Name 更改文件名下载附件
     * @Param contractUrl fileName
     * @Author 郑上进
     * @Date 19:34 2018/8/29
     **/

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(String contractUrl , String fileName, HttpServletResponse response){

        //查询FilePath
        Contract contract = contractService.selectPath(contractUrl);
        String filePath=contract.getFilePath();
        try {
            // path是指欲下载的文件的路径。
            File file = new File(filePath);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            //String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream;charset=UTF-8");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}
