package com.lx.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private Set<String> obscenities;

	public ObscenityRemovingBeanFactoryPostProcessor(Set<String> obscenities) {
		this.obscenities = new HashSet<>();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
			StringValueResolver valueResolver = strVal -> {
				if (isObscene(strVal)) return "******";
				return strVal;
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(beanDefinition);
		}
	}

	private boolean isObscene(Object value) {
		return this.obscenities.contains(value.toString().toUpperCase());
	}

	private void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		obscenities.forEach(o -> this.obscenities.add(o.toUpperCase()));
	}
}
