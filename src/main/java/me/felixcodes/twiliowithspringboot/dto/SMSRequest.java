package me.felixcodes.twiliowithspringboot.dto;


public class SMSRequest {

    private String phoneNumber;
    private String name;
//    private

    public SMSRequest(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public SMSRequest(){}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
