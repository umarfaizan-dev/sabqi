package com.example.recycleview;

import java.util.ArrayList;

public class Student {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public class Data {
        String date;
        String manzil;
        String sabaq;
        String sabqi;


        public Data(String date, String manzil, String sabaq, String sabqi) {
            this.date = date;
            this.manzil = manzil;
            this.sabaq = sabaq;
            this.sabqi = sabqi;
        }

        @Override
        public String toString() {
            return
                    "date='" + date + '\'' +
                    ",\n manzil='" + manzil + '\'' +
                    ",\n sabaq='" + sabaq + '\'' +
                    ",\n sabqi='" + sabqi + '\'' +
                            "\n"
                   ;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getManzil() {
            return manzil;
        }

        public void setManzil(String manzil) {
            this.manzil = manzil;
        }

        public String getSabaq() {
            return sabaq;
        }

        public void setSabaq(String sabaq) {
            this.sabaq = sabaq;
        }

        public String getSabqi() {
            return sabqi;
        }

        public void setSabqi(String sabqi) {
            this.sabqi = sabqi;
        }
    }

    int id;
    String name;
    ArrayList<Data> studentData;

    public Student(String name, int id) {
        this.name = name;

        this.id = id;
        this.studentData = new ArrayList<Data>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +

                '}';
    }
    public ArrayList<Data> getData() {return studentData;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Data> getStudentData() {
        return studentData;
    }

    public void setStudentData(ArrayList<Data> studentData) {
        this.studentData = studentData;
    }

    public void addData(String date, String manzil, String sabaq, String sabqi) {
        this.studentData.add(new Data(date, manzil, sabaq, sabqi));
    }
}
