package softuni.exam.instagraphlite.config;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.instagraphlite.util.ValidatorUtil;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return null;
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return null;
    }

    @Bean
    public ModelMapper modelMapper() {
        return null;
    }

}
