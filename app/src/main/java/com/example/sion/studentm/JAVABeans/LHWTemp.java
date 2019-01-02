package com.example.sion.studentm.JAVABeans;



import java.util.List;

public class LHWTemp extends BaseBean {

    /**
     * WCurrent : 19
     * ROWS_DETAIL : [{"WData":"2017-06-06","temperature":"14~ 22"},{"WData":"2017-06-07","temperature":"15~ 24"},{"WData":"2017-06-08","temperature":"16~ 25"},{"WData":"2017-06-09","temperature":"17~ 25"},{"WData":"2017-06-10","temperature":"16~ 25"},{"WData":"2017-06-11","temperature":"16~ 22"}]
     */

    private String WCurrent;
    private List<ROWSDETAILBean> ROWS_DETAIL;

    public String getWCurrent() {
        return WCurrent;
    }

    public void setWCurrent(String WCurrent) {
        this.WCurrent = WCurrent;
    }

    public List<ROWSDETAILBean> getROWS_DETAIL() {
        return ROWS_DETAIL;
    }

    public void setROWS_DETAIL(List<ROWSDETAILBean> ROWS_DETAIL) {
        this.ROWS_DETAIL = ROWS_DETAIL;
    }

    public static class ROWSDETAILBean {
        /**
         * WData : 2017-06-06
         * temperature : 14~ 22
         */

        private String WData;
        private String temperature;

        public String getWData() {
            return WData;
        }

        public void setWData(String WData) {
            this.WData = WData;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        @Override
        public String toString() {
            return "ROWSDETAILBean{" +
                    "WData='" + WData + '\'' +
                    ", temperature='" + temperature + '\'' +
                    '}';
        }
    }
}
