package cs.matemaster.standardwebserver.service;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;

import java.util.List;

/**
 * @author matemaster
 */
public interface StorageManagementService {

    public int saveStorageDetail(BookStorageDetailDto bookStorageDetail);

    public int batchSaveStorageDetail(List<BookStorageDetailDto> bookStorageDetailList);
}
