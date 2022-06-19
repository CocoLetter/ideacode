package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserWithAccount implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String address;
    private String sex;

    private List<Account1> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Account1> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account1> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "UserWithAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", accounts信息" + accounts.toString() +
                '}';
    }
}
