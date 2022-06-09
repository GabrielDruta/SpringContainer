package beans.properties;

public class BeanWithPropertiesInjectedFromXml {

    final private String constructorProperty;
    private int simpleProperty;

    public BeanWithPropertiesInjectedFromXml() {
        simpleProperty=-1;
        constructorProperty="xxx";
    }

    public BeanWithPropertiesInjectedFromXml(String constructorProperty) {
        this.constructorProperty = constructorProperty;
    }

    public String getConstructorProperty() {
        return constructorProperty;
    }

    public int getSimpleProperty() {
        return simpleProperty;
    }

    public void setSimpleProperty(int simpleProperty) {
        this.simpleProperty = simpleProperty;
    }
}
