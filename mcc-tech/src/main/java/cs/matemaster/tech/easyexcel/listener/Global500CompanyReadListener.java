package cs.matemaster.tech.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import cs.matemaster.tech.easyexcel.model.Global500CompanyDto;
import cs.matemaster.standardwebserver.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matemaster
 */
@Slf4j
public class Global500CompanyReadListener implements ReadListener<Global500CompanyDto> {

    private static final int BATCH_COUNT = 100;
    private static List<Global500CompanyDto> cacheDataList = new ArrayList<>(BATCH_COUNT);


    @Override

    public void invoke(Global500CompanyDto global500CompanyDto, AnalysisContext analysisContext) {
        log.info("解析一条数据{}", JsonUtil.serialize(global500CompanyDto));

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
