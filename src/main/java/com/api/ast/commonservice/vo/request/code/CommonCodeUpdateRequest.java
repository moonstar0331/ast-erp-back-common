package com.api.ast.commonservice.vo.request.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeUpdateRequest {
    private Long codeId;
    private String codeName;
    private String useYn;
}
