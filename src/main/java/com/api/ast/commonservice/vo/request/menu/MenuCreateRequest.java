package com.api.ast.commonservice.vo.request.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuCreateRequest {
    private Long parentMenuId;
    private String menuName;
    private String menuCode;
    private String menuTypeCode;
    private Integer sortOrder;
    private String path;
    private String useYn;
}
