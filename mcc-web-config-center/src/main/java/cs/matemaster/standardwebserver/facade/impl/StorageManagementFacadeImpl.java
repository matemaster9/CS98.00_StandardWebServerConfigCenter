package cs.matemaster.standardwebserver.facade.impl;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailExportRequest;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;
import cs.matemaster.standardwebserver.common.util.BusinessUtil;
import cs.matemaster.standardwebserver.common.util.EasyExcelUtil;
import cs.matemaster.standardwebserver.facade.StorageManagementFacade;
import cs.matemaster.standardwebserver.service.StorageManagementService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author matemaster
 */
@Component
@RequiredArgsConstructor
public class StorageManagementFacadeImpl implements StorageManagementFacade {

    private final StorageManagementService storageManagementService;

    @Override
    public PageDataView<List<BookStorageDetailDto>> pagingQueryBookStorageDetail(BookStorageDetailPagingQuery query) {

        // todo: 获取全部数据数量
        int totalCount = storageManagementService.getBookStorageDetailTotalCount();
        // todo：计算分页参数
        int offset = BusinessUtil.getQueryOffset(totalCount, query.getPageSize());
        // todo：获取分页查询结果
        List<BookStorageDetailDto> bookStorageDetail = storageManagementService.pagingQueryBookStorageDetail(query, offset);

        return PageDataView.<List<BookStorageDetailDto>>builder()
                .pageNo(query.getPageNo())
                .pageSize(query.getPageSize())
                .data(bookStorageDetail)
                .build();
    }

    @Override
    public void exportBookStorageDetail(BookStorageDetailExportRequest request) {
        // todo: 查询结果
        List<BookStorageDetailDto> bookStorageDetail = storageManagementService.getBookStorageDetail(request);
        // todo：-> excel对象

        // todo：导出

    }
}
