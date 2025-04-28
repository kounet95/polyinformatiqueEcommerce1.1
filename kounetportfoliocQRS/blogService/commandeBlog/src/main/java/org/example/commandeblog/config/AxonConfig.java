package org.example.commandeblog.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public XStream xStream() {
        XStream xStream = new XStream();
        
        // Clear out existing permissions
        xStream.addPermission(NoTypePermission.NONE);
        
        // Allow any classes from our commands package
        xStream.addPermission(new WildcardTypePermission(new String[] {
            "org.example.polyinformatiquecoreapi.commands.**",
            "org.example.polyinformatiquecoreapi.dto.**",
            "org.example.polyinformatiquecoreapi.events.**",
            "org.example.polyinformatiquecoreapi.queries.**",
            "java.util.**",
            "java.lang.**",
            "java.time.**"
        }));
        
        return xStream;
    }
    
    @Bean
    @Primary
    public XStreamSerializer xStreamSerializer(XStream xStream) {
        return XStreamSerializer.builder()
                .xStream(xStream)
                .build();
    }
}