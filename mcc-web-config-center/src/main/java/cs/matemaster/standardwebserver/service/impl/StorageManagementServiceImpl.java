package cs.matemaster.standardwebserver.service.impl;

import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.mapper.StorageManagementMapper;
import cs.matemaster.standardwebserver.service.StorageManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author matemaster
 */
@Service
@RequiredArgsConstructor
public class StorageManagementServiceImpl implements StorageManagementService {

    private final StorageManagementMapper storageManagementMapper;

    @Override
    public int saveStorageDetail(BookStorageDetailDto bookStorageDetail) {
        storageManagementMapper.insertStorageDetail(bookStorageDetail);
        return 1;
    }

    @Override
    public int batchSaveStorageDetail(List<BookStorageDetailDto> bookStorageDetailList) {
        storageManagementMapper.insertStorageDetailList(bookStorageDetailList);
        return bookStorageDetailList.size();
    }
}
