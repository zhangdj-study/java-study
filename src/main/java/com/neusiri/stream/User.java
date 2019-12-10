package com.neusiri.stream;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int userId;
    private String userName;
    private String userAddress;
    private String userPhone;
}
