package com.example.sion.studentm.JAVABeans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Studentlogin extends BaseBean implements Serializable {

    /**
     * student : {"result":null,"id":112027,"sid":1711605009,"scare":"1","class":null,"sname":"梁浩文","majory":"信息工程系_移动应用开发","prime":0,"errsg":"成功"}
     * sid : 1711605009
     * scare : 1
     */

    private StudentBean student;
    private int sid;
    private String scare;

    public StudentBean getStudent() {
        return student;
    }

    public void setStudent(StudentBean student) {
        this.student = student;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getScare() {
        return scare;
    }

    public void setScare(String scare) {
        this.scare = scare;
    }

    public static class StudentBean implements Serializable {
        @Override
        public String toString() {
            return "StudentBean{" +
                    "resultX=" + resultX +
                    ", id=" + id +
                    ", sid=" + sid +
                    ", scare='" + scare + '\'' +
                    ", classX=" + classX +
                    ", sname='" + sname + '\'' +
                    ", majory='" + majory + '\'' +
                    ", prime=" + prime +
                    ", errsgX='" + errsgX + '\'' +
                    '}';
        }

        /**
         * result : null
         * id : 112027
         * sid : 1711605009
         * scare : 1
         * class : null
         * sname : 梁浩文
         * majory : 信息工程系_移动应用开发
         * prime : 0.0
         * errsg : 成功
         */

        @SerializedName("result")
        private Object resultX;
        private int id;
        private int sid;
        private String scare;
        @SerializedName("class")
        private Object classX;
        private String sname;
        private String majory;
        private double prime;
        @SerializedName("errsg")
        private String errsgX;

        public Object getResultX() {
            return resultX;
        }

        public void setResultX(Object resultX) {
            this.resultX = resultX;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getScare() {
            return scare;
        }

        public void setScare(String scare) {
            this.scare = scare;
        }

        public Object getClassX() {
            return classX;
        }

        public void setClassX(Object classX) {
            this.classX = classX;
        }

        public String getSname() {
            return sname;
        }

        public void setSname(String sname) {
            this.sname = sname;
        }

        public String getMajory() {
            return majory;
        }

        public void setMajory(String majory) {
            this.majory = majory;
        }

        public double getPrime() {
            return prime;
        }

        public void setPrime(double prime) {
            this.prime = prime;
        }

        public String getErrsgX() {
            return errsgX;
        }

        public void setErrsgX(String errsgX) {
            this.errsgX = errsgX;
        }
    }

    @Override
    public String toString() {
        return "Studentlogin{" +
                "student=" + student +
                ", sid=" + sid +
                ", scare='" + scare + '\'' +
                '}';
    }
}
