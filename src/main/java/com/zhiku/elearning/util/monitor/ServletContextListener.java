package com.zhiku.elearning.util.monitor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.ServletContextEvent;

// TODO 暂且去掉
//@Component
public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Value( "${file_path.visit_statistics}" )
    private String statisticsPath;

    //仅在服务端开启时运行一次
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        VisitStatistics.setSaveFile(statisticsPath);
        VisitStatistics.run();
    }

}
