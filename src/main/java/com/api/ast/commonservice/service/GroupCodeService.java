package com.api.ast.commonservice.service;

import com.api.ast.commonservice.dto.CommonCodeGroupDetailDto;
import com.api.ast.commonservice.dto.group.GroupCodeDto;

import java.util.List;

public interface GroupCodeService {
    void insertOne(GroupCodeDto dto);

    GroupCodeDto selectOne(Long groupCodeId);

    List<GroupCodeDto> selectAll();

    GroupCodeDto updateOne(GroupCodeDto dto);

    List<GroupCodeDto> updateAll(List<GroupCodeDto> dtoList);

    void deleteOne(Long groupCodeId);

    CommonCodeGroupDetailDto selectOneWithCodes(Long groupCodeId);

    List<CommonCodeGroupDetailDto> selectAllWithCodes();
}
