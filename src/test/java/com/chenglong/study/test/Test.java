package com.chenglong.study.test;


/**
 * @author v_longcheng
 * @date 2019/10/24
 * @description
 */
public class Test {

    public static void main(String[] args) {

        DeviceCameraEx1 deviceCameraEx = new DeviceCameraEx1();


        deviceCameraEx.setDin("1234");

        Long a = 1L;
        Long b = null;

        System.out.println(a - b);


    }


}


class DeviceCameraEx1 {

    private Long subVid;

    private String subDin;

    private String din;

    private Long pid;

    private String sn;

    public Long getSubVid() {
        return subVid;
    }

    public void setSubVid(Long subVid) {
        this.subVid = subVid;
    }

    public String getSubDin() {
        return subDin;
    }

    public void setSubDin(String subDin) {
        this.subDin = subDin;
    }

    public String getDin() {
        return din;
    }

    public void setDin(String din) {
        this.din = din;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
