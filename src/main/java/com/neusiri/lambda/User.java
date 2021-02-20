package com.neusiri.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userAddress;
    private String userPhone;
    private List<String> bankCards;

    public User(int userId, String userName, String userAddress, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("即将被回收" + this);
    }
}
