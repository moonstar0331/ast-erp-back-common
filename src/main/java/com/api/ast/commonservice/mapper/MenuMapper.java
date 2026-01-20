package com.api.ast.commonservice.mapper;

import com.api.ast.commonservice.dto.menu.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    void insertOne(MenuDto dto);

    MenuDto selectOne(Long menuId);

    List<MenuDto> selectTree();
}
