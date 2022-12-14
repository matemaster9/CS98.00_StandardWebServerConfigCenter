package cs.matemaster.standardwebserver.facade.impl;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailExportRequest;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.facade.StorageManagementFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class StorageManagementFacadeImpl implements StorageManagementFacade {


    @Override
    public PageDataView<List<BookStorageDetailDto>> pagingQueryBookStorageDetail(BookStorageDetailPagingQuery query) {

        // todo: 获取全部数据数量

        // todo：计算分页参数

        // todo：获取分页查询结果

        return null;
    }

    @Override
    public void exportBookStorageDetail(BookStorageDetailExportRequest request) {

    }
}
