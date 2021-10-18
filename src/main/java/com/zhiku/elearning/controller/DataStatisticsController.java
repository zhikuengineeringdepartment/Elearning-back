package com.zhiku.elearning.controller;

import com.zhiku.elearning.service.DataStatisticsService;
import com.zhiku.elearning.util.ResponseData;
import com.zhiku.elearning.util.SmallTools;
import com.zhiku.elearning.util.monitor.VisitStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;


@CrossOrigin(value = "*")
@Controller
@RequestMapping("dataStatistics")
public class DataStatisticsController {

    @Autowired
    private DataStatisticsService dataStatisticsService;

    /**
     * 访问信息记录
     *
     * @param response
     * @param lastURI
     * @param nextURI
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping("access")
    public ResponseData access(HttpServletRequest response, String lastURI, String nextURI) throws ParseException {
        String ip = SmallTools.getIp(response);
        System.out.println("访问记录<测试>：" + lastURI + "->" + nextURI + "|" + ip);//TODO:查看日志用，待删除
        VisitStatistics.setDataStatisticsService(dataStatisticsService);
        if (nextURI != null) {
            VisitStatistics.addStart(ip, nextURI, new Date());
        }
        if (lastURI != null) {
            VisitStatistics.addEnd(ip, lastURI, new Date());
        }
        return ResponseData.ok();
    }

}
