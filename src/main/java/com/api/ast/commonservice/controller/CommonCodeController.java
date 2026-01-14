package com.api.ast.commonservice.controller;

import com.api.ast.commonservice.dto.code.CommonCodeDto;
import com.api.ast.commonservice.service.CommonCodeService;
import com.api.ast.commonservice.vo.request.code.CommonCodeCreateRequest;
import com.api.ast.commonservice.vo.request.code.CommonCodeUpdateRequest;
import com.api.ast.commonservice.vo.response.CommonCodeGroupDetailResponse;
import com.api.ast.commonservice.vo.response.code.CommonCodeResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/code")
public class CommonCodeController {

    private final CommonCodeService commonCodeService;

    // 공통코드 단건 생성
    @PostMapping("/")
    public ResponseEntity<Void> insertOne(@RequestBody CommonCodeCreateRequest request) {
        CommonCodeDto dto = new ModelMapper().map(request, CommonCodeDto.class);
        commonCodeService.insertOne(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    // 공통코드 다건 생성
    @PostMapping("/list")

    // 공통코드 상세 조회 (공통코드 ID로)
    @GetMapping("/{codeId}")
    public ResponseEntity<CommonCodeResponse> selectOne(@PathVariable Long codeId) {
        CommonCodeDto result = commonCodeService.selectOne(codeId);
        CommonCodeResponse response = new ModelMapper().map(result, CommonCodeResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<CommonCodeResponse>> selectAll() {
        List<CommonCodeDto> result = commonCodeService.selectAll();

        ModelMapper mapper = new ModelMapper();
        List<CommonCodeResponse> response = new ArrayList<>();

        result.forEach(dto ->
                response.add(mapper.map(dto, CommonCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 리스트 조회 (그룹ID로, 공통코드만 조회)
    @GetMapping("/list/{groupCodeId}")
    public ResponseEntity<List<CommonCodeResponse>> selectAllByGroupCodeId(@PathVariable Long groupCodeId) {
        List<CommonCodeDto> result = commonCodeService.selectAllByGroupCodeId(groupCodeId);

        ModelMapper mapper = new ModelMapper();

        List<CommonCodeResponse> response = new ArrayList<>();
        result.forEach(dto ->
                response.add(mapper.map(dto, CommonCodeResponse.class))
        );

        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 단건 수정
    @PutMapping("/{codeId}")
    public ResponseEntity<CommonCodeResponse> updateOne(@PathVariable Long codeId,
                                                        @RequestBody CommonCodeUpdateRequest request) {
        CommonCodeDto dto = new ModelMapper().map(request, CommonCodeDto.class);
        dto.setCodeId(codeId);
        CommonCodeDto result = commonCodeService.updateOne(dto);
        CommonCodeResponse response = new ModelMapper().map(result, CommonCodeResponse.class);
        return ResponseEntity
                .ok()
                .body(response);
    }

    // 공통코드 다건 수정
    @PutMapping("")

    // 공통코드 단건 삭제
    @DeleteMapping("/{codeId}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long codeId) {
        commonCodeService.deleteOne(codeId);
        return ResponseEntity
                .ok()
                .build();
    }

    // 공통코드 다건 삭제
    @DeleteMapping("/list")
    public ResponseEntity<Void> deleteMany(@RequestBody List<Long> codeIdList) {
        commonCodeService.deleteMany(codeIdList);

        return ResponseEntity
                .ok()
                .build();
    }
}
