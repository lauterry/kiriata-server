package lu.sfeir.sigi.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * To allow our Java classes to access the properties from the same object as spring,
 * we’ll need to extend the PropertyPlaceholderConfigurer so that we can provide a more
 * convenient method for retrieving the properties (there is no direct method of retrieving properties!).
 * We can extend the spring provided class to allow us to reuse spring’s property resolver in our Java classes
 * If we now update the applicationProperties bean to use the PropertiesUtil class, we can use the static
 * getProperty method to access the resolved properties via the same object as the spring configuration bean.
 * @see "http://codingbone.wordpress.com/2010/02/28/how-to-load-properties-files-into-spring-and-expose-to-the-java-classes/"
 */
public class SpringPropertyUtils extends PropertyPlaceholderConfigurer {
    private static Map properties = new HashMap();

    @Override
    protected void loadProperties(final Properties props) throws IOException {
        super.loadProperties(props);
        for (final Object key : props.keySet()) {
            properties.put((String) key, props.getProperty((String) key));
        }
    }

    /**
     * Return a property loaded by the place holder.
     * @param name the property name.
     * @return the property value.
     */
    public static String getProperty(final String name) {
        Object property = properties.get(name);
        return property == null ? "" : property.toString();
    }
}