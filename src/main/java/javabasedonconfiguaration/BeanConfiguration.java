package javabasedonconfiguaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.AccountRepository;
import pojo.AccountRepositoryIml;
import pojo.AccountService;
import pojo.AccountServiceIml;
@Configuration
public class BeanConfiguration {

    @Bean
    public AccountService accountService() {
        AccountServiceIml bean = new AccountServiceIml();
        bean.setAccountRepository(accountDao());
        return bean;
    }

    @Bean
    public AccountRepository accountDao() {
        AccountRepositoryIml bean = new AccountRepositoryIml();
        return bean;
    }
}
