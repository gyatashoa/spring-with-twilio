package me.felixcodes.twiliowithspringboot.dto;


public class SMSRequest {

    final private String phone;

    public SMSRequest(String phoneNumber) {
        this.phone = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phone;
    }
}
