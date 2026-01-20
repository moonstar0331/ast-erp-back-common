package com.api.ast.commonservice.service.impl;

import com.api.ast.commonservice.dto.menu.MenuDto;
import com.api.ast.commonservice.exception.CommonServiceException;
import com.api.ast.commonservice.exception.ErrorCode;
import com.api.ast.commonservice.mapper.MenuMapper;
import com.api.ast.commonservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Override
    @Transactional
    public void insertOne(MenuDto dto) {
        try {
            menuMapper.insertOne(dto);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonServiceException(ErrorCode.MENU_CREATE_ERROR);
        }
    }

    @Override
    public MenuDto selectOne(Long menuId) {
        return menuMapper.selectOne(menuId);
    }

    @Override
    public List<MenuDto> selectTree() {
        List<MenuDto> flatMenus = menuMapper.selectTree();
        return buildMenuTree(flatMenus);
    }

    private List<MenuDto> buildMenuTree(List<MenuDto> flatList) {
        Map<Long, MenuDto> menuMap = new LinkedHashMap<>();
        List<MenuDto> rootMenus = new ArrayList<>();

        for (MenuDto menu : flatList) {
            menuMap.put(menu.getMenuId(), menu);
        }

        for (MenuDto menu : flatList) {
            if (menu.getParentMenuId() == null) {
                rootMenus.add(menu);
            } else {
                MenuDto parent = menuMap.get(menu.getParentMenuId());
                if (parent != null) {
                    parent.getChildren().add(menu);
                }
            }
        }

        return rootMenus;
    }
}
