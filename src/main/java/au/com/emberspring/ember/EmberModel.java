package au.com.emberspring.ember;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.atteo.evo.inflector.English;
import org.springframework.util.Assert;

import com.google.common.base.CaseFormat;


@SuppressWarnings("serial")
public final class EmberModel extends ConcurrentHashMap<String, Object> {
	
	private EmberModel() {
		//Must use the builder
	}
	
	public static class Builder implements au.com.emberspring.patterns.Builder<EmberModel> {

		private ConcurrentMap<String, Object> sideLoadedItems = new ConcurrentHashMap<String, Object>();
		private ConcurrentMap<String, Object> metaData = new ConcurrentHashMap<String, Object>(); 
		
		public Builder(Object entity) {
			Assert.notNull(entity);
			sideLoad(entity);
		}
		
		public Builder(Class<?> clazz, Collection<?> entities) {
			Assert.notNull(entities);
			sideLoad(clazz, entities);
		}
		
		public Builder addMeta(String key, Object value) {
			metaData.put(key, value);
			return this;
		}
		
		public Builder sideLoad(Object entity) {
			sideLoadedItems.put(getSingularName(entity.getClass()), entity);
			return this;
		}
		
		public Builder sideLoad(Class<?> clazz, Collection<?> entities) {
			sideLoadedItems.put(getPluralName(clazz), entities);
			return this;
		}
		
		private final String getSingularName(Class<?> clazz) {
			Assert.notNull(clazz);
			return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, clazz.getSimpleName());
		}
		
		private final String getPluralName(Class<?> clazz) {
			return English.plural(getSingularName(clazz));
		}
		
		@Override
		public EmberModel build() {
			
			if(metaData.size() > 0) {
				sideLoadedItems.put("meta", metaData);				
			}
			
			EmberModel sideLoader = new EmberModel();
			sideLoader.putAll(sideLoadedItems);
			return sideLoader;
		}
		
	}
}
