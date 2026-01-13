package com.api.ast.commonservice.vo.response;

import com.api.ast.commonservice.vo.response.code.CommonCodeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonCodeGroupDetailResponse {
    private Long groupCodeId;
    private String groupCode;
    private String groupName;
    private String useYn;
    private List<CommonCodeResponse> codes;
}
