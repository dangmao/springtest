package el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("el")
@PropertySource("classpath:el/test.properties")
public class ElConfig {
	@Value("test message")
	private String normal;
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{T(java.lang.Math).random()*100.0}")
	private double randomNumber;
	
	@Value("#{demoService.another}")
	private String fromAnother;
	
	@Value("classpath:el/test.txt")
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	@Value("${code.name}")
	private String codeName;
	
	@Autowired
	private Environment environment;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	public void outputResource(){
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(codeName);
			System.out.println(environment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
