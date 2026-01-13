package com.api.ast.commonservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/code")
public class CommonCodeController {

    // 공통코드 단건 생성
    @PostMapping("/")

    // 공통코드 다건 생성
    @PostMapping("/list")

    // 공통코드 상세 조회 (공통코드 ID로)
    @GetMapping("/{codeId}")

    // 공통코드 전체 조회
    @GetMapping("/list")

    // 공통코드 단건 수정
    @PutMapping("/{codeId}")

    // 공통코드 다건 수정
    @PutMapping("")

    // 공통코드 단건 삭제
    @DeleteMapping("/{codeId}")

    // 공통코드 다건 삭제
    @DeleteMapping("/list")
}
