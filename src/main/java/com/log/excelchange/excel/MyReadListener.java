package com.log.excelchange.excel;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.log.excelchange.log.Log;

import java.util.ArrayList;
import java.util.List;

public class MyReadListener<T> extends AnalysisEventListener<T> {

    public static final String TAG = "MyReadListener";
    public List<T> dataList = new ArrayList<>();
    private IReadResultListener listener;

    public MyReadListener(IReadResultListener listener) {
        this.listener = listener;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        Log.error(TAG, "onException: " + exception.getMessage());
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
//        System.out.println("==========>>>" + data);
        dataList.add(data);
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        Log.info(TAG, "extra: " + extra);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        Log.info(TAG, "doAfterAllAnalysed: " + context);
        if (listener != null) {
            listener.onResult(dataList);
        }
    }

}
