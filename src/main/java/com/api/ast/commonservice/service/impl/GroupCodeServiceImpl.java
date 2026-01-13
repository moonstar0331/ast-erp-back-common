package com.api.ast.commonservice.service.impl;

import com.api.ast.commonservice.dto.CommonCodeGroupDetailDto;
import com.api.ast.commonservice.dto.group.GroupCodeDto;
import com.api.ast.commonservice.exception.CommonServiceException;
import com.api.ast.commonservice.exception.ErrorCode;
import com.api.ast.commonservice.mapper.GroupCodeMapper;
import com.api.ast.commonservice.service.GroupCodeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GroupCodeServiceImpl implements GroupCodeService {

    private final GroupCodeMapper groupCodeMapper;

    @Override
    @Transactional
    public void insertOne(GroupCodeDto dto) {
        try {
            groupCodeMapper.insertOne(dto);
        } catch (Exception e) {
            throw new CommonServiceException(ErrorCode.GROUP_CODE_CREATE_ERROR);
        }
    }

    @Override
    public GroupCodeDto selectOne(Long groupCodeId) {
        return groupCodeMapper.selectOne(groupCodeId);
    }

    @Override
    public List<GroupCodeDto> selectAll() {
        return groupCodeMapper.selectAll();
    }

    @Override
    @Transactional
    public GroupCodeDto updateOne(GroupCodeDto dto) {
        int updatedCount = groupCodeMapper.updateOne(dto);

        if (updatedCount == 0) {
            throw new CommonServiceException(ErrorCode.GROUP_CODE_UPDATE_ERROR);
        }

        return groupCodeMapper.selectOne(dto.getGroupCodeId());
    }

    @Override
    @Transactional
    public List<GroupCodeDto> updateAll(List<GroupCodeDto> dtoList) {
        int updatedCount = groupCodeMapper.updateAll(dtoList);

        if (updatedCount != dtoList.size()) {
            throw new CommonServiceException(ErrorCode.GROUP_CODE_UPDATE_ERROR);
        }

        for (GroupCodeDto dto : dtoList) {
            dto = groupCodeMapper.selectOne(dto.getGroupCodeId());
        }
        return dtoList;
    }

    @Override
    @Transactional
    public void deleteOne(Long groupCodeId) {
        GroupCodeDto dto = groupCodeMapper.selectOne(groupCodeId);

        if (dto == null) {
            throw new CommonServiceException(ErrorCode.GROUP_CODE_SELECT_ERROR);
        }

        dto.setDeletedYn(true);
        updateOne(dto);
    }

    @Override
    public CommonCodeGroupDetailDto selectOneWithCodes(Long groupCodeId) {
        groupCodeMapper.selectOneWithCodes(groupCodeId);
    }
}
