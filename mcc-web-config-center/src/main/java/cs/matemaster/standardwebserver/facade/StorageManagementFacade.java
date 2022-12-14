package cs.matemaster.standardwebserver.facade;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailExportRequest;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;
import cs.matemaster.standardwebserver.common.model.response.PageDataView;

import java.util.List;

/**
 * @author matemaster
 */
public interface StorageManagementFacade {

    PageDataView<List<BookStorageDetailDto>> pagingQueryBookStorageDetail(BookStorageDetailPagingQuery query);

    void exportBookStorageDetail(BookStorageDetailExportRequest request);
}
