package com.dsc.library;


import android.content.Context;

import com.dsc.library.utils.SerialPortFinder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shicaiD on 2016/10/9.
 *  串口库入口
 */
public class EasySerialPort {
    private static EasySerialPort sInstance  = null;
    private Context mContext = null;


    private EasySerialPort() throws IllegalAccessException {
        if(sInstance != null) throw new IllegalAccessException("实例已存在");
    }
    private EasySerialPort(Context context) throws IllegalAccessException {
        mContext = context.getApplicationContext();
        new EasySerialPort();
    }

    /**
     * 获取实例
     * @param context
     * @return
     */
    public synchronized static EasySerialPort getInstance(Context context) throws IllegalAccessException {
        if (sInstance == null) sInstance = new EasySerialPort(context);
        return sInstance;
    }

    //列出android机串口设备
    public List<String> showExistPort(){
        SerialPortFinder mSerialPortFinder= new SerialPortFinder();
        String[] entryValues = mSerialPortFinder.getAllDevicesPath();
        List<String> allDevices = new ArrayList<String>();
        for (int i = 0; i < entryValues.length; i++) {
            allDevices.add(entryValues[i]);
        }
        return allDevices;
    }

    public void openPort(){

    }

}
