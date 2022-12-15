package cs.matemaster.standardwebserver.service.impl;

import cs.matemaster.standardwebserver.common.exception.BaseTransactionException;
import cs.matemaster.standardwebserver.common.model.dto.storage_management.BookStorageDetailDto;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailExportRequest;
import cs.matemaster.standardwebserver.common.model.request.BookStorageDetailPagingQuery;
import cs.matemaster.standardwebserver.constant.ConfigCenterErrorEnum;
import cs.matemaster.standardwebserver.mapper.StorageManagementMapper;
import cs.matemaster.standardwebserver.service.StorageManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author matemaster
 */
@Service
@RequiredArgsConstructor
public class StorageManagementServiceImpl implements StorageManagementService {

    private final StorageManagementMapper storageManagementMapper;


    @Override
    @Transactional(rollbackFor = BaseTransactionException.class)
    public int saveStorageDetail(BookStorageDetailDto bookStorageDetail) {
        try {
            storageManagementMapper.insertStorageDetail(bookStorageDetail);
            return 1;
        } catch (Exception ex) {
            throw new BaseTransactionException(ConfigCenterErrorEnum.MCCA_SAVE_STORAGE_DETAIL_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = BaseTransactionException.class)
    public int batchSaveStorageDetail(List<BookStorageDetailDto> bookStorageDetailList) {
        try {
            storageManagementMapper.insertStorageDetailList(bookStorageDetailList);
            return bookStorageDetailList.size();
        } catch (Exception ex) {
            throw new BaseTransactionException(ConfigCenterErrorEnum.MCCA_SAVE_STORAGE_DETAIL_ERROR);
        }
    }

    @Override
    public int getBookStorageDetailTotalCount() {
        return storageManagementMapper.findAllBookStorageDetail();
    }

    @Override
    public List<BookStorageDetailDto> pagingQueryBookStorageDetail(BookStorageDetailPagingQuery query, int offset) {
        return storageManagementMapper.findBookStorageDetailWithPagingQuery(query, offset);
    }

    @Override
    public List<BookStorageDetailDto> getBookStorageDetail(BookStorageDetailExportRequest request) {
        return null;
    }
}
