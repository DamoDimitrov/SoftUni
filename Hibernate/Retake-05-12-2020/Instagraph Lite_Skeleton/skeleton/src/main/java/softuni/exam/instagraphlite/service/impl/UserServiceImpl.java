package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.instagraphlite.util.GlobalVariables.PICTURES_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
    }


    @Override
    public Boolean аreImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(PICTURES_PATH)));
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
