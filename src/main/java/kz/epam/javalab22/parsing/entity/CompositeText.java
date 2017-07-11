package kz.epam.javalab22.parsing.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeText implements Text {
    private List<Text> childComponent = new ArrayList<Text>();

    public void add(Text component){
        childComponent.add(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Text component: childComponent){
            sb.append(component.toString());
        }

        return String.valueOf(sb);
    }

    public List<Text> getChildComponent() {
        return childComponent;
    }
}
