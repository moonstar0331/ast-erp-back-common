package com.api.ast.commonservice.vo.response.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    private Long menuId;
    private Long parentMenuId;
    private String menuName;
    private String menuCode;
    private String menuTypeCode;
    private Integer sortOrder;
    private String path;
    private String useYn;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;

    private List<MenuResponse> children = new ArrayList<>();
}
