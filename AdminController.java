package com.example.hrmanagementavneet;

public class AdminController {
    public class Admin {
        private int userid;
        private String name;
        private String password;
        private String country;

        public Admin(int userid, String name, String password, String country) {
            this.userid = userid;
            this.name = name;
            this.password = password;
            this.country = country;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
