package com.example.umc5thStudy.base.exception.handler;

import com.example.umc5thStudy.base.Code;
import com.example.umc5thStudy.base.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(Code errorCode) {
        super(errorCode);
    }
}