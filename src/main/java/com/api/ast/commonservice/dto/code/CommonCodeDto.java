package com.api.ast.commonservice.dto.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeDto {
    private Long codeId;
    private Long groupCodeId;
    private String groupCode;
    private String codeValue;
    private String codeName;
    private String useYn;
}
