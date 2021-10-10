package com.log.excelchange.excel;

import java.util.List;

public interface IReadResultListener<T> {

    void onResult(List<T> list);
}
