package beans.injections.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectionTarget {

    @Autowired
    private FieldDependency fieldDependency;

    private SetterDependency setterDependency;

    final private ConstructorDependency constructorDependency;

    private boolean setterUsedInInjection=false;
    private boolean constructorUsedInInjection = false;


    public InjectionTarget(ConstructorDependency constructorDependency) {
        this.constructorDependency = constructorDependency;
        constructorUsedInInjection = true;
    }

    @Autowired
    public void setSetterDependency(SetterDependency setterDependency) {
        this.setterDependency = setterDependency;
        setterUsedInInjection=true;
    }

    public boolean isSetterUsedInInjection() {
        return setterUsedInInjection;
    }

    public boolean isConstructorUsedInInjection() {
        return constructorUsedInInjection;
    }

    public FieldDependency getFieldDependency() {
        return fieldDependency;
    }

    public SetterDependency getSetterDependency() {
        return setterDependency;
    }

    public ConstructorDependency getConstructorDependency() {
        return constructorDependency;
    }
}
