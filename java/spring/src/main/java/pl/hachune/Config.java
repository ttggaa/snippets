package pl.hachune;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.DefaultAcsClient;

import pl.hachune.models.Person;

@Configuration
@PropertySources(
  value = {
    @PropertySource("classpath:config.properties"),
    @PropertySource(value="file:${config}", ignoreResourceNotFound=true)
  }
)
@EnableScheduling
@ComponentScan(basePackages="pl.hachune.scheduling")
public class Config {

  private static final Logger LOGGER =
    LoggerFactory.getLogger(Config.class);

  private ResourcePatternResolver resolver =
    new PathMatchingResourcePatternResolver(getClass().getClassLoader());

  @Value("${aliyun.access.key}")
  public String aliyunKey;

  @Value("${aliyun.access.secret}")
  public String aliyunSecret;

  @Bean("acsClient")
  public IAcsClient acsClient() {

    LOGGER.debug("aliyun.access.key: {}", aliyunKey);
    LOGGER.debug("aliyun.access.secret: {}", aliyunSecret);

    IClientProfile profile = DefaultProfile.getProfile(
        "cn-hangzhou", aliyunKey, aliyunSecret);
    IAcsClient rv = new DefaultAcsClient(profile);
    return rv;
  }

  @Bean
  public List<Person> persons() {
    List<Person> rv = new ArrayList<Person>();

    Person p;
    p = new Person();
    p.setName("p1");
    rv.add(p);
    p = new Person();
    p.setName("p2");
    rv.add(p);
    p = new Person();
    p.setName("p3");
    rv.add(p);

    return rv;
  }

}
