package com.example.umc5thStudy.web.controller;

import com.example.umc5thStudy.base.Code;
import com.example.umc5thStudy.base.ResponseDto;
import com.example.umc5thStudy.converter.TempConverter;
import com.example.umc5thStudy.service.TempService.TempQueryService;
import com.example.umc5thStudy.web.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testAPI(){

        return ResponseDto.onSuccess(Code.OK, TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ResponseDto<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseDto.onSuccess(Code.OK, TempConverter.toTempExceptionDTO(flag));
    }
}
