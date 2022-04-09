package com.mark.springbootmarkopensource.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.mark.springbootmarkopensource.utils.OperatorHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;


/**
 * @author wenxue.mei@capgemini.com
 * @ClassName: MybatisPlusConfig
 */
@Configuration
@MapperScan("com.mark.springbootmarkopensource.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Autowired
    private OperatorHelper operatorHelper;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }


    @Bean
    public OperatorHelper operatorHelper() {
        return new OperatorHelper() {
            private final ThreadLocal<String> localOperator = new ThreadLocal<>();
            @Override
            public void setOperator(String operator) {
                localOperator.set(operator);
            }

            @Override
            public String getOperator() {
                return localOperator.get();
            }
        };
    }

    /**
     * 配置自动填充
     *
     * @return
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                // 数据类型要与fileName一致
                this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "createBy", String.class, operatorHelper.getOperator());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                // 数据类型要与fileName一致
                this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
                this.strictUpdateFill(metaObject, "updateBy", String.class, operatorHelper.getOperator());
            }
        };
    }

}