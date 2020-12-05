package softuni.exam.instagraphlite.service.impl;

import softuni.exam.instagraphlite.service.UserService;

import java.io.IOException;

public class UserServiceImpl implements UserService {
    @Override
    public Boolean аreImported() {
        return false;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return null;
    }

    @Override
    public String importUsers() throws IOException {
        return null;
    }

    @Override
    public String exportUsersWithTheirPosts() {
        return null;
    }
}
