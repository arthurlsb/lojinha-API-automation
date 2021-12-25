package dataFactory;

import pojo.UserPojo;

public class UserDataFactory {
    public static UserPojo createUser (String login, String password) {
        UserPojo user = new UserPojo();
        user.setUsuarioLogin("admin");
        user.setUsuarioSenha("admin");

        return user;

    }
}
