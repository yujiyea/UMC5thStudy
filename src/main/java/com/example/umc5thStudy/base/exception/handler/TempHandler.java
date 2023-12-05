package com.example.umc5thStudy.base.exception.handler;

import com.example.umc5thStudy.base.Code;
import com.example.umc5thStudy.base.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(Code errorCode){
        super(errorCode);
    }
}
