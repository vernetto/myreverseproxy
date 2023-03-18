package org.pierre.myreverseproxy;
import com.github.mkopylec.charon.configuration.CharonConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.mkopylec.charon.configuration.CharonConfigurer.charonConfiguration;
import static com.github.mkopylec.charon.configuration.RequestMappingConfigurer.requestMapping;
import static com.github.mkopylec.charon.forwarding.interceptors.rewrite.RequestServerNameRewriterConfigurer.requestServerNameRewriter;

@Configuration
class CharonConfiguration {

    @Bean
    CharonConfigurer charonConfigurer() {
        return charonConfiguration()
                .set(requestServerNameRewriter().outgoingServers("localhost:10090"))
                .add(requestMapping("all requests mapping").pathRegex("/status"));
    }
}