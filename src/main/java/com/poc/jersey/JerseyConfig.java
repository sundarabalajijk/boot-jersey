package com.poc.jersey;

import java.util.stream.Collectors;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class JerseyConfig extends ResourceConfig {
	
	private static final String PACKAGE_SCAN = "com.poc.jersey";
	
	public JerseyConfig() {
		register(MultiPartFeature.class);
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        // add more annotation filters if you need
        registerClasses(scanner.findCandidateComponents(PACKAGE_SCAN).stream()
                .map(t -> ClassUtils.resolveClassName(t.getBeanClassName(), this.getClassLoader()))
                .collect(Collectors.toSet()));
        // To scan in next filter when URL not found by Jersey
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
    }
}
