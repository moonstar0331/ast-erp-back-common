package com.api.ast.commonservice.controller;

import com.api.ast.commonservice.dto.menu.MenuDto;
import com.api.ast.commonservice.service.MenuService;
import com.api.ast.commonservice.vo.request.menu.MenuCreateRequest;
import com.api.ast.commonservice.vo.response.menu.MenuResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    // 메뉴 단건 생성
    @PostMapping
    public ResponseEntity<Void> insertOne(@RequestBody MenuCreateRequest request) {
        MenuDto dto = new ModelMapper().map(request, MenuDto.class);
        menuService.insertOne(dto);
        return ResponseEntity.ok().build();
    }

    // 하위 메뉴 상세 조회
    @GetMapping("/{menuId}")
    public ResponseEntity<MenuResponse> selectOne(@PathVariable Long menuId) {
        MenuDto result = menuService.selectOne(menuId);
        MenuResponse response = new ModelMapper().map(result, MenuResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 메뉴 트리 조회
    @GetMapping("/tree")
    public ResponseEntity<List<MenuResponse>> selectTree() {
        List<MenuDto> result = menuService.selectTree();

        ModelMapper mapper = new ModelMapper();
        List<MenuResponse> response = new ArrayList<>();
        result.forEach(dto ->
                response.add(mapper.map(dto, MenuResponse.class))
        );
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 메뉴 수정

    // 메뉴 삭제
}
