package com.api.ast.commonservice.vo.request.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeCreateRequest {
    private Long groupCodeId;
    private String codeValue;
    private String codeName;
    private String useYn;
}
