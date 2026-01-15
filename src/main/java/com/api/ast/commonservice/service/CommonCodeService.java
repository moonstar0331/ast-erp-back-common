package com.api.ast.commonservice.service;

import com.api.ast.commonservice.dto.code.CommonCodeDto;

import java.util.List;

public interface CommonCodeService {

    void insertOne(CommonCodeDto dto);

    void insertMany(List<CommonCodeDto> dtoList);

    CommonCodeDto selectOne(Long codeId);

    List<CommonCodeDto> selectAll();

    List<CommonCodeDto> selectAllByGroupCodeId(Long groupCodeId);

    CommonCodeDto updateOne(CommonCodeDto dto);

    List<CommonCodeDto> updateMany(List<CommonCodeDto> dtoList);

    void deleteOne(Long codeId);

    void deleteMany(List<Long> codeIdList);

    void deleteManyByGroupCodeId(Long groupCodeId);
}
