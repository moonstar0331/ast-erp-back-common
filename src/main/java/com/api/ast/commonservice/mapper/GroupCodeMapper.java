package com.api.ast.commonservice.mapper;

import com.api.ast.commonservice.dto.CommonCodeGroupDetailDto;
import com.api.ast.commonservice.dto.group.GroupCodeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupCodeMapper {

    int insertOne(@Param("groupCode") GroupCodeDto groupCode);

    GroupCodeDto selectOne(@Param("groupCodeId") Long groupCodeId);

    List<GroupCodeDto> selectAll();

    int updateOne(@Param("groupCode") GroupCodeDto groupCode);

    int updateAll(@Param("groupCodeList") List<GroupCodeDto> groupCodeList);

    CommonCodeGroupDetailDto selectOneWithCodes(@Param("groupCodeId") Long groupCodeId);
}
