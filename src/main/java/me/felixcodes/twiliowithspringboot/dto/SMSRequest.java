package me.felixcodes.twiliowithspringboot.dto;


public class SMSRequest {

    private String phoneNumber;

    public SMSRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SMSRequest(){}

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
}
