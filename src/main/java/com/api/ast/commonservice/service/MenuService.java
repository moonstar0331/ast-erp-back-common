package com.api.ast.commonservice.service;

import com.api.ast.commonservice.dto.menu.MenuDto;

import java.util.List;

public interface MenuService {

    void insertOne(MenuDto dto);

    MenuDto selectOne(Long menuId);

    List<MenuDto> selectTree();
}
