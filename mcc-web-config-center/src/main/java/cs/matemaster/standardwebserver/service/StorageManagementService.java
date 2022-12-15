package cs.matemaster.standardwebserver.service;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailExportRequest;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;

import java.util.List;

/**
 * @author matemaster
 */
public interface StorageManagementService {

    int saveStorageDetail(BookStorageDetailDto bookStorageDetail);

    int batchSaveStorageDetail(List<BookStorageDetailDto> bookStorageDetailList);

    int getBookStorageDetailTotalCount();

    List<BookStorageDetailDto> pagingQueryBookStorageDetail(BookStorageDetailPagingQuery query, int offset);

    List<BookStorageDetailDto> getBookStorageDetail(BookStorageDetailExportRequest request);
}
