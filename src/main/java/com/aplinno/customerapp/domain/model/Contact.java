package com.aplinno.customerapp.domain.model;

import java.util.regex.Pattern;

import lombok.EqualsAndHashCode;
import lombok.Getter;
@Getter
@EqualsAndHashCode
public class Contact {
    private static final Pattern PHONE_PATTERN = 
        Pattern.compile("^\\(?(\\d{2})\\)?[\\s-]?(\\d{4,5})[\\s-]?(\\d{4})$");

    private final ContactId id;
    private final String phone;
    private final String mobile;

    public Contact(String phone, String mobile) {
        this.id = ContactId.generate();
        
        if (phone != null && !PHONE_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException("Invalid phone format");
        }
        if (mobile != null && !PHONE_PATTERN.matcher(mobile).matches()) {
            throw new IllegalArgumentException("Invalid mobile format");
        }
        
        this.phone = phone;
        this.mobile = mobile;
    }

	public static Pattern getPhonePattern() {
		return PHONE_PATTERN;
	}

	public ContactId getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public String getMobile() {
		return mobile;
	}
    
    
}