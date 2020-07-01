package com.neusiri.designmode.builder;

/**
 * @author zhangdj
 * @date 2020-07-01 14:33
 */
public class User {

    private Long id;
    private String name;
    private String address;
    private Integer age;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.address = userBuilder.address;
        this.age = userBuilder.age;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    static class UserBuilder {
        private Long id;
        private String name;
        private String address;
        private Integer age;


        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.UserBuilder().age(12).address("北京").name("张三").build();
        System.out.println(user);
    }
}
