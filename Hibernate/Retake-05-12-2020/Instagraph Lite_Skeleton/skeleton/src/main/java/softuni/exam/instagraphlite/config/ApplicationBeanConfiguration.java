package softuni.exam.instagraphlite.config;

import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.ValidatorUtilImpl;
import softuni.exam.instagraphlite.util.XmlParser;
import softuni.exam.instagraphlite.util.XmlParserImpl;

import javax.validation.Validation;
import javax.validation.Validator;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {

        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
//                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
//                    @Override
//                    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                        return LocalDateTime
//                                .parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); }})
//                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
//                    @Override
//                    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                        return LocalDate
//                                .parse(json.getAsString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); }})
                .create();
    }

    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }

    @Bean
    public Validator validator() {

        return Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidatorUtilImpl(validator());
    }

}
